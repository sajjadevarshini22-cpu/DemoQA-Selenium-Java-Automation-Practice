package alerts_frames_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmationAlertPractice {
    public static void main(String[]args)
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        driver.findElement(By.id("confirmButton")).click();
        Alert alert=driver.switchTo().alert();

        System.out.println("Alert Text:"+alert.getText());
        alert.accept();

        String result=driver.findElement(By.id("confirmResult")).getText();
        System.out.println("Result:"+result);
        driver.quit();
    }
}
