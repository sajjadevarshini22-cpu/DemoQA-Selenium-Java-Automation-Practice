package action_class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionsPractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement fullName = driver.findElement(By.id("userName"));

        fullName.sendKeys("Wrong Name");

        actions.click(fullName)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("Devarshini Sajja")
                .perform();

        String enteredValue = fullName.getAttribute("value");

        System.out.println("Entered Name: " + enteredValue);

        driver.quit();
    }
}