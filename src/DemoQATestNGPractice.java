import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class DemoQATestNGPractice {

    WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
    }
    @Test
    public void textBoxTest()
    {
        System.out.println("Test case started");
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
