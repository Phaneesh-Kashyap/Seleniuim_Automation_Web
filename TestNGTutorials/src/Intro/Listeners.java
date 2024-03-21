package Intro;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements  ITestListener {

	public void onTestStart(ITestResult result) {
		 
		 System.out.println("New Test Started :: " +result.getName());
		 System.out.println(result.getStatus());
		 }
		 
		 public void onTestSuccess(ITestResult result) {
		 
		 System.out.println("Test Successfully Finished :: " +result.getName());
		 System.out.println(result.getStatus());
		 
		 }
		 
		 public void onTestFailure(ITestResult result) {
		 
		 System.out.println("Test Failed :: " +result.getName());
		 System.out.println(result.getTestName());
		 System.out.println(result.getStatus());
		 System.out.println(result.getHost());
		 System.out.println(result.getInstanceName());
		 
		 }
		 
		 public void onTestSkipped(ITestResult result) {
		 
		 System.out.println("Test Skipped :: " +result.getName());
		 
		 }
		 
		 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 
		 System.out.println("Test Failed but within success percentage :: " +result.getName());
		 
		 }
		 
		 public void onStart(ITestContext context) {
		 
		 
		 System.out.println("This is onStart method :: " +context.getOutputDirectory());
		 
		 }
		 
		 public void onFinish(ITestContext context) {
		 
		 System.out.println("This is onFinish method :: " +context.getPassedTests());
		 System.out.println("This is onFinish method :: " +context.getFailedTests());
		 }
	
	
}
