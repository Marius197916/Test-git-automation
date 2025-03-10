import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.constants.LoginDetails;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.HomePage;
import org.automation.pageobjects.LoginFox;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvalidLoginTest {

    Logger log = LogManager.getRootLogger();
    private BrowserManager browserManager;
    private LoginFox login;

    @BeforeEach
    public void setUp() throws InterruptedException {
        browserManager = new BrowserManager();
        login = new LoginFox(browserManager);
        Thread.sleep(5000);
        login.openFoxLoginPage();
    }

    @Test
    @Order(value = 2)
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithInvalidCredentials() {
        log.info("Testing login with invalid credentials...");
        login.validateACCEPT_ALL_BUTTON();
        login.validateASTA_E_OK_BUTTON();
        login.validateLOGIN_ICON();
        login.validateLOGIN_BUTTON();
        login.FoxLoginPage(LoginDetails.INVALID_USER.getUsername(), LoginDetails.INVALID_USER.getPassword());
        assertTrue(login.isLoginSuccessful(), "Login should fail with invalid credentials.");
        System.out.println("Login failed with invalid credentials.");
    }

    @Test
    @Order(value = 1)
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithEmptyCredentials() {

        log.info("Testing login with empty credentials...");
        login.validateACCEPT_ALL_BUTTON();
        login.validateASTA_E_OK_BUTTON();
        login.validateLOGIN_ICON();
        login.validateLOGIN_BUTTON();
        login.FoxLoginPage(LoginDetails.EMPTY_USER.getUsername(), LoginDetails.EMPTY_USER.getPassword());
        assertTrue(login.isLoginSuccessful(), "Login should fail with empty credentials.");
        System.out.println("Login failed with empty credentials.");
    }

    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}
