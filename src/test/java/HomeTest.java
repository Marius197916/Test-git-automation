import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
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

    HomePage homePage = new HomePage();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        homePage.openHomePage();
    }

    @Test
    @DisplayName("Validate title test")
    // am adaugat InterruptedException
    public void validateTitle() throws InterruptedException {
        log.info("Validate title");
        String title = homePage.homePageTitle();
        assertEquals("FoxFishing.ro - Magazin cu Articole de Pescuit si Outdoor✓", title, "  " + title);
        Thread.sleep(3000);

    }

    @Test
    @DisplayName("Validate logo test")
    public void validateLogo() {
        // nu vad butonul de logo pe pagina
        //wait time de implementat
        String buttonXPath = "//*[@id=\"tygh_container\"]/div[5]/div[2]/div[2]/div[2]/button";
        driver.findElement(By.xpath(buttonXPath)).click();
        log.info("Validate home page logo");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isLogoDisplayed = homePage.isLogoDisplayed();
        boolean isLogoEnabled = homePage.isLogoEnabled();
        assertTrue(isLogoDisplayed, "Logo is not displayed");
        assertTrue(isLogoEnabled, "Logo is not enabled");
    }

    @Test
    @DisplayName("Validare buton Facebook")
    public void validateFacebookButton() throws InterruptedException {
        String buttonXPath = "//*[@id=\"index_index\"]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/a[1]/i";
        driver.findElement(By.xpath(buttonXPath)).click();
        //   Thread.sleep(3000);
        //nu merge calea aleasa
        //  String cookieXPath = "//*[@id='facebook']/body/div[2]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]";
        //  driver.findElement(By.xpath(cookieXPath)).click();

    }

    @Test
    @DisplayName("Validare buton Instagram")
    public void validateInstagramButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div/div/div/div/div[2]/div/button[1]")));
        element.click();

        String buttonXPath = "//*[@id=index_index]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/a[2]/i";
        driver.findElement(By.xpath(buttonXPath)).click();


        String cookieXPath = "/html/body/div[5]/div[1]/div/div[2]/div/div/div/div/div[2]/div/button[1]";
        driver.findElement(By.xpath(cookieXPath)).click();


    }

    @Test
    @DisplayName("Validare buton Youtube")
    public void validateYouTubeButton() {
        String buttonXPath = "//*[@id=\"index_index\"]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/a[3]/i";
        driver.findElement(By.xpath(buttonXPath)).click();
        String cookieXPath = "(//button[@aria-label='Accept all'])[1]";
        driver.findElement(By.xpath(buttonXPath)).click();

    }

    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }

}

