package HooksClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Hooks {
    static WebDriver driver;
    static ExtentReports extent;
    static ExtentTest test;

    @Before(order = 0)
    public void setupExtentReport()
    {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("reports/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS",System.getProperty("os.name"));
        extent.setSystemInfo("Java version",System.getProperty("java.version"));
    }

    @Before(order = 1)
    public void setUp(){
        String browser = "chrome";
        //launch browser
        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge" :
                driver = new EdgeDriver();
                break;
            default:
                driver = null;
                break;
        }
    }
    @Before(order = 2)
    public void startExtentTest(Scenario scenario)
    {
        test = extent.createTest(scenario.getName());
    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            takeScreenshot(scenario);
            test.fail("scenario failed");
        }
        else {
            test.pass("scenario passed");
        }
        extent.flush();
        driver.quit();
    }

    private void takeScreenshot(Scenario scenario) {
        try {
            // Screenshot folder
            String screenshotFolder = "reports/screenshots/";

            // Create folder if it doesn't exist
            Path path = Paths.get(screenshotFolder);
            Files.createDirectories(path);

            // Create screenshot file name
            String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
            String filePath = screenshotFolder + scenarioName + ".png";

            // Take screenshot
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Save screenshot
            Files.copy(source.toPath(), Paths.get(filePath));

            // Also attach screenshot to Cucumber report
            byte[] screenshot = Files.readAllBytes(source.toPath());
            scenario.attach(screenshot, "image/png", scenario.getName());
            System.out.println("Screenshot saved at: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver(){ return driver; }

}
