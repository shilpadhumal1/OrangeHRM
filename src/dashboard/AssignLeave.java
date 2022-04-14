package dashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import launchandlogin.LaunchURL;

public class AssignLeave extends LaunchURL
{
	@BeforeClass
	public void AssignLeave1() throws InterruptedException
	{
		WebDriverWait wb=new WebDriverWait(driver, 20);
		wb.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='quickLinkText' and text()='Assign Leave']")));
		driver.findElement(By.xpath("(//span[@class='quickLinkText'])[1]")).click();
	}
	
	@Test(timeOut=10000)
	public void assignLeave2()
	{
		driver.findElement(By.xpath("//input[@type='text' and @name='assignleave[txtEmployee][empName]']")).sendKeys("Sania Shaheen");
		driver.findElement(By.xpath("//select[@name='assignleave[txtLeaveType]']")).click();
		
		Select sc=new Select(driver.findElement(By.xpath("//select[@id='assignleave_txtLeaveType']")));
		sc.selectByValue("9");
		driver.findElement(By.xpath("//input[@id='assignleave_txtFromDate']")).click();
		List<WebElement> date = driver.findElements(By.className("ui-state-default"));
		for(WebElement day:date)
		{
			
			if(day.getText().equals("30"))
			{
				day.click();
			}
		}
		driver.findElement(By.xpath("//input[@id='assignleave_txtToDate']")).click();
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.xpath("//a[text()='1']")).click();
		Select sc1=new Select(driver.findElement(By.name("assignleave[partialDays]")));
		sc1.selectByValue("all");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300);");
		driver.findElement(By.xpath("//textarea")).sendKeys("Lismmdjsjdfvws");
		driver.findElement(By.id("assignBtn")).click();
		driver.findElement(By.xpath("//input[@id='confirmOkButton']")).click();
		
	}
	

}
