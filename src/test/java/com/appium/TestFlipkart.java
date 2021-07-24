package com.appium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;

public class TestFlipkart {
	
	
//	AndroidDriver<MobileElement> driver;
	AppiumDriver<WebElement> driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "nexus_5_7.1.1");
		cap.setCapability("browserName", "android");
		cap.setCapability("platformName", "Android");
		//cap.setCapability("seleniumProtocol", "WebDriver");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL url = new URL("http://0.0.0.0:4444/wd/hub");

		driver = new AppiumDriver<WebElement>(url, cap);
		
	}
	
	@Test
	public void testLoc() throws InterruptedException {
		driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_7")).click();
		driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
		driver.findElement(By.id("com.android.calculator2:id/eq")).click();
		
		String total = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
		System.out.println(total);		
		String expected = "2214";
		
		Thread.sleep(1000);
		Assert.assertEquals(total, expected);
	}
	
	
	
	
//	
////	@BeforeTest
//	public void setUp() throws Exception {
//		
////		URL URL = new URL("http://127.0.0.1:4723/wd/hub");
//		URL URL = new URL("http://0.0.0.0:4444/wd/hub");
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability("platformName", "Android");
//		cap.setCapability("platformVersion", "11");
//		cap.setCapability("appPackage" , "com.flipkart.android");
//		cap.setCapability("appActivity" , "com.flipkart.android.activity.HomeFragmentHolderActivity");
//		
////		cap.setCapability("autoGrantPermissions", "true");
//
//		driver = new AndroidDriver<MobileElement>(URL, cap);
//		Thread.sleep(10000);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		
//		
//		
//	}
//
//	
////	@Test
//	public void testLocation() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		List<MobileElement> langSelection = driver.findElements(By.xpath("//android.widget.TextView[@text='English']"));
//		if(langSelection.size()>0) {
//			langSelection.get(0).click();
//		}
//		driver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']")).click();
//		Thread.sleep(10000);
//		List<MobileElement> closeIcon = driver.findElements(By.xpath("//android.widget.ImageView[@index='1']"));
//		if(closeIcon.size()>0) {
//			closeIcon.get(1).click();
//		}
//		Thread.sleep(5000);
//		MobileElement searchBar = driver.findElement(By.id("com.flipkart.android:id/search_widget_textbox"));
//		System.out.println(searchBar.getText());
//		searchBar.click();
//		Thread.sleep(3000);
//		MobileElement searchBar2 = driver.findElement(By.id("com.flipkart.android:id/search_autoCompleteTextView"));
//		System.out.println("Second Search bar - "+searchBar2.getText());
//		searchBar2.click();
//		searchBar2.sendKeys("macbook air");
//		List<MobileElement> searchResults = driver.findElements(By.xpath("//android.widget.RelativeLayout[@index='0']"));
//		if(searchResults.size()>0) {
//			searchResults.get(1).click();
//		}
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//android.widget.Button[@text='NOT NOW']")).click();
//		Thread.sleep(5000);
//		List<MobileElement> priceBar = driver.findElements(By.xpath("//android.widget.TextView[@index='6']"));
//		if(priceBar.size()>0) {
//			for (MobileElement price : priceBar) {
//				
//				System.out.println("Prices are: "+price.getText());
//				
//			}
//		}
//		Thread.sleep(5000);
//		driver.quit();
//	}
//	
	

}
