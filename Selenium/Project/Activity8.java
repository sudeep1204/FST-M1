package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
    private WebDriver Driver;
    private FirefoxDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();


        driver.get("https://alchemy.hguy.co/jobs/wp-admin/");
    }

    @Test
    public void loginSiteBackend() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("root");
        driver.findElement(By.xpath("//*[@id=\"user_pass\"]")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
        Thread.sleep(4000);
        WebElement activity= driver.findElement(By.xpath("//*[@id=\"dashboard_activity\"]/h2"));
        Assert.assertTrue(activity.isDisplayed());
        Assert.assertEquals(activity.getText(), "Activity");


        }
    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }





}
