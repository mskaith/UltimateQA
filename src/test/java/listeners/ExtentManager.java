package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter htmlReporter= new ExtentSparkReporter(fileName);
		
		htmlReporter.config().setTheme(Theme.STANDARD);	
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Mohit");
		extent.setSystemInfo("Organization", "Mohit Company");
		extent.setSystemInfo("Build No", "2.3");
		
		
		
		return extent;
	}

}
