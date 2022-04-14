package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenShot 
{
	public static void screenshot(WebDriver driver,String filename) throws IOException
	{
		
		TakesScreenshot tk=(TakesScreenshot)driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File target=new File("F:\\TESTING\\Screenshots\\"+filename+".png");
		FileHandler.copy(source, target);
	}

}
