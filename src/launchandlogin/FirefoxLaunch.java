package launchandlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirefoxLaunch
{
	public static WebDriver driver;
	public static WebDriverWait wb;
	@BeforeSuite
	public void launchURL()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\TESTING\\required software\\selenium\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");	
	}
	@Test
	public void testCase1()
	{		
		SoftAssert sa=new SoftAssert();	
		String actual = driver.getTitle();
		System.out.println(actual);
		sa.assertEquals(actual, "OrangeHRM", "when title doesn't match");
		Reporter.log("Verify URL Test case", true);
		sa.assertAll();
	}
	@BeforeTest
	public void logIn()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}

@Test
	public void testCase2()
	{
		SoftAssert sa=new SoftAssert();
		String ss=driver.findElement(By.linkText("Dashboard")).getText();
		System.out.println(ss);
		String Expected="Dashboard";
		sa.assertEquals(ss, Expected);
		Reporter.log("Verify log in functinality of orange HRM", true);
		sa.assertAll();
	}
	
//	@AfterTest
//	public void logOut()
//	{
//		driver.findElement(By.id("welcome")).click();
//		WebDriverWait wb=new WebDriverWait(driver, 20);
//		wb.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
//		driver.findElement(By.linkText("Logout")).click();
//	}
//	@AfterSuite
//	public void closeBrowser()
//	{
//		driver.quit();
//	}

}
