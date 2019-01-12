import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/MYPC/workspace/CucumberProject/src/test/resources/com/qtpselenium/rediff/Portfolio.feature:32"},
        plugin = {"json:C:/Users/MYPC/workspace/CucumberProject/target/cucumber-parallel/3.json", "html:C:/Users/MYPC/workspace/CucumberProject/target/cucumber-parallel/3"},
        monochrome = true,
        glue = {"com.CucumberProject.steps"})
public class Parallel03IT {
}
