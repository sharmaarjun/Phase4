package com.practice.appium;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PracticeClock {
	
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
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void trail() throws InterruptedException {
		MobileElement alarmIcon = driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm']"));
		alarmIcon.click();
		Thread.sleep(5000);
		List<MobileElement> aCount = driver.findElements(By.id("com.google.android.deskclock:id/digital_clock"));
		System.out.println(aCount.size());
		for (MobileElement mob : aCount) {
			System.out.println(mob.getText());
			mob.click();
		}
	}
	
//	@Test
	public void test() {
//		alarm - //xk[@content-desc="Alarm"]/android.widget.TextView
		driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
		driver.findElement(By.xpath("//xk[@content-desc=\"Alarm\"]/android.widget.TextView")).click();
		List<MobileElement> alarmList = driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\" Alarm\"]"));
		System.out.println(alarmList.size());
		for (MobileElement alarmind : alarmList) {
//			alarmind.findElement();
		}
	
	}

}
