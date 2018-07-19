package com.jenkins.qa.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyJenkinsDemo {
	
	WebDriver driver;
	
  @Test
  public void loginToFBGoAmazon() {
	  driver.navigate().to("http://www.facebook.com");
	  driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
	  driver.findElement(By.name("pass")).sendKeys("abc12345");
	  driver.findElement(By.id("loginbutton")).click();
	  
	  System.out.println("Page Opened::"+driver.getTitle());
	  
	  driver.navigate().back();
	  System.out.println("Page now opened::"+driver.getTitle());
	  
	  driver.get("http://www.amazon.com");
	  System.out.println("Page now in::"+driver.getTitle());
	  
	  driver.findElement(By.partialLinkText("Deals")).click();
	  System.out.println("Page opened now::"+driver.getTitle());
	  
	  System.out.println("Done and browser will be closed now");
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Shilpa\\chromedriver_win32\\chromedriver.exe");
	  System.setProperty("java.awt.headless", "false");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
