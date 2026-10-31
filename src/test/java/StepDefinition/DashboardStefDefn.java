package StepDefinition;

import HooksClass.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class DashboardStefDefn {
    WebDriver driver = Hooks.getDriver();
    @Then("User should see following dashboard menu items")
    public void user_should_see_following_dashboard_menu_items(List<String> expectedMenuItems)
    {
        //step 1: Storing all menuitems in webelement List
        List<WebElement> menuItems = driver.findElements(By.cssSelector("ul.oxd-main-menu > li span.oxd-text"));

        List<String> actualMenuItems = menuItems.stream().map(WebElement::getText).collect(Collectors.toList());

        for(String expectedItems:expectedMenuItems){
            Assert.assertTrue("Dashboard menu missing: "+expectedItems,actualMenuItems.contains(expectedItems));
        }
    }

}
