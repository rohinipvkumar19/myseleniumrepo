import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/MYPC/workspace/CucumberProject/src/test/resources/com/qtpselenium/rediff/Login.feature:34"},
        plugin = {"json:C:/Users/MYPC/workspace/CucumberProject/target/cucumber-parallel/2.json", "html:C:/Users/MYPC/workspace/CucumberProject/target/cucumber-parallel/2"},
        monochrome = true,
        glue = {"com.CucumberProject.steps"})
public class Parallel02IT {
}
