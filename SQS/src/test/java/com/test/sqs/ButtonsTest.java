package com.test.sqs;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import resources.base;

public class ButtonsTest extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	

	@BeforeTest

	public void initialize() throws IOException
	{
		//driver =initializeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Purna\\Desktop\\ChromeDrive\\chromedriver.exe");
		//C:\\Users\\Purna\\Desktop\\ChromeDrive
		  	WebDriver driver = new ChromeDriver();


		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		log.info("Driver is Intialized");
		driver.get(prop.getProperty("url"));		
	}
	
	@Test (priority=1)
	public void validateurl() throws IOException, InterruptedException
	{		
		Assert.assertEquals(prop.getProperty("url"),driver.getCurrentUrl());
		log.info("Validated Current URL");
	}
	
	
	@Test
	public void validateButton1() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertTrue(hp.getButton1().isDisplayed());	
		log.info("Validated Button1");
	}
	
	@Test
	public void validateButton2() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertTrue(hp.getButton2().isDisplayed());	
		log.info("Validated Button2");
	}
	
	@Test
	public void validateButton3() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertTrue(hp.getButton3().isDisplayed());	
		log.info("Validated Button3");
	}
	
	@Test
	public void validateButtonCount() throws IOException
	{		
		List<WebElement> list=driver.findElements(By.xpath("//a[contains(@class,'button')]"));
		if(Optional.ofNullable(list)!=null)
		assertEquals(3,list.size());
		log.info("Validated Buttons Count");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	
	}
}
