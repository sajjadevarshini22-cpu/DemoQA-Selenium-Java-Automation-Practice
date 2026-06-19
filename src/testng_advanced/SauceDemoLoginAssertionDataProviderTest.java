package testng_advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class SauceDemoLoginAssertionDataProviderTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @DataProvider(name = "validLoginData")
    public Object[][] getValidLoginData() {

        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"}
        };

    }
    @Test(dataProvider = "validLoginData")
    public void validLoginTest(String username, String password) {

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("inventory"));

        System.out.println("Valid login passed for user: " + username);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
