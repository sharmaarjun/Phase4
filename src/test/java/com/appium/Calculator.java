package com.appium;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Calculator {
	
	AndroidDriver<MobileElement> driver;

	@Before
	public void setUp() throws Exception {
		URL URL = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("appPackage" , "com.google.android.calculator");
		cap.setCapability("appActivity" , "com.android.calculator2.Calculator");

		driver = new AndroidDriver<MobileElement>(URL, cap);
//		driver.manage().timeouts().implicitlyWait(1000)
		

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void sum() {
		System.out.println("Open calculator app");
		driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
		//sum
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"plus\"]")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
		//equals
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"equals\"]")).click();
		String Result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getAttribute("text");
		System.out.println("Final Result for Sum: "+Result);
	}

}
