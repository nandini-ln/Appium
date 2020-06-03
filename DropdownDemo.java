package appiumAutomation.com.appiumdemos;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class DropdownDemo {
	
	public DesiredCapabilities cap;
	
	public AndroidDriver aDriver;
	
	@BeforeClass
	public void launchApp() throws InterruptedException {
		cap=new DesiredCapabilities();
		cap.setCapability("automationName", "UIAutomator2");
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("UDID", "54b2def");
	
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
	
		
		try
		{
		aDriver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void dropDownMenu() throws InterruptedException {
		Thread.sleep(3000);
		
		aDriver.findElementByAccessibilityId("Views").click();
		
		aDriver.findElementByAccessibilityId("Controls").click();
		aDriver.findElementByAccessibilityId("3. Holo Light Theme").click();
		
		aDriver.findElementById("android:id/text1").click();
		Thread.sleep(2000);

		List<WebElement> elements = aDriver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView");
		
		for(WebElement ele:elements) {
			System.out.println(ele.getText());
			
		}
	}

}
