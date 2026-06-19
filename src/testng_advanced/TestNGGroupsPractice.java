package testng_advanced;

import org.testng.annotations.Test;
public class TestNGGroupsPractice {
    @Test(groups="smoke")
    public void loginTest()
    {
        System.out.println("Somke Test:Login");
    }
    @Test(groups="regression")
    public void searchroduct()
    {
        System.out.println("Regression Test:Search product");
    }
    @Test(groups={"smoke","regression"})
    public void addToCartTest()
    {
        System.out.println("Smoke and Regression Test:Add to Cart");
    }
    @Test(groups="regression")
    public void paymentTest()
    {
        System.out.println("Regression Test:Payment");
    }

}
