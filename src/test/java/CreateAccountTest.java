import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.CreateAccountPage;
import org.automation.pageobjects.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAccountTest {

    HomePage homePage = new HomePage();
    CreateAccountPage createAccountPage = new CreateAccountPage();

    @BeforeEach
    public void setUp() {
        homePage.openHomePage();
    }

    // @Test
    //  public void validateCreateAccountFields() {
    //    createAccountPage.clickCreateAccountButton();
    //   List<String> labelsText = createAccountPage.getAccountLabels();
    // }
  //  @Test
  //  @Order(value = 1)

    public void validateACCEPT_ALL_BUTTON() {
        Logger log = LogManager.getRootLogger();
        BrowserManager browserManager = new BrowserManager();
        log.info("Validating 'Accept All' button click...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tygh_container']/div[5]/div[2]/div[2]/div[2]/button")));

    }
    @Test
    public void validateInregistrareAccountButton() {
        Logger log = LogManager.getRootLogger();
        BrowserManager browserManager = new BrowserManager();
        log.info("Validating 'Inregistrare Account' button click...");
        WebDriverWait wait = new WebDriverWait(browserManager.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='account_info_711']/div[2]/a[2]")));
    }


//    @AfterEach
    //   public void tearDown() {
    //       BrowserManager.closeDriver();
    //  }
}
