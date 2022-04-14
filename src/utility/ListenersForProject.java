package utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersForProject implements ITestListener 
{
	static int i=0;	
	@Override
	public void onTestStart(ITestResult result) 
	{
		int j=0;
		try {			
			ExcelReadWrite.writeExcel(i, j, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Start of testcase: "+result.getName());			
	}
	@Override
	public void onTestSuccess(ITestResult result) 
	{		
		int j=1;
	System.out.println("passed: "+result.getName());
	try {
		
		ExcelReadWrite.writeExcel(i, j, "pass");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	i++;
	
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{

		int j=1;
		System.out.println("failed"+result.getName());
	
		
		try {
			ExcelReadWrite.writeExcel(i, j, "fail");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			i++;
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		int j=0;
		try {			
			ExcelReadWrite.writeExcel(i, j, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j++;
		System.out.println("Tes get skipped: "+result.getName());
		try {
			
			ExcelReadWrite.writeExcel(i, j, "skipped");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context)
	{
		// TODO Auto-generated method stub
		
	}

}
