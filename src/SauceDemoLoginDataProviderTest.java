import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
public class SauceDemoLoginDataProviderTest {

    WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @DataProvider(name="loginData")
    public Object[][] getLoginData()
    {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"invalid_user", "wrong_password"}
        };
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        System.out.println("Login tested with: " + username + " / " + password);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
