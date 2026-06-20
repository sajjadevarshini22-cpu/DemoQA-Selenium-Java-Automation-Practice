package framework.pages;

import framework.utilities.WaitUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    By productsTitle = By.className("title");
    By firstAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductsTitle() {
        return WaitUtil.waitForVisibility(driver, productsTitle).getText();
    }

    public void clickFirstAddToCartButton() {
        WaitUtil.waitForClickability(driver, firstAddToCartButton).click();
    }

    public void clickCartIcon() {
        WaitUtil.waitForClickability(driver, cartIcon).click();
    }
}