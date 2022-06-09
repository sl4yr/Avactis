package Avactis;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;



public class AvactisRegisterPage extends LoadableComponent<AvactisRegisterPage> {

	WebDriver driver;
	private String Title = "Avactis Demo Store";

	@FindBy (xpath = "//button[text()='Register']")
	private WebElement register;

	
	public AvactisRegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		get();
	}
	public AvactisRegFormPage RegisterClick()
	{
		register.click();
		AvactisRegFormPage AvactisRegFormPage = new AvactisRegFormPage(driver);
		return AvactisRegFormPage;
	}
	@Override
	protected void load() {
		
	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(), "Avactis Demo Store");

		
	}

}
//This because of git
