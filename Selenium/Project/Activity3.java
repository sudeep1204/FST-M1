package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
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
    public void getImageURL() {
        // Check the title of the page
        WebElement img = driver.findElement(By.xpath("//*[@id=\"post-16\"]/header/div/img"));
        System.out.println("Src attribute is: "+ img.getAttribute("src"));
    }

    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }

}
