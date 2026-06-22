package framework.listeners;

import framework.base.BaseTest;
import framework.reports.ExtentManager;
import framework.utilities.ScreenshotUtil;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getExtentReport();
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test execution started: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());

        test.log(Status.INFO, "Test started: " + result.getName());

        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.log(Status.PASS, "Test passed: " + result.getName());

        System.out.println("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.log(Status.FAIL, "Test failed: " + result.getName());

        test.log(Status.FAIL, result.getThrowable());

        Object testClass = result.getInstance();

        WebDriver driver = ((BaseTest) testClass).getDriver();

        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());

        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            test.log(Status.WARNING, "Screenshot could not be attached: " + e.getMessage());
        }

        System.out.println("Test failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.log(Status.SKIP, "Test skipped: " + result.getName());

        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println("Test execution finished: " + context.getName());
    }
}