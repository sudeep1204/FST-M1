package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity1 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }


    @Test
    public void act1(){
        String title = driver.getTitle();
        System.out.println("Title is : "+title);
        Assert.assertEquals("Training Support", title);

        driver.findElement(By.cssSelector("#about-link")).click();
        String newTitle = driver.getTitle();
        System.out.println("New Title is: "+newTitle);
        Assert.assertEquals("About Training Support", newTitle);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
