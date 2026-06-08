import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class DemoQAFormDay4Practice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Basic details
        driver.findElement(By.id("firstName")).sendKeys("Devarshini");
        driver.findElement(By.id("lastName")).sendKeys("Sajja");
        driver.findElement(By.id("userEmail")).sendKeys("devarshini@gmail.com");

        // Gender
        driver.findElement(By.xpath("//label[text()='Female']")).click();

        // Mobile
        driver.findElement(By.id("userNumber")).sendKeys("9876543210");

        // DOB
        driver.findElement(By.id("dateOfBirthInput")).click();

        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        Select month = new Select(monthDropdown);
        month.selectByVisibleText("June");

        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        Select year = new Select(yearDropdown);
        year.selectByVisibleText("2001");

        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and not(contains(@class,'react-datepicker__day--outside-month')) and text()='15']")).click();

        // Hobby - Reading
        WebElement readingLabel = driver.findElement(By.xpath("//label[text()='Reading']"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", readingLabel);
        wait.until(ExpectedConditions.elementToBeClickable(readingLabel));
        js.executeScript("arguments[0].click();", readingLabel);

        WebElement readingCheckbox = driver.findElement(By.id("hobbies-checkbox-2"));
        System.out.println("Reading Selected: " + readingCheckbox.isSelected());

        // Address
        driver.findElement(By.id("currentAddress")).sendKeys("Bangalore");

        // State dropdown
        WebElement stateDropdown = driver.findElement(By.id("state"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", stateDropdown);
        wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));
        stateDropdown.click();

        WebElement ncrOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='NCR']")));
        ncrOption.click();

        // City dropdown
        WebElement cityDropdown = driver.findElement(By.id("city"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", cityDropdown);
        wait.until(ExpectedConditions.elementToBeClickable(cityDropdown));
        cityDropdown.click();

        WebElement delhiOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Delhi']")));
        delhiOption.click();

        // Verify DOB
        String dob = driver.findElement(By.id("dateOfBirthInput")).getAttribute("value");
        System.out.println("Date of Birth selected: " + dob);

        driver.quit();
    }
}