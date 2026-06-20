package framework.tests;
import framework.base.BaseTest;
import framework.pages.InventoryPage;
import framework.pages.LoginPage;
import framework.utilities.ScreenshotUtil;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest
{
    @Test
    public void validLoginTest() throws IOException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

        ScreenshotUtil.captureScreenshot(driver, "validLoginTest");

        System.out.println("Valid login test passed");
    }
    @Test
    public void invalidLoginTest() throws IOException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("invalid_user", "wrong_password");

        String actualError = loginPage.getErrorMessage();

        Assert.assertTrue(actualError.contains("Username and password do not match"));

        ScreenshotUtil.captureScreenshot(driver, "invalidLoginTest");

        System.out.println("Invalid login test passed");
    }
    @Test
    public void addProductToCartTest() throws IOException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertEquals(inventoryPage.getProductsTitle(), "Products");

        inventoryPage.clickFirstAddToCartButton();

        inventoryPage.clickCartIcon();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));

        ScreenshotUtil.captureScreenshot(driver, "addProductToCartTest");

        System.out.println("Add product to cart test passed");}


}
