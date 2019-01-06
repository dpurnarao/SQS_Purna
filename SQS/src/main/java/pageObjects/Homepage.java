package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	public WebDriver driver;

		
	@FindBy(xpath="//*[@id='content']/div/h3")
	WebElement header;
	
	@FindBy(xpath="//a[contains(@class,'button')]")
	WebElement btnCount;

	@FindBy(className="button")
	WebElement button1;
	
	@FindBy(css=".button.alert")
	WebElement button2;
	
	@FindBy(css=".button.success")
	WebElement button3;
	
	@FindBy(xpath="//a[@href='#edit']")
	WebElement lnkedit;
	
	@FindBy(xpath="//a[@href='#delete']")
	WebElement lnkdelete;
	
	@FindBy(xpath="//*[@id='content']/div/div/div/div[2]/table//following::thead")
	WebElement tableHeaders;
	
	@FindBy(xpath="html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr")
	WebElement tablerows;
	
	@FindBy(xpath="html/body/div[2]/a/img")
	WebElement imggithub;
	
	@FindBy(xpath="//a[@href='http://elementalselenium.com/']")
	WebElement lnkelementsselenium;
	
     	
	public Homepage(WebDriver driver) 
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getHeader()
	{
		return header;
	}
	

	public WebElement getButtonCount()
	{
		return btnCount;	
	}
	
	public WebElement getButton1()
	{
		return button1;	
	}
	
	public WebElement getButton2()
	{
		return button2;	
	}
	
	public WebElement getButton3()
	{
		return button3;	
	}
	

	public WebElement getEditlink()
	{
		return lnkedit;
	}
	
	
	public WebElement getDeletelink()
	{
		return lnkdelete;
	}
	
	public WebElement getTableHeaders()
	{	
		return tableHeaders;
	}
	
	public WebElement getTableRows()
	{
		return tablerows;
	}
	
	public WebElement getImageGithub()
	{
		return imggithub;
	}
	
	public WebElement getLinkelementselenium()
	{
		return lnkelementsselenium;
	}
	
}
