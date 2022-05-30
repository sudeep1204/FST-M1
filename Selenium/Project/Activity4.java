package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
    private WebDriver Driver;
    private FirefoxDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void getSecondHeading() {
        // Check the title of the page
        WebElement secondHeading= driver.findElement(By.xpath("//*[@id=\"post-16\"]/div/h2"));
        Assert.assertTrue(secondHeading.isDisplayed());
        Assert.assertEquals(secondHeading.getText(), "Quia quis non");
    }
    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }

}
