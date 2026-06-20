package framework.pages;

import framework.utilities.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WaitUtil.waitForVisibility(driver, usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        WaitUtil.waitForVisibility(driver, passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        WaitUtil.waitForClickability(driver, loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        return WaitUtil.waitForVisibility(driver, errorMessage).getText();
    }
}