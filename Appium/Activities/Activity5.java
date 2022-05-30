package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity5 {

    private AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");
        caps.setCapability("noReset", true);

        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void sendMsg(){
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Start new conversation")));
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();

        String contactBox = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(contactBox)));
        driver.findElement(MobileBy.AndroidUIAutomator(contactBox)).sendKeys("9066561288");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        String composeMsg = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(composeMsg)));
        driver.findElement(MobileBy.AndroidUIAutomator(composeMsg)).sendKeys("Test Message");
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send SMS\")")).click();

        String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(messageLocator)));

        // Assertion
        String sentMessage = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessage, "Test Message");

    }



//    @AfterClass
//    public void tearDown(){
//
//        driver.quit();
//    }
}


