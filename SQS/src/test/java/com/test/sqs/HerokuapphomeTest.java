package com.test.sqs;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import resources.base;

public class HerokuapphomeTest extends base {
	//public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest

	public void initialize() throws IOException
	{	
		driver =initializeDriver();
		//log.info("Driver is Intialized");
		driver.get(prop.getProperty("url"));		
	}
	
	@Test (priority=1)
	public void validateurl() throws IOException, InterruptedException
	{		
		Assert.assertEquals(prop.getProperty("url"),driver.getCurrentUrl());	
		//log.info("Validated Current URL");
	}
	
	@Test
	public void validateheader() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertEquals("Challenging DOM",hp.getHeader().getText());
		//log.info("Challenging DOM Header is Displayed");
	}
	
	
	@Test
	public void validateImageGithub() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertTrue(hp.getImageGithub().isDisplayed());
		//log.info("GitHub Image is Displayed");
	}
	
	@Test
	public void validateLinkelementselenium() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertTrue(hp.getLinkelementselenium().isDisplayed());
		//log.info("Emental selenium Link is Displayed");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	
	}
}
