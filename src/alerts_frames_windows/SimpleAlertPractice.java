package alerts_frames_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;


public class SimpleAlertPractice {
    public static void main(String[]args)
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        driver.findElement(By.id("alertButton")).click();

        Alert alert=driver.switchTo().alert();

        System.out.println("Alert Text:"+alert.getText());
        alert.accept();

        driver.quit();
    }

}
