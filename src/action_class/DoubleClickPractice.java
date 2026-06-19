package action_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DoubleClickPractice {


    public static void main(String[] args)
    {
        WebDriver driver =new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Actions actions=new Actions(driver);

        WebElement doubleClickButton= driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickButton).perform();

        String message=driver.findElement(By.id("doubleClickMessage")).getText();
        System.out.println("Message:"+message);
        driver.quit();


    }
}
