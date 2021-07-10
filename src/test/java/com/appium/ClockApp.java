package com.appium;

import static org.junit.Assert.*;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ClockApp {

	AndroidDriver<MobileElement> driver;

	@Before
	public void setUp() throws Exception {
		URL URL = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("appPackage" , "com.google.android.deskclock");
		cap.setCapability("appActivity" , "com.android.deskclock.DeskClock");

		driver = new AndroidDriver<MobileElement>(URL, cap);
		driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
		

	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
	public void getAlarms() throws InterruptedException {
//		Click Alarm Tab
		MobileElement Alarm = driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm']"));
		Alarm.click();
		Thread.sleep(2000);
//		Get the list of Alarms
		List<MobileElement> allAlarms = driver.findElements(By.xpath("//android.view.ViewGroup[contains(@content-desc,\"Alarm\")]"));
		System.out.println("Count Alarms set is: "+allAlarms.size());
		for (MobileElement alarm : allAlarms) {
			MobileElement timeAlarm = alarm.findElement(By.id("com.google.android.deskclock:id/digital_clock"));
			System.out.println("Time set is "+timeAlarm.getText());
			System.out.println("Alarm is Enabled or No:");
			System.out.println(alarm.findElement(By.id("com.google.android.deskclock:id/onoff")).getText());
			//paste the below line of code
		
		}
	}
	@Test
    public void testBack() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm']")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm']")).click();
    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
	}
//	@Test
    public void setAlarm() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.google.android.deskclock:id/fab")).click();
        Thread.sleep(2000);
        
        
        String setHrs = driver.findElement(By.id("android:id/hours")).getText();
        setHelper(setHrs, "10");
        
        String setMin = driver.findElement(By.id("android:id/minutes")).getText();
        setHelper(setMin, "55");
        
        
    }
    
    
    public void setHelper(String setSourceUnit, String setTargetUnit) throws InterruptedException {
        WebElement source = driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+setSourceUnit+"']"));
        WebElement target = driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+setTargetUnit+"']"));
        
        int startX=source.getLocation().getX();

int startY=source.getLocation().getY();
        int endX=target.getLocation().getX();
        int endY=target.getLocation().getY();
        System.out.println(startX);
        System.out.println(startY);
        System.out.println(endX);
        System.out.println(endY);
        
        TouchAction action = new TouchAction(driver);
        action
        .longPress(PointOption.point(startX, startY))
        .moveTo(PointOption.point(endX, endY))
        
        .release()
        .perform();
        Thread.sleep(2000);
        
    }

	
//	@Test
	public void setAlarm2() throws InterruptedException {
		Thread.sleep(2000);
		MobileElement addAlarm = driver.findElement(By.id("com.google.android.deskclock:id/fab"));
		addAlarm.click();
		Thread.sleep(2000);

		String hrsSet = driver.findElement(By.id("android:id/hours")).getText();
		String minSet = driver.findElement(By.id("android:id/minutes")).getText();
		
		MobileElement source = driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+hrsSet+"']"));
		MobileElement target = driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='10']"));
		int startX = source.getLocation().getX();
		int startY = source.getLocation().getY();
		int endX =  target.getLocation().getX();
		int endY = target.getLocation().getY();
		System.out.println(startX);
		System.out.println(startY);
		System.out.println(endX);
		System.out.println(endY);
		
		TouchAction action = new TouchAction(driver);
		action
		.longPress(PointOption.point(startX, startY))
		.moveTo(PointOption.point(endX, endY))
//		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
//		.release().
		.perform();
		Thread.sleep(2000);
		
		
	}
	
}
