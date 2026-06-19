package javascriptexecutor_screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptExecutorPractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement firstName = driver.findElement(By.id("firstName"));
        js.executeScript("arguments[0].value='Devarshini';", firstName);

        WebElement lastName = driver.findElement(By.id("lastName"));
        js.executeScript("arguments[0].value='Sajja';", lastName);

        WebElement email = driver.findElement(By.id("userEmail"));
        js.executeScript("arguments[0].value='devarshini@gmail.com';", email);

        WebElement femaleGender = driver.findElement(By.xpath("//label[text()='Female']"));
        js.executeScript("arguments[0].click();", femaleGender);

        WebElement mobile = driver.findElement(By.id("userNumber"));
        js.executeScript("arguments[0].value='9876543210';", mobile);

        WebElement readingLabel = driver.findElement(By.xpath("//label[text()='Reading']"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", readingLabel);
        js.executeScript("arguments[0].click();", readingLabel);

        WebElement address = driver.findElement(By.id("currentAddress"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", address);
        js.executeScript("arguments[0].value='Bangalore';", address);

        String title = js.executeScript("return document.title;").toString();
        System.out.println("Page Title: " + title);

        driver.quit();
    }
}