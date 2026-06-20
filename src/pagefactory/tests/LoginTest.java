package pagefactory.tests;

import pagefactory.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    WebDriver driver;
    LoginPage loginpage;

    @BeforeMethod
    public void setup()
    {
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        loginpage=new LoginPage(driver);
    }
    @Test
    public void validLoginTest()
    {
        loginpage.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        System.out.println("Valid login passed");
    }
    @Test
    public void invalidLoginTest()
    {
        loginpage.login("invalid", "wrong");
        String actualError=loginpage.getErrorMessage();
        Assert.assertTrue(actualError.contains("Username and password"));
        System.out.println("Invalid Login passed");
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
