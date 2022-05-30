package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {
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
    public void postJobs() throws InterruptedException {
        // Check the title of the page
        WebElement PostJobs = driver.findElement(By.xpath("//*[contains(text(),'Post a Job')]"));
        PostJobs.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Sign')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@name=\"log\"]")).sendKeys("root");
        driver.findElement(By.xpath("//*[@type=\"password\"]")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@name=\"wp-submit\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@name=\"job_title\"]")).sendKeys("Test IBM Panthor");
        driver.findElement(By.xpath("//*[@id=\"job_description_ifr\"]")).sendKeys("Test Automate project Job board");
        driver.findElement(By.xpath("//*[@id=\"submit-job-form\"]/p/input[4]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"job_preview_submit_button\"]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/jobs/jobs/\"]")).click();
        driver.findElement(By.xpath("//*[@name=\"search_keywords\"]")).sendKeys("Test IBM Panthor");
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        Thread.sleep(3000);

        WebElement jobSearch= driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/ul/li[1]/a/div[1]/h3"));
        Assert.assertTrue(jobSearch.isDisplayed());
        Assert.assertEquals(jobSearch.getText(), "Test IBM Panthor");





    }

    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }
}
