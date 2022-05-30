package activities;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
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
    public void getPageHeading() {
        // Check the title of the page
        WebElement heading = driver.findElement(By.xpath("//*[@id=\"post-16\"]/header/h1"));
        String s = heading.getText();
        System.out.println("Text content is : " + s);
    }
    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }







}
