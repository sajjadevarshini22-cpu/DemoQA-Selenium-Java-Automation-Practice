package framework.tests;

import framework.base.BaseTest;
import framework.pages.LoginPage;
import framework.utilities.ExcelUtil;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SauceDemoExcelLoginTest extends BaseTest {

    @DataProvider(name="excelLoginData")
    public Object[][] getLoginData() throws IOException
    {
        String filePath=System.getProperty("user.dir")+"/testdata/LoginTestData.xlsx";
        return ExcelUtil.getExcelData(filePath,"LoginData");
    }
    @Test(dataProvider = "excelLoginData")
    public void loginTestWithExcelData(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        if (username.equals("standard_user") && password.equals("secret_sauce")) {

            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

            System.out.println("Valid login passed for: " + username);

        } else {

            boolean errorDisplayed = driver.findElements(By.cssSelector("h3[data-test='error']")).size() > 0;

            Assert.assertTrue(errorDisplayed);

            System.out.println("Invalid login checked for: " + username);
        }
    }
}
