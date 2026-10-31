package StepDefinition;

import SeleniumJava.TestJava;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    TestJava testJava = new TestJava();
        @Given("An empty employee list$")
        public void anEmptyEmployeeList()
        {
            testJava.setUp("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        }

         @When("An employee is added in list")
         public void anEmployeeIsAddedInList()
         {
          testJava.login();
         }

    @Then("The employee added to list is visible or not")
    public void theEmployeeAddedToListIsVisibleOrNot()
    {
     testJava.teardown();
    }
}
