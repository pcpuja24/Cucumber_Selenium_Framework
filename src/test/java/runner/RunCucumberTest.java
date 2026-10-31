package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\Admin\\IdeaProjects\\Cucumber_Selenium\\src\\test\\resources\\Features\\Day6Feature.feature",
        glue = {"StepDefinition", "HooksClass"},
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"
                , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class RunCucumberTest {

}
