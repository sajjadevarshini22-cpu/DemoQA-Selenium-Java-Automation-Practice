import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramePractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();

        WebElement frame1 = driver.findElement(By.id("frame1"));

        driver.switchTo().frame(frame1);

        String frameText = driver.findElement(By.id("sampleHeading")).getText();

        System.out.println("Frame text: " + frameText);

        driver.switchTo().defaultContent();

        driver.quit();
    }
}