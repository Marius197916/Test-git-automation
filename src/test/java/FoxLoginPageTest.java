import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.constants.LoginDetails;
import org.automation.pageobjects.LoginFox;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FoxLoginPageTest {

    LoginFox login = new LoginFox();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        login.openFoxLoginPage();
    }

    @Test
    public void loginWithValidCredentials() {
        login.FoxLoginPage(LoginDetails.LOGIN_USER.getUsername(), LoginDetails.LOGIN_USER.getPassword());
       assertTrue(login.isLoginSuccessful(), "Login should be successful with valid credentials.");
    }

    @Test
    public void loginWithInvalidCredentials() {
        login.FoxLoginPage(LoginDetails.INVALID_USER.getUsername(), LoginDetails.INVALID_USER.getPassword());
        assertFalse(login.isLoginSuccessful(), "Login should fail with invalid credentials.");
    }

    @Test
    public void loginWithEmptyCredentials() {
        login.FoxLoginPage(LoginDetails.EMPTY_USER.getUsername(), LoginDetails.EMPTY_USER.getPassword());
        assertFalse(login.isLoginSuccessful(), "Login should fail with empty credentials.");
    }

    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}
