import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.automation.pageobjects.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.automation.framework.BrowserManager.driver;
import static org.junit.jupiter.api.Assertions.*;


public class HomeTest {
    private static final By ACCEPT_ALL_BUTTON = By.xpath("//button[@onclick=\"fn_cookie_accept_all();\"]");

    BrowserManager manager;
    SeleniumActions actions;
    HomePage homePage = new HomePage();
    Logger log = LogManager.getRootLogger();
    private HomeTest login;

    @BeforeEach
    public void setUp() {
        homePage.openHomePage();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Validate title test")
    public void validateTitle() throws InterruptedException {
        log.info("Validate title");
        String title = homePage.homePageTitle();
        assertEquals("FoxFishing.ro - Magazin cu Articole de Pescuit si Outdoor✓", title, "  " + title);
        Thread.sleep(3000);

    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Validate logo test")
    public void validateLogo() {
        String buttonXPath = "//div[@class='span16 et-fw-wrap margin-top margin-bottom hidden-phone hidden-tablet']//img";
        driver.findElement(By.xpath(buttonXPath)).click();
        log.info("Validate home page logo");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='span16 et-fw-wrap margin-top margin-bottom hidden-phone hidden-tablet']//img")));
        boolean isLogoDisplayed = homePage.isLogoDisplayed();
        boolean isLogoEnabled = homePage.isLogoEnabled();
        assertTrue(isLogoDisplayed, "Logo is not displayed");
        assertTrue(isLogoEnabled, "Logo is not enabled");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Validare buton Facebook")
    public void validateFacebookButton() {

        String buttonXPath = "//*[@id=\"index_index\"]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/a[1]/i";
        driver.findElement(By.xpath(buttonXPath)).click();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Validare buton Instagram")
    public void validateInstagramButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"index_index\"]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/a[2]/i")));
        element.click();
        String buttonXPath = "//*[@id=\"index_index\"]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/a[2]/i";
        driver.findElement(By.xpath(buttonXPath)).click();

    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Validare buton Youtube")
    public void validateYouTubeButton() {
        //  actions.clickElement(ACCEPT_ALL_BUTTON);
        String buttonXPath = "//*[@id=\"index_index\"]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/a[3]/i";
        driver.findElement(By.xpath(buttonXPath)).click();


    }

    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }

}

