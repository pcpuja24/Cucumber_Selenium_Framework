package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //constructor
    public LoginPage(WebDriver driver)
    {
        this.driver =driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Username

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = xpath("//button[contains(.,'Login')]");
    private By errorText = xpath("//p[contains(.,'Invalid credentials')]");

    //actionable items
    public void enterUsername(String username){
        WebElement usernameElement = wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
        usernameElement.clear();
        usernameElement.sendKeys(username);
        System.out.println("Username entered successfully");
    }
    public void enterPassword(String password){
        WebElement passwordElement = wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        passwordElement.clear();
        passwordElement.sendKeys(password);
        System.out.println("Password entered successfully");
    }
    public void login(){

        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
    public String getErrorText(){

        return wait.until(ExpectedConditions.presenceOfElementLocated(errorText)).getText();
    }
}
