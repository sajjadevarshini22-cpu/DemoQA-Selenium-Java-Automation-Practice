import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotPractice {

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

        WebElement address = driver.findElement(By.id("currentAddress"));
        address.sendKeys("Bangalore");

        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Get current project path
        String projectPath = System.getProperty("user.dir");

        // Create screenshots folder
        File folder = new File(projectPath + File.separator + "screenshots");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Save screenshot
        File destination = new File(folder, "demoqa_form.png");

        FileHandler.copy(source, destination);

        System.out.println("Screenshot captured successfully");
        System.out.println("Saved at: " + destination.getAbsolutePath());

        driver.quit();
    }
}