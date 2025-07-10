package common;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.TestUtils;

public class Listeners2scrn extends TestUtils implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		System.out.println("Test case is startin");
	}
	
	public void onTestSuccess(ITestResult result) {
		
	}
	
   public void onTestFailure(ITestResult result) {
	   System.out.println("Test failed - screensot captured");
	  try
	  {
		  getScreenshot();
	  }catch (IOException e)
	  {
		  e.printStackTrace();
	  }
		
	}

   public void onTestSkipped(ITestResult result) {
	
}
   public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
   }
   public void onStart(ITestContext context) {
		
   }
   public void onFinish(ITestContext context) {
		
   }
   
   
}