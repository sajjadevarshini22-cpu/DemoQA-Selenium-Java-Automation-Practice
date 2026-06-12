import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class RightClickPractice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement rightClickButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("rightClickBtn"))
        );

        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).perform();

        WebElement messageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("rightClickMessage"))
        );

        String message = messageElement.getText();

        System.out.println("Message: " + message);

        driver.quit();
    }
}