package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity2 {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }


    @Test
    public void test1(){
        String title = driver.getTitle();
        System.out.println("Title is : "+title);
        Assert.assertEquals("Target Practice", title);
    }

    @Test
    public void test2(){
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertFalse(blackButton.isDisplayed());
    }

    @Test(enabled = false)
    public void test3(){
        String title = driver.getTitle();
        System.out.println("Title is : "+title);
        Assert.assertEquals("Training Support", title);
    }

    @Test
    public void test4(){
        throw new SkipException("Skipping test case");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
