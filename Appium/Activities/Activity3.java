package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {

    private AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("noReset", true);


        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void add(){
        driver.findElementById("digit_5").click();
        driver.findElementByAccessibilityId("plus").click();
        driver.findElementById("digit_9").click();
        driver.findElement(MobileBy.id("eq")).click();
        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println("Result is : "+result);
        Assert.assertEquals(result, "14");
    }

    @Test
    public void sub(){
        driver.findElementById("digit_1").click();
        driver.findElementById("digit_0").click();
        driver.findElementByAccessibilityId("minus").click();
        driver.findElementById("digit_5").click();
        driver.findElement(MobileBy.id("eq")).click();
        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println("Result is : "+result);
        Assert.assertEquals(result, "5");
    }

    @Test
    public void mul(){
        driver.findElementById("digit_5").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementById("digit_1").click();
        driver.findElementById("digit_0").click();
        driver.findElementById("digit_0").click();
        driver.findElement(MobileBy.id("eq")).click();
        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println("Result is : "+result);
        Assert.assertEquals(result, "500");
    }

    @Test
    public void div(){
        driver.findElementById("digit_5").click();
        driver.findElementById("digit_0").click();
        driver.findElementByAccessibilityId("divide").click();
        driver.findElementById("digit_2").click();
        driver.findElement(MobileBy.id("eq")).click();
        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println("Result is : "+result);
        Assert.assertEquals(result, "25");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}


