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


    @BeforeEach
    public void setUp() {
        browserManager = new BrowserManager();
        login = new LoginFox(browserManager);
        login.openFoxLoginPage();
    }


    @Test
    @Order(value = 5)
    public void loginWithValidCredentials() {
        log.info("Testing login with valid credentials...");
//        login.validateACCEPT_ALL_BUTTON();
        login.validateLOGIN_ICON();
        login.validateLOGIN_BUTTON();
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        login.FoxLoginPage(LoginDetails.LOGIN_USER.getUsername(), LoginDetails.LOGIN_USER.getPassword());
        assertTrue(login.isLoginSuccessful(), "Login should be successful with valid credentials.");
    }


    @Test
    @Order(value = 3)
    public void validateLOGIN_ICON() {
        log.info("Validating login icon visibility and click ability...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sw_dropdown_711\"]/a")));
        assertTrue(login.validateLOGIN_ICON(), "Login icon should be visible and clickable.");
    }


    @Test
    @Order(value = 1)

    public void validateACCEPT_ALL_BUTTON() {
        log.info("Validating 'Accept All' button click...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick=\"fn_cookie_accept_all();\"]")));
        assertTrue(login.validateACCEPT_ALL_BUTTON(), "'Accept All' button should be visible and clickable.");
    }


    @Test
    @Order(value = 2)
    public void ASTA_E_OK_BUTTON() {
        log.info("Validating 'Asta e ok' button click...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"cm-btn cm-btn-success\"]")));
        assertTrue(login.validateASTA_E_OK_BUTTON(), "'Asta e ok' button should be visible and clickable.");
    }

    @Test
    @Order(8)
    @DisplayName("Test search produs")
    public void searchProductTest() {
        log.info("Testing search functionality...");
        login.searchElementFromDropDown("Bocanci");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='snize-ac-results-multicolumn-list']//li[@style='cursor: pointer;'])[1]")));
        List<WebElement> results = homePage.getSearchResults();
        log.info("Number of search results: " + results.size());
        for (WebElement result : results) {
            log.info("Search result: " + result.getText());
            assertTrue(result.getText().contains("Bocanci"), "Search result should contain 'Bocanci'.");
        }
    }


    @AfterAll
    public static void tearDown() {

        BrowserManager.closeDriver();
    }
}
