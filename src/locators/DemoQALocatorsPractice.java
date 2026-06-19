package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQALocatorsPractice {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        driver.findElement(By.id("firstName")).sendKeys("Devarshini");
        driver.findElement(By.id("lastName")).sendKeys("Sajja");
        driver.findElement(By.id("userEmail")).sendKeys("devarshini.qa@gmail.com");
        driver.findElement(By.id("userNumber")).sendKeys("9876543210");
        driver.findElement(By.id("currentAddress")).sendKeys("Bangalore");

        driver.quit();

    }

}