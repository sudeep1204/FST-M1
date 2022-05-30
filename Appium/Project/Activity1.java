package Project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class Activity1 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 5);

    }

    @Test
    public void test1() throws InterruptedException {
        String task1 = "Complete Activity with Google Tasks";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
        MobileElement createTask = driver.findElementByAccessibilityId("Create new task");
        createTask.click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        MobileElement taskBox = driver.findElementById("add_task_title");
        MobileElement saveBtn = driver.findElementById("add_task_done");
        taskBox.sendKeys(task1);
        saveBtn.click();
    }

    @Test
    public void test2() throws InterruptedException {
        String task2 = "Complete Activity with Google Keep";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
        MobileElement createTask = driver.findElementByAccessibilityId("Create new task");
        createTask.click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        MobileElement taskBox = driver.findElementById("add_task_title");
        MobileElement saveBtn = driver.findElementById("add_task_done");
        taskBox.sendKeys(task2);
        saveBtn.click();
       }

    @Test
    public void test3() throws InterruptedException {
        String task3 = "Complete the second Activity Google Keep";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
        MobileElement createTask = driver.findElementByAccessibilityId("Create new task");
        createTask.click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        MobileElement taskBox = driver.findElementById("add_task_title");
        MobileElement saveBtn = driver.findElementById("add_task_done");
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        taskBox.sendKeys(task3);
        saveBtn.click();
    }

    @Test
    public void testTasks(){
        List<MobileElement> numberOfTasks = driver.findElementsById("task_name");
        System.out.println("Total tasks added "+numberOfTasks.size());
        Assert.assertEquals(numberOfTasks.size(),3);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
