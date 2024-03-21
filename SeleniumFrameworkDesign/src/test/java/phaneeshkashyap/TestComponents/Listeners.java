package phaneeshkashyap.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import phaneeshkashyap.resources.ExtentReporterNG;

public class Listeners extends BaseClass implements ITestListener {
	
	ExtentReports ext = ExtentReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread Safe
	
	
	@Override
	public synchronized void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = ext.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
		
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Step Passed");
		
//		tst.pass(result.getThrowable());
		
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
//		log.info(result.getThrowable());
		extentTest.get().log(Status.FAIL, "Test Step Failed");
		extentTest.get().fail(result.getThrowable());
//		"Test Step Failed" + "\n" + 
		// Take Screenshot
		String filepath = null;
		String name = result.getMethod().getMethodName();
		
		
		
		WebDriver adriver=null;
//		adriver = getDriver();
		
		try {
			adriver = (WebDriver) result.getTestClass().getRealClass()
					.getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			filepath = getScreenshot(name,adriver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentTest.get().addScreenCaptureFromPath(filepath, name);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		ext.flush();
		
	}
	

}
