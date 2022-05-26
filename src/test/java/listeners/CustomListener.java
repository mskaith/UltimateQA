package listeners;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utilities.ScreenshotUtil;

public class CustomListener implements ITestListener {

	public static Date d = new Date();
	public static String fileName = "Extent_" + d.toString().replace(" ", "_").replace(":", "_") + ".html";
	public static ExtentReports extent = ExtentManager
			.createInstance(System.getProperty("user.dir") + "\\target\\surefire-reports\\extentreports\\" + fileName);

	public static ExtentTest test;

	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName() + " @TestCase  " + result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:-" + methodName + " PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);
	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Capturing Screenshot");
		ScreenshotUtil.captureScreenshot();

		Reporter.log("<a target=\"_blank\" href=" + ScreenshotUtil.fileName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + ScreenshotUtil.fileName + "><img src=" + ScreenshotUtil.fileName
				+ " height=200 width=200></img></a>");

		/////////////////////////////////// Extent Report ////////////////
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		test.fail(exceptionMessage);

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName + " FAILED" + "</b>";

		try {

			String screenshot1 = ScreenshotUtil.fileName;
			test.fail("<b><font color=red>" + "Screenshot of failure",
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.fileName).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.log(Status.FAIL, m);

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		if (extent != null) {

			extent.flush();
		}
	}

}
