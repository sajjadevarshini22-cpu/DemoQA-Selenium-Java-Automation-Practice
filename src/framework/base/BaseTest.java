package framework.base;

import framework.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    protected  WebDriver driver;

    @BeforeMethod
    public void setup() {

        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            System.out.println("Browser not supported: " + browser);
        }

        driver.get(ConfigReader.getProperty("url"));
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
