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

public class Activity4 {

    private AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.PeopleActivity");
        caps.setCapability("noReset", true);

        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void addContact(){
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("floating_action_button_container")));
        driver.findElementById("floating_action_button_container").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='First name']")));

        MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
        MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Last name']");
        MobileElement phone = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");

        firstName.sendKeys("Aaditya");
        lastName.sendKeys("Varma");
        phone.sendKeys("9991284782");

        driver.findElementById("editor_menu_save_button").click();
        driver.navigate().back();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));

        MobileElement mobileCard = driver.findElementById("toolbar_parent");
        Assert.assertTrue(mobileCard.isDisplayed());

        String contactName = driver.findElementById("cliv_name_textview").getText();
        Assert.assertEquals(contactName, "Aaditya Varma");
    }



//    @AfterClass
//    public void tearDown(){
//
//        driver.quit();
//    }
}


