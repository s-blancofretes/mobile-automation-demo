import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Author: santiago.blanco
 * Date: 18/8/21
 */
public class CalculatorTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException{
        //Set Desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        capabilities.setCapability("noReset","true");

        //Create driver
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void test() throws Exception {
        //Mapping of WebElements
        WebElement five = driver.findElement(By.id("digit_5"));
        WebElement eight = driver.findElement(By.id("digit_8"));
        WebElement plus = driver.findElement(By.id("op_add"));
        WebElement equalTo = driver.findElement(By.id("eq"));
        WebElement result = driver.findElement(By.id("result"));

        //Interact with WebElements
        five.click();
        plus.click();
        eight.click();
        equalTo.click();

        //Verifications
        Assert.assertEquals(result.getText(),"13");

    }

    @AfterClass
    public void tearDown(){
        //Close driver
        driver.quit();
    }
}
