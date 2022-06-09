package Avactis;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

public class AvactisRegFormPage extends LoadableComponent<AvactisRegFormPage> {
	AvactisRegisterPage registerationPage;
	WebDriver driver;
	Select countryList;
	Select stateList;
	private String title = "Avactis Demo Store";
	
	@FindBy (name = "customer_info[Customer][Email]")
	private WebElement emailId;
	
	@FindBy (name = "customer_info[Customer][Password]")
	private WebElement password;
	
	@FindBy (name = "customer_info[Customer][RePassword]")
	private WebElement reTypePassword;
	
	@FindBy (name = "customer_info[Customer][FirstName]")
	private WebElement firstName;
	
	@FindBy (name = "customer_info[Customer][LastName]")
	private WebElement lastName;
	
	@FindBy(name= "customer_info[Customer][Country]")
	private WebElement country;	
	
	@FindBy(name= "customer_info_Customer_State")
	private WebElement state;
	
	@FindBy (name="customer_info[Customer][ZipCode]")
	private WebElement zipcode;
	
	@FindBy (name="customer_info[Customer][City]")
	private WebElement city;
	
	@FindBy (name="customer_info[Customer][Streetline1]")
	private WebElement address1;
	
	@FindBy (name="customer_info[Customer][Streetline2]")
	private WebElement address2;
	
	@FindBy (name="customer_info[Customer][Phone]")
	private WebElement contact;
	
	@FindBy (xpath="//input[@value='Register']")
	private WebElement registerButton;
	
	
	
	
	public AvactisRegFormPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(this.driver, this);
		get();
	}

	public void userRegisteration(String mailId, String pass, String rePass, String fName, String lName, String ct, String zip, String add1, String add2, String cNo)
	{
		System.out.println("Registeration Page");
		emailId.sendKeys(mailId);
		password.sendKeys(pass);
		reTypePassword.sendKeys(rePass);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		
		countryList = new Select(country);
		List<WebElement> options =countryList.getOptions();
		for(WebElement element:options)
		{
			System.out.println("Options: "+element.getText());
		}
		countryList.selectByVisibleText("India");
		
		stateList = new Select(state);
		List<WebElement> sOptions = stateList.getOptions();
		for(WebElement ele:sOptions)
		{
			System.out.println("state Options: "+ele.getText());
		}
		stateList.selectByVisibleText("Maharashtra");
		
		city.sendKeys(ct);
		zipcode.sendKeys(zip);
		address1.sendKeys(add1);
		address2.sendKeys(add2);
		contact.sendKeys(cNo);
		
	}
	@Override
	protected void load() {

		
	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(),title);

	}

}
