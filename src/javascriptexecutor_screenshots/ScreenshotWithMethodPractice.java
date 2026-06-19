package javascriptexecutor_screenshots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotWithMethodPractice {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.id("firstName")).sendKeys("Devarshini");
        driver.findElement(By.id("lastName")).sendKeys("Sajja");
        driver.findElement(By.id("userEmail")).sendKeys("devarshini@gmail.com");

        WebElement readingLabel = driver.findElement(By.xpath("//label[text()='Reading']"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", readingLabel);
        js.executeScript("arguments[0].click();", readingLabel);

        captureScreenshot(driver, "demoqa_day8_form");

        driver.quit();
    }

    public static void captureScreenshot(WebDriver driver, String fileName) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        File destination = new File("screenshots/" + fileName + ".png");

        FileHandler.copy(source, destination);

        System.out.println("Screenshot saved: " + fileName);
    }
}