package alerts_frames_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
public class PromptAlertPrcatice {
    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        driver.findElement(By.id("promtButton")).click();
        Alert alert =driver.switchTo().alert();
        alert.sendKeys("Devarshini");
        alert.accept();

        String result=driver.findElement(By.id("promptResult")).getText();

        System.out.println("Result:"+result);
        driver.quit();
    }

}
