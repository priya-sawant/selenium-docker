package testcase;


import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



@Test
public class test {
	
	
	public WebDriver driver;

	//@BeforeTest
	//@Parameters("browser")
	
	@BeforeClass
	public void setup(ITestContext ctx) throws MalformedURLException {
		//System.out.println(browser);
		
		String host="localhost";
		MutableCapabilities dc;
		
		if(System.getProperty("BROWSER") != null &&
	            System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
	        dc = new FirefoxOptions();
	    }else{
	        dc = new ChromeOptions();
	    }
	 
	    if(System.getProperty("HUB_HOST") != null){
	        host = System.getProperty("HUB_HOST");
	    }
	 
	    String testName = ctx.getCurrentXmlTest().getName();
	 
	    String completeUrl = "http://" + host + ":4444/wd/hub";
	    dc.setCapability("name", testName);
	    this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
	
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://priya-myflix.epizy.com/myflix/register.php");
	}

		
	public void verifyweb() throws IOException, InvalidFormatException
	{
		
		
		//performing action on login portal an escaping it
		Actions actions = new Actions(driver);
		
		Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();
		
		sendEsc.perform();
		
		
			//entering value into search box through name of element
			driver.findElement(By.name("firstName")).sendKeys("SawantPriya");
			driver.findElement(By.name("lastName")).sendKeys("Sahaji");
			driver.findElement(By.name("username")).sendKeys("Misspriya");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.name("email")).sendKeys("priya.sawant457@gmail.com");
			driver.findElement(By.name("email2")).sendKeys("priya.sawant457@gmail.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.name("password")).sendKeys("pwd123");
			driver.findElement(By.name("password2")).sendKeys("pwd123");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//click on search button
			driver.findElement(By.name("submitButton")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}
	
	@AfterClass
	public void end() {
		driver.quit();
	}
	

}
