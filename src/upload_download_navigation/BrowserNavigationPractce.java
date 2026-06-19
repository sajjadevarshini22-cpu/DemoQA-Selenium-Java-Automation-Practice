package upload_download_navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrowserNavigationPractce {

    public static void main(String[]args) throws InterruptedException
    {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demoqa.com");
        Thread.sleep(2000);

        driver.navigate().to("https://demoqa.com/alerts");
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().refresh();
        System.out.println("Browser navigation practiced successfully");

        driver.quit();


    }
}
