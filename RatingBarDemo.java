package appiumAutomation.com.appiumdemos;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class RatingBarDemo {
	
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
	public void rating() throws InterruptedException {
		Thread.sleep(3000);
		aDriver.findElementByAccessibilityId("Views").click();
		aDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Rating Bar\"))").click();
		Thread.sleep(3000);
		aDriver.findElementById("io.appium.android.apis:id/ratingbar2").click();
		Thread.sleep(3000);
		
	}

}
