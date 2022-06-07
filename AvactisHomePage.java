package Avactis;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class AvactisHomePage extends LoadableComponent<AvactisHomePage>{
	WebDriver driver;
	private String url ="http://localhost/avactis/index.php";
	private String title="Avactis Demo Store";
	
	@FindBy (xpath = " //a[text() = 'My Account']")
	private WebElement myAccount;

	public AvactisHomePage() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\eclipse-workspace\\maventraining\\src\\test\\resources\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\lenovo\\eclipse-workspace\\maventraining\\src\\test\\resources\\geckodriver.exe");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		get();

		
	}
	public AvactisRegisterPage homepageClick()
	{
		myAccount.click();
		AvactisRegisterPage AvactisRegisterPage=new AvactisRegisterPage(driver);
		 return AvactisRegisterPage;

	}
	
	@Override
	protected void load() {
		
		driver.get(url);
	}

	@Override
	protected void isLoaded() throws Error {
		
	      assertEquals(driver.getTitle(),title,"Page is Not Load");
	}
	
	public void closeBrowser() {
		
		driver.quit();
	}
}
