import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MouseHoverPractice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/menu");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement mainItem2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[normalize-space()='Main Item 2']")
                )
        );

        actions.moveToElement(mainItem2).perform();

        WebElement subSubList = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[normalize-space()='SUB SUB LIST »']")
                )
        );

        actions.moveToElement(subSubList).perform();

        WebElement subSubItem1 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[normalize-space()='Sub Sub Item 1']")
                )
        );

        System.out.println("Sub menu displayed: " + subSubItem1.isDisplayed());

        driver.quit();
    }
}