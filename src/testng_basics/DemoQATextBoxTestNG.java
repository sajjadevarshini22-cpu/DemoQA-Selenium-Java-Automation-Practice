package testng_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoQATextBoxTestNG {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void fillTextBoxFormTest() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")))
                .sendKeys("Devarshini Sajja");

        driver.findElement(By.id("userEmail")).sendKeys("devarshini@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Bangalore");
        driver.findElement(By.id("permanentAddress")).sendKeys("Bangalore");

        WebElement submitButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("submit"))
        );

        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitButton);
        js.executeScript("arguments[0].click();", submitButton);

        System.out.println("Text Box form submitted successfully");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}