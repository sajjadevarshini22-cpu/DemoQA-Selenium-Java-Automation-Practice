package upload_download_navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownloadPractice  {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        driver.findElement(By.id("downloadButton")).click();

        Thread.sleep(3000);

        System.out.println("Download button clicked");

        driver.quit();

    }
}
