package framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static  ExtentReports extent;

    public static ExtentReports getExtentReport()
    {
        if(extent==null) {
            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            sparkReporter.config().setDocumentTitle("Selenium Automation Report");
            sparkReporter.config().setReportName("SauceDemo Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Tester", "Devarshini");
            extent.setSystemInfo("Project", "Selenium Java Automation");
            extent.setSystemInfo("Application", "SauceDemo");
            extent.setSystemInfo("Browser", "Chrome");


        }
        return extent;
    }

}
