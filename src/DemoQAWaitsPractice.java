import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DemoQAWaitsPractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement firstName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))
        );
        firstName.sendKeys("Devarshini");

        WebElement lastName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))
        );
        lastName.sendKeys("Sajja");

        WebElement email = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("userEmail"))
        );
        email.sendKeys("devarshini@gmail.com");

        WebElement femaleGender = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Female']"))
        );
        femaleGender.click();

        // Mobile Number
        WebElement mobileNumber = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("userNumber"))
        );
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", mobileNumber);
        mobileNumber.clear();
        mobileNumber.sendKeys("9876543210");

        // Reading Hobby
        WebElement readingLabel = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Reading']"))
        );
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", readingLabel);
        js.executeScript("arguments[0].click();", readingLabel);

        WebElement readingCheckbox = driver.findElement(By.id("hobbies-checkbox-2"));
        System.out.println("Reading Selected: " + readingCheckbox.isSelected());

        WebElement address = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("currentAddress"))
        );
        address.sendKeys("Bangalore");

        driver.quit();
    }
}