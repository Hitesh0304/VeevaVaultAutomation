package hiteshtestautomation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private AndroidDriver driver;

    // Locators for login elements
    private By usernameField = By.id("com.veeva.vault.mobile:id/login_username_input");
    private By continueButton = By.id("com.veeva.vault.mobile:id/login_action_button");
    private By loginButton = By.xpath("//android.widget.Button[@text='LOG IN']");
    private By passwordField = By.xpath("//android.webkit.WebView[@text='Login']/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]");
    private By errorMessage = By.id("com.veeva.vault.mobile:id/errorText");
    private By missingPasswordError = By.xpath("//android.widget.TextView[@text='Please enter a password']");
    private By incorrectLoginError = By.xpath("//android.widget.TextView[@text='Your login attempt has failed. The specified user name or password may be incorrect.']");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Methods for interacting with the login page
    public void enterUsername(String username) {
        WebElement usernameFieldElement = driver.findElement(usernameField);
        usernameFieldElement.clear();
        usernameFieldElement.sendKeys(username);
    }

    public void clickContinue() {
        WebElement continueButtonElement = driver.findElement(continueButton);
        continueButtonElement.click();
    }

    public void enterPassword(String password) {
        WebElement passwordFieldElement = driver.findElement(passwordField);
        passwordFieldElement.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
    }

    public boolean isErrorMessageDisplayed() {
        WebElement errorMessageElement = driver.findElement(errorMessage);
        return errorMessageElement.isDisplayed();
    }

    public boolean isMissingPasswordErrorDisplayed() {
        WebElement errorMessageElement = driver.findElement(missingPasswordError);
        return errorMessageElement.isDisplayed();
    }

    public boolean isIncorrectLoginErrorDisplayed() {
        WebElement errorMessageElement = driver.findElement(incorrectLoginError);
        return errorMessageElement.isDisplayed();
    }

    public boolean isContinueButtonEnabled() {
        WebElement continueButtonElement = driver.findElement(continueButton);
        return continueButtonElement.isEnabled();
    }
}
