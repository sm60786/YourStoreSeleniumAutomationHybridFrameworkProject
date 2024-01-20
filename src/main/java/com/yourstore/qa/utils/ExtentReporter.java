package com.yourstore.qa.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.yourstore.qa.base.Base;

public class ExtentReporter extends Base {
	
	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		// Customization of SparkReport
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Your Store Test Automation Results");
		sparkReporter.config().setDocumentTitle("YS Automation Results");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", prop.getProperty("browser"));
		extentReport.setSystemInfo("Email", prop.getProperty("email"));
		extentReport.setSystemInfo("Password", prop.getProperty("password"));
		
		// System.getProperties().list(System.out);
		// To get the list of properties
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("JDK Version", System.getProperty("java.version"));
		
		return extentReport;
		
	}

}
