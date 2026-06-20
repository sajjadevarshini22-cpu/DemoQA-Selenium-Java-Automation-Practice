package pom_basics.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    By productsTitle=By.className("title");
    By firstAddToCartButton=By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon=By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public String getProductsTitle()
    {
        return driver.findElement(productsTitle).getText();
    }
    public void clickFirstAddToCartButton()
    {
        driver.findElement(firstAddToCartButton).click();
    }
    public void clickCartIcon()
    {
        driver.findElement(cartIcon).click();
    }
}
