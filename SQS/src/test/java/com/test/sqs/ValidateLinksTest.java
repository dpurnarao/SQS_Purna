package com.test.sqs;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import resources.base;

public class ValidateLinksTest extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest

	public void initialize() throws IOException
	{		
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver is Intialized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=0)
	public void validateurl() throws IOException, InterruptedException
	{		
		Assert.assertEquals(prop.getProperty("url"),driver.getCurrentUrl());
		log.info("Validated Current URL");
	}
	
	
	@Test(priority=1)
	public void validateEditLink() throws IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getEditlink().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals("https://the-internet.herokuapp.com/challenging_dom#edit",driver.getCurrentUrl());	
		log.info("Validated Edit Link");
	}
	

	@Test(priority=2)
	public void validateDeleteLink() throws IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getDeletelink().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals("https://the-internet.herokuapp.com/challenging_dom#delete",driver.getCurrentUrl());
		log.info("Validated Delete Link");
								
	}
	
	@Test(priority=3)
	public void validateImageGithub() throws IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getImageGithub().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("Validated Image Github click");
		Assert.assertEquals("https://github.com/tourdedave/the-internet",driver.getCurrentUrl());
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(priority=4)
	public void validateLinkelementsselenium() throws IOException
	{
		Homepage hp = new Homepage(driver);
		hp.getLinkelementselenium().click();	
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Set<String>ids = driver.getWindowHandles();
		Iterator<String> it =ids.iterator();
		String parentid =it.next();
		String childid =it.next();		
		driver.switchTo().window(childid);
		Assert.assertEquals("http://elementalselenium.com/",driver.getCurrentUrl());
		log.info("Validated Elements selenium link");
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
		driver=null;	
	}
}
