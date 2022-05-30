package Project;

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
import java.util.List;


public class Activity2 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 5);

    }

    @Test
    public void test1() throws InterruptedException {
        String stitle = "Complete Activity";
        String snote = "With Google Keep";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
        MobileElement createNote = driver.findElementByAccessibilityId("New text note");
        createNote.click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("editable_title")));
        MobileElement title = driver.findElementById("editable_title");
        MobileElement note = driver.findElementById("edit_note_text");
        title.sendKeys(stitle);
        note.sendKeys(snote);
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
        List<MobileElement> numberOfTasks = driver.findElementsById("browse_note_interior_content");
        System.out.println("Total Notes added "+numberOfTasks.size());
        Assert.assertEquals(numberOfTasks.size(),1);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
