package com.test.sqs;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import resources.base;

public class Tablevalidations extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest

	public void initialize() throws IOException
	{		
		driver =initializeDriver();
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
	public void validateTableheader() throws IOException
	{
		Homepage hp = new Homepage(driver);
		Assert.assertEquals("Lorem Ipsum Dolor Sit Amet Diceret Action",hp.getTableHeaders().getText());
		log.info("Validated Webtable Header");
	}
	
	@Test
	public void validateTableheadercount() throws IOException
	{
		List<WebElement> headings=driver.findElements(By.xpath("html/body/div[2]/div/div/div/div/div[2]/table/thead/tr/th"));
		assertEquals(7, headings.size());
		log.info("Validated Header Count");
	}
	
	@Test
	public void validaterowscount() throws IOException
	{
		List<WebElement> rows= driver.findElements(By.xpath("html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr"));
		assertEquals(10, rows.size());
		log.info("Validated Table rowcount");
	}
	

	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	
	}
}
