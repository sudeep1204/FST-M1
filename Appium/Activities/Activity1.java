package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {

    private AndroidDriver<MobileElement> driver;

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
    }

    @Test
    public void act1(){

        driver.findElementById("digit_6").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByXPath("//android.widget.Button[@text='8']").click();
        driver.findElement(MobileBy.id("eq")).click();
        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println("Result is : "+result);
        Assert.assertEquals(result, "48");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}


