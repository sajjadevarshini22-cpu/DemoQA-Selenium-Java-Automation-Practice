package pom_basics.tests;
import pom_basics.pages.LoginPage;
import pom_basics.pages.InventoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void setup()
    {
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        loginPage=new LoginPage(driver);
    }
    @Test
    public void validLoginTest()
    {
        loginPage.login("standard_user", "secret_sauce");
        String currentUrl=driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"));
        System.out.println("Valid Login Test Passed");
    }
    @Test
    public void invalidLoginTest(){
        loginPage.login("invalid_user", "wrong_password");
        String actualError=loginPage.getErrorMessage();
        Assert.assertTrue(actualError.contains("Username and password do not match any user in this service"));
        System.out.println("Invalid login test passed");
    }
    @Test
    public void addProductToCartTest() {

        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);

        String title = inventoryPage.getProductsTitle();

        Assert.assertEquals(title, "Products");

        inventoryPage.clickFirstAddToCartButton();

        inventoryPage.clickCartIcon();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));

        System.out.println("Add product to cart test passed");
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
