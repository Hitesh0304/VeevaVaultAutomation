import hiteshtestautomation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpLoginPage() {
        // Initialize the LoginPage object after the driver is set up in BaseTest
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testEmptyUsername() {
        loginPage.enterUsername("");  // Enter empty username
        loginPage.clickContinue();    // Click the Continue button

        // Verify the continue button is disabled
        Assert.assertFalse(loginPage.isContinueButtonEnabled());
    }

//    @Test
//    public void testIncorrectPassword() {
//        loginPage.enterUsername("invalidUsername");
//        loginPage.clickContinue();
//        loginPage.enterPassword("incorrectPassword");
//        loginPage.clickLogin();
//
//        // Verify incorrect login attempt message
//        Assert.assertTrue(loginPage.isIncorrectLoginErrorDisplayed(), "Error message for incorrect password is not displayed");
//    }

    @Test
    public void testEmptyPassword() {
        loginPage.enterUsername("someusername");
        loginPage.clickContinue();
        loginPage.clickLogin();  // Click login without entering a password

        // Verify error message for missing password
        Assert.assertTrue(loginPage.isMissingPasswordErrorDisplayed(), "Error message for missing password is not displayed");
    }
}
