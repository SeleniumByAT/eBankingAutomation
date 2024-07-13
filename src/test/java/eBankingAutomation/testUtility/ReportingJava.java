package eBankingAutomation.testUtility;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportingJava implements ITestListener {

	 ExtentSparkReporter report;
	 ExtentReports extent;
	 ExtentTest test;

	public void onTestStart(ITestResult result) {
		report = new ExtentSparkReporter(System.getProperty("user.dir") + "//report//index.html");
		report.config().setDocumentTitle("eBankingReports");
		report.config().setDocumentTitle("Functional Testing");
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Enviroment", "QA");
		extent.setSystemInfo("Tester", "Archi");

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case passed is: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case Failed is: " + result.getName());
		test.log(Status.FAIL, "Test case fail reason is " + result.getThrowable());
		String Screenshotpath = System.getProperty("user.dir") + "\\Screenshot\\" + result.getName() + ".png";
		File file = new File(Screenshotpath);

		if (file.exists()) {
			test.fail("screenshot captutred" + test.addScreenCaptureFromPath(Screenshotpath));
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case Skipped: " + result.getName());
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();

	}

}
