package appiumAutomation.com.appiumdemos;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class MakePhoneCall {
	
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
	
		cap.setCapability("appPackage", "com.android.contacts");
		cap.setCapability("appActivity", ".activities.ContactsFrontDoor");
	
		
		try
		{
		aDriver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void callContact() throws InterruptedException {
		Thread.sleep(5000);
		//aDriver.findElementById("android:id/input").sendKeys("Sandy Sarja");
		WebElement searchBox = aDriver.findElementByXPath("//android.widget.TextView[@content-desc=\"Search\"]");
		searchBox.click();
		//aDriver.pressKeyCode(AndroidKeyCode.ENTER);
		searchBox.sendKeys("Sandy Sarja");
		
		Thread.sleep(3000);
		aDriver.findElementByAndroidUIAutomator("new UiSelector().text(\"Sandy Sarja\")").click();
		Thread.sleep(2000);
		aDriver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Dial\"])[1]").click();
		Thread.sleep(5000);
		
		aDriver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"End\"]/android.widget.ImageView").click();


		
	}
	
}
