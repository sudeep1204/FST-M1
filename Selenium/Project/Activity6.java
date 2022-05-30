package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
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
    public void applyJobs() throws InterruptedException {
        // Check the title of the page
        WebElement Jobs = driver.findElement(By.xpath("//*[@id=\"menu-item-24\"]/a"));
        Jobs.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Jobs')]")));

        driver.findElement(By.xpath("//*[@name=\"search_keywords\"]")).sendKeys("IT");
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/ul/li[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='application_button button']")).click();
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//*[contains(text(),'abhiram@cklabs.com')]"));
        String s = email.getText();
        System.out.println("Email is : " + s);



    }


    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }
}
