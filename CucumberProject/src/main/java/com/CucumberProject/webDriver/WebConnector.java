package com.CucumberProject.webDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CucumberProject.reports.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import static org.assertj.core.api.Assertions.*;


public class WebConnector {

	WebDriver driver;
	public String name;
	public Properties prop;
	public ExtentReports rep;
	public ExtentTest scenario;
	
	public WebConnector()
	{

		name="A";
		if(prop==null)
		{
			try {
				prop=new Properties();
				FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties");
				prop.load(fs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public void initReports(String scenarioName)
	{
		rep=ExtentManager.getInstance(prop.getProperty("report_path"));
		scenario=rep.createTest(scenarioName);
		scenario.log(Status.INFO, "Starting Scenario "+scenarioName);
	}

	public void openBrowser(String browserName) {
		
		if(browserName.equals("Mozilla"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
			
			DesiredCapabilities cap=new DesiredCapabilities();
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			cap.setCapability("marionette", false);
			
			 driver=new FirefoxDriver(cap);
		}
		else if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			
			DesiredCapabilities cap=new DesiredCapabilities();
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			cap.setCapability("marionette", false);
			
			 driver=new ChromeDriver(cap);
		}
		infoLog("Opened Browser--"+browserName);
		
	}

	public void navigate(String url) {

		driver.manage().deleteAllCookies();
		System.out.println(prop.getProperty(url));
		driver.get(prop.getProperty(url));
	}
	
	public void click(String ObjectKey)
	{
		getObject(ObjectKey).click();
	}
	
	public void clear(String objectKey) {
		getObject(objectKey).clear();
	}
	
	public void type(String ObjectKey,String data)
	{
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getObject(ObjectKey).sendKeys(data);
	}
	
	public WebElement getObject(String objectKey)
	{
		WebElement e=null;
		try
			{
				
				WebDriverWait wait=new WebDriverWait(driver,40);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty(objectKey))));
				e= driver.findElement(By.xpath(prop.getProperty(objectKey)));
			}catch(Exception ex)
			{
				ex.printStackTrace();
			reportFailure("Unable to Extract Object "+objectKey);
			}
		return e;
	}

	public void Login(String username, String password) {
		type("username",username);
		click("continueButton");
		type("password",password);
		click("loginSubmit");
		
	}

	public boolean IsElementPresent(String objectKey) {
	
		List<WebElement> e=null;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		e=driver.findElements(By.xpath(prop.getProperty(objectKey)));
		if(e.size()==0)
			return false;
			else
			return true;
		
	}
	
	public void ValidateLogin(String ExpectedResult)
	{
		boolean result=	IsElementPresent("portfolio_sectionId");
		String actualResult="";
		
		if(result)
			actualResult="Success";
		else
			actualResult="Fail";
		
		infoLog("Expected Result was--"+ExpectedResult);
		infoLog("Actual Result is---"+actualResult);
		
		if(!actualResult.equals(ExpectedResult))
			reportFailure("Scenario Failed");
			
	}
	
	/************************************Logging*********************/
	public void infoLog(String msg)
	{
		scenario.log(Status.INFO, msg);
	}
	
	public void reportFailure(String errmsg)
	{
		scenario.log(Status.FAIL, errmsg);
		takeSceenShot();
//		assertThat(false);
	}
	
	public void takeSceenShot(){
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// take screenshot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name
			FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
			//put screenshot file in reports
			scenario.log(Status.FAIL,"Screenshot-> "+ scenario.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public void acceptAlertIfPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}catch(Exception e) {
			// not present
		}
	}
	
	public void select(String objectKey,String data) {
		Select s= new Select(getObject(objectKey));
		s.selectByVisibleText(data);
	}
	
	public void clickAndWait(String xpathExpTarget, String xpathExpWait, int maxTime){
		for(int i=0;i<maxTime;i++){
			// click
			getObject(xpathExpTarget).click();
			// check presence of other ele
			if(IsElementPresent(xpathExpWait) && driver.findElement(By.xpath(prop.getProperty(xpathExpWait))).isDisplayed()){
				// if present - success.. return
				return;
			}else{
				// else wait for 1 sec
				wait(1);
			}
			
		}
		// 10 seconds over - for loop - comes here
		reportFailure("Target element coming after clicking on "+xpathExpTarget );
	}
	
		public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
			int i=0;
			
			while(i!=10){
			String state = (String)js.executeScript("return document.readyState;");
			System.out.println(state);

			if(state.equals("complete"))
				break;
			else
				wait(2);

			i++;
			}
			// check for jquery status
			i=0;
			while(i!=10){
		
				Long d= (Long) js.executeScript("return jQuery.active;");
				System.out.println(d);
				if(d.longValue() == 0 )
				 	break;
				else
					 wait(2);
				 i++;
					
				}
			
	}
    

	public void wait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/************************************Reporting*********************/
	public void quit() {
		if(rep!=null)
			rep.flush();
		
	}
}
