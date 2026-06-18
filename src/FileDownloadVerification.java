import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class FileDownloadVerification {

    public static void main(String[] args) throws InterruptedException{

        WebDriver driver =new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();
        driver.findElement(By.id("downloadButton")).click();

        Thread.sleep(3000);
        File downloadedFile=new File("C:/Users/devar/IdeaProjects/DemoQA-Selenium-Java-Automation-Practice/testdata/demoqa.png");
        if(downloadedFile.exists())
        {
            System.out.println("File downloaded successfully");
        }
        else {
            System.out.println("File Not downloaded");
        }
        driver.quit();
    }
}
