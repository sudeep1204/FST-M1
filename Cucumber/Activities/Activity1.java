package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity1 {
    public class GoogleSearchSteps {
        WebDriver driver;
        WebDriverWait wait;

        @Given("^User is on Google Home Page$")
        public void user_Is_On_Google_Page() throws Throwable {
            driver = new FirefoxDriver();
            wait = new WebDriverWait(driver, 15);


            driver.get("https://www.google.com");
        }

        @When("^User types in Cheese and hits ENTER$")
        public void user_Types_In_Cheese_And_Hits_ENTER() throws Throwable {
            driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
        }

        @Then("^Show how many search results were shown$")
        public void show_How_Many_Search_Results_Were_Shown() throws Throwable {
            wait.until( ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
            String resultStats = driver.findElement(By.id("result-stats")).getText();
            System.out.println("Number of results found: " + resultStats);
        }

        @And("^quit the browser$")
        public void close_The_Browser() throws Throwable {
            driver.quit();
        }
    }
}
