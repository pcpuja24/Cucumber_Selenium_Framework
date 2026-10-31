package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage
{
    private WebDriver driver;
    private WebDriverWait wait;
    //constructor
    public DashboardPage(WebDriver driver)
    {
        this.driver =driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private By dashboardField = By.xpath("//h6[contains(.,'Dashboard')]");

    public boolean isDashboardFieldVisisble(){

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(dashboardField)
        ).isDisplayed();
    }
}
