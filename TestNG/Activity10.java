package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity10 {
    private WebDriver driver;
    Actions actions;

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        actions = new Actions(driver);
        driver.get("https://www.training-support.net/selenium/sliders");
    }

    @Test
    public void middleValue(){
        WebElement slider = driver.findElement(By.id("slider"));
        slider.click();

        String level = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Middle value : "+level);
        Assert.assertEquals(level,"50");
    }

    @Test
    public void maxValue(){
        WebElement slider = driver.findElement(By.id("slider"));
        actions.dragAndDropBy(slider,100,0).perform();
        String level = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Maximum value : "+level);
        Assert.assertEquals(level,"100");
    }

    @Test
    public void minValue(){
        WebElement slider = driver.findElement(By.id("slider"));
        actions.dragAndDropBy(slider,-100,0).perform();
        String level = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Minimum value : "+level);
        Assert.assertEquals(level,"0");
    }

    @Test
    public void value30(){
        WebElement slider = driver.findElement(By.id("slider"));
        actions.dragAndDropBy(slider,-30,0).perform();
        String level = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Moved value : "+level);
        Assert.assertEquals(level,"30");
    }

//    @Test
//    public void value80(){
//        WebElement slider = driver.findElement(By.id("slider"));
//        actions.dragAndDropBy(slider,40,0).perform();
//        String level = driver.findElement(By.cssSelector("span#value")).getText();
//        Reporter.log("Moved value : "+level);
//        Assert.assertEquals(level,"80");
//    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
