package action_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicClickPractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[text()='Click Me']")).click();

        String message = driver.findElement(By.id("dynamicClickMessage")).getText();

        System.out.println("Message: " + message);

        driver.quit();
    }
}