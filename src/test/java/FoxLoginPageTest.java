import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.constants.LoginDetails;
import org.automation.pageobjects.HomePage;
import org.automation.pageobjects.LoginFox;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FoxLoginPageTest {
    HomePage homePage = new HomePage();
    Logger log = LogManager.getRootLogger();
    private BrowserManager browserManager;
    private LoginFox login;
  //  private final Logger log = LogManager.getRootLogger();
  //  LoginFox homePage;
   // private LoginFox homePage;

    @BeforeEach
    public void setUp() {
        browserManager = new BrowserManager();
        login = new LoginFox(browserManager);
        login.openFoxLoginPage();
    }

    // element not interactable?
    @Test
    @Order(value = 5)
    public void loginWithValidCredentials() {
        log.info("Testing login with valid credentials...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        login.FoxLoginPage(LoginDetails.LOGIN_USER.getUsername(), LoginDetails.LOGIN_USER.getPassword());
        assertTrue(login.isLoginSuccessful(), "Login should be successful with valid credentials.");
    }

    // element not interactable ?
    @Test
    @Order(value = 6)
    public void loginWithInvalidCredentials() {
        log.info("Testing login with invalid credentials...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        login.FoxLoginPage(LoginDetails.INVALID_USER.getUsername(), LoginDetails.INVALID_USER.getPassword());
        assertTrue(login.isLoginSuccessful(), "Login should fail with invalid credentials.");
    }

    // element not interactable ?
    @Test
    @Order(value = 7)
    public void loginWithEmptyCredentials() {
        log.info("Testing login with empty credentials...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        login.FoxLoginPage(LoginDetails.EMPTY_USER.getUsername(), LoginDetails.EMPTY_USER.getPassword());
        assertTrue(login.isLoginSuccessful(), "Login should fail with empty credentials.");
    }

    // element not interactable ?
    @Test
    @Order(value = 3)
    public void validateLOGIN_ICON() {
        log.info("Validating login icon visibility and click ability...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sw_dropdown_711\"]/a")));
        assertTrue(login.validateLOGIN_ICON(), "Login icon should be visible and clickable.");
    }

    @Test
    @Order(value = 4)
    public void validateLOGIN_BUTTON() {
        log.info("Validating button icon visibility and click ability...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"account_info_711\"]/div[2]/a[1]")));
        assertTrue(login.validateLOGIN_ICON(), "Login button should be visible and clickable.");
    }

    // method is working
    @Test
    @Order(value = 1)

    public void validateACCEPT_ALL_BUTTON() {
        log.info("Validating 'Accept All' button click...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tygh_container']/div[5]/div[2]/div[2]/div[2]/button")));
        assertTrue(login.validateACCEPT_ALL_BUTTON(), "'Accept All' button should be visible and clickable.");
    }

    // unable to locate element
    @Test
    @Order(value = 2)
    public void ASTA_E_OK_BUTTON() {
        log.info("Validating 'Asta e ok' button click...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"klaro\"]/div/div/div/div/div/button")));
        assertTrue(login.validateASTA_E_OK_BUTTON(), "'Asta e ok' button should be visible and clickable.");
    }
    @Test
    @Order(8)
    @DisplayName("Test search produs")
    public void searchProductTest() {
        log.info("Testing search functionality...");
        login.searchElementFromDropDown("Bocanci");
        List<WebElement> results = homePage.getSearchResults();
        log.info("Number of search results: " + results.size());
        for (WebElement result : results) {
            log.info("Search result: " + result.getText());
            assertTrue(result.getText().contains("Bocanci"), "Search result should contain 'Bocanci'.");
        }
    }
    }

//    @AfterEach
    //   public void tearDown() {
    //      log.info("Closing browser...");
    //       BrowserManager.closeDriver();
    //  }

