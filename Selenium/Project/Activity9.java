package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
    private WebDriver Driver;
    private FirefoxDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/jobs/wp-admin/");
    }

    @Test
    public void loginSiteBackend() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("root");
        driver.findElement(By.xpath("//*[@id=\"user_pass\"]")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class=\"wp-menu-name\"]/ancestor::a[@href=\"edit.php?post_type=job_listing\"]")).click();
        driver.findElement(By.xpath("//a[@class=\"page-title-action\"]")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//*[@id=\"toolbar-5d251272-0834-4065-82c3-00e2ca2edd8d\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"editor-5d251272-0834-4065-82c3-00e2ca2edd8d\"]")).sendKeys("CEO");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement companyName = driver.findElement(By.xpath("//*[@id=\"_company_name\"]"));
        js.executeScript("arguments[0].scrollIntoView();", companyName);
        companyName.sendKeys("Test IBM Job data");
        driver.findElement(By.xpath("//*[@id=\"_company_tagline\"]")).sendKeys("Test for the better reliable");
        driver.findElement(By.xpath("//*[@id=\"_company_twitter\"]")).sendKeys("//*[@id=\"_company_twitter\"]");
        driver.findElement(By.xpath("//*[@id=\"editor\"]/div/div/div[1]/div/div[1]/div/div[2]/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"editor\"]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();



    }
    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }

}
