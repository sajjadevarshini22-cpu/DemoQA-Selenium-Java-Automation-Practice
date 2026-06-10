import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowPractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        String parentWindow = driver.getWindowHandle();

        driver.findElement(By.id("windowButton")).click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        String text = driver.findElement(By.id("sampleHeading")).getText();

        System.out.println("New window text: " + text);

        driver.close();

        driver.switchTo().window(parentWindow);

        driver.quit();
    }
}