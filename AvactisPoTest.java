package Avactis;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AvactisPoTest {
	AvactisHomePage homepage;
	
  @Test
  public void testAvactis() {
	  homepage.homepageClick()
	  			.RegisterClick()
	  			.userRegisteration("makgunjal@gmail.com","Makami","Makami", "Makarand","Gunjal","410206","Navi Mumbai","Ulwe Node","Sector 03","9619779087");
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  homepage = new AvactisHomePage();
  }

  @AfterMethod
  public void afterMethod() {
	  
	  homepage.closeBrowser();
  }

}
