package com.crm.Listeners;

import java.io.File;

import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.DWSBase;

public class AttachExtentReport extends DWSBase implements ITestListener {

	public static ExtentReports report=null;
	public static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		
		//create Extent test
		test=report.createTest(name);
		test.log(Status.INFO, name+"is onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.PASS, name+"is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"is fail");
		LocalDateTime date=LocalDateTime.now();
		String time=date.toString().replace(':', '-');
		String name = result.getMethod().getMethodName();
		Reporter.log("onTestFailure for "+name,true);
		TakesScreenshot ts=(TakesScreenshot)driver;
		//take screenshot when the test case failure
		String from=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.SKIP, name+"onTestSkipped");
	}

	@Override
	public void onStart(ITestContext context) {
		
		File path= new File(".\\src\\test\\resources\\Reports\\VtigerTestCaseWithScr.html");
		//create ExtentSparkReport
	     spark=new ExtentSparkReporter(path);
		//Configure ExtentSparkReport
		spark.config().setDocumentTitle("DWS");
		spark.config().setReportName("Anuradha");
		spark.config().setTheme(Theme.DARK);
		//create ExtentReport
		report=new ExtentReports();
		//provide system information
		report.setSystemInfo("OS", "window10");
		report.setSystemInfo("Browser", "Chrome");
		//Attach ExtentSparkReport to the ExtentReport
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		
		//use flush
		report.flush();

	}
}
