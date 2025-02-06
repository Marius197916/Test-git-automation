import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.constants.LoginDetails;
import org.automation.pageobjects.LoginFox;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FoxLoginPageTest {

    private BrowserManager browserManager;
    private LoginFox login;
    private Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        browserManager = new BrowserManager();
        login = new LoginFox(browserManager);
        login.openFoxLoginPage();
    }

    @Test
    public void loginWithValidCredentials() {
        log.info("Testing login with valid credentials...");
        login.validateLOGIN_ICON();
        login.FoxLoginPage(LoginDetails.LOGIN_USER.getUsername(), LoginDetails.LOGIN_USER.getPassword());
        assertTrue(login.isLoginSuccessful(), "Login should be successful with valid credentials.");
    }

    @Test
    public void loginWithInvalidCredentials() {
        log.info("Testing login with invalid credentials...");
        login.validateLOGIN_ICON();
        login.FoxLoginPage(LoginDetails.INVALID_USER.getUsername(), LoginDetails.INVALID_USER.getPassword());
        assertFalse(login.isLoginSuccessful(), "Login should fail with invalid credentials.");
    }

    @Test
    public void loginWithEmptyCredentials() {
        log.info("Testing login with empty credentials...");
        login.validateLOGIN_ICON();
        login.FoxLoginPage(LoginDetails.EMPTY_USER.getUsername(), LoginDetails.EMPTY_USER.getPassword());
        assertFalse(login.isLoginSuccessful(), "Login should fail with empty credentials.");
    }

    @Test
    public void validateLOGIN_ICON() {
        log.info("Validating login icon visibility and clickability...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sw_dropdown_711']")));
        assertTrue(login.validateLOGIN_ICON(), "Login icon should be visible and clickable.");
    }

    @Test
    public void validateACCEPT_ALL_BUTTON() {
        log.info("Validating 'Accept All' button click...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tygh_container']/div[5]/div[2]/div[2]/div[2]/button")));
        assertTrue(login.validateACCEPT_ALL_BUTTON(), "'Accept All' button should be visible and clickable.");
    }

    @Test
    public void ASTA_E_OK_BUTTON() {
        log.info("Validating 'Asta e ok' button click...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='klaro']/div/div/div/div/div/button")));
        assertTrue(login.validateASTA_E_OK_BUTTON(), "'Asta e ok' button should be visible and clickable.");
    }

    @AfterEach
    public void tearDown() {
        log.info("Closing browser...");
        browserManager.closeDriver();
    }
}
