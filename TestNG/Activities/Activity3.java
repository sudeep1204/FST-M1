package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }


    @Test
    public void loginTest(){
       WebElement username = driver.findElement(By.id("username"));
       WebElement password = driver.findElement(By.id("password"));
       WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Log in']"));

       username.sendKeys("admin");
       password.sendKeys("password");
       loginBtn.click();

       String message = driver.findElement(By.id("action-confirmation")).getText();
       Assert.assertEquals("Welcome Back, admin" , message);
    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
