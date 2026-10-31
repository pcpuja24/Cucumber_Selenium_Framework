package StepDefinition;

import HooksClass.Hooks;
import Pages.DashboardPage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginStepdef {
   private WebDriver driver;

    LoginPage loginPage;
    DashboardPage dashboardPage;
    @Given("user navigated to login page of orange portal")
    public void user_navigated_to_login_page_of_orange_portal()
    {
        driver = Hooks.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("================================");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("================================");

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }
    @When("user enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String username, String password)
    {
      loginPage.enterUsername(username);
      loginPage.enterPassword(password);
      loginPage.login();
    }
    @Then("user should be redirected to dashboard page")
    public void user_should_be_redirected_to_dashboard_page()
    {
        //visibility of element
        boolean isDashboardVisible = dashboardPage.isDashboardFieldVisisble();
        Assert.assertTrue(isDashboardVisible);

        //visibility of url
        Assert.assertEquals("Current Url is not matched","https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", driver.getCurrentUrl());
    }
    // multiple user login scenario
    @When("user enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String user, String pass)
    {
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
        loginPage.login();
        System.out.println("Invalid credentials are provided");
    }
    @Then("user verifies error message as {string}")
    public void user_verifies_error_message_as(String expectedError)
    {
        String actualError = loginPage.getErrorText();
        Assert.assertEquals("expected text is not matched",expectedError, actualError);
    }
}
