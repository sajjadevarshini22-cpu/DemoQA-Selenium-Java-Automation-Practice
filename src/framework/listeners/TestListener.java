package framework.listeners;

import framework.base.BaseTest;
import framework.utilities.ScreenshotUtil;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener  implements ITestListener{
    @Override
    public void onStart(ITestContext context)
    {
        System.out.println("Test execution started:"+context.getName());

    }
    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("Test started:"+result.getName());

    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test failed: " + result.getName());

        Object testClass = result.getInstance();

        WebDriver driver = ((BaseTest) testClass).getDriver();

        ScreenshotUtil.captureScreenshot(driver, result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test execution finished: " + context.getName());
    }

}
