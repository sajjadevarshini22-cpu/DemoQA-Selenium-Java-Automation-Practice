package framework.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String fileName) {

        String screenshotPath = "screenshots/" + fileName + "_" + System.currentTimeMillis() + ".png";

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            File destination = new File(screenshotPath);

            FileHandler.copy(source, destination);

            System.out.println("Screenshot captured: " + screenshotPath);

        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }

        return screenshotPath;
    }
}