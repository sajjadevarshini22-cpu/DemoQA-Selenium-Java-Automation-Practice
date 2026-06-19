package testng_advanced;

import org.testng.annotations.Test;
public class DependsOnMethodsPractice {
    @Test
    public void loginTest()
    {
        System.out.println("Login Successfull");
    }
    @Test(dependsOnMethods="loginTest")
    public void searchProductTest()
    {
        System.out.println("product searched successfully");
    }
    @Test(dependsOnMethods="searchProductTest")
    public void addToCartTest()
    {
        System.out.println("product added to cart");
    }
    @Test(dependsOnMethods="addToCartTest")
    public void checkoutTest()
    {
        System.out.println("checkout completed");
    }
}
