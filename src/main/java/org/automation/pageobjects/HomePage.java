package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private static final Logger log = LogManager.getRootLogger();
    private final BrowserManager manager = new BrowserManager();
    private final SeleniumActions actions = new SeleniumActions(manager);

    // Locators
    private static final By ASTA_E_OK_BUTTON = By.xpath("//button[@class=\"cm-btn cm-btn-success\"]");
    private static final By ACCEPT_ALL_BUTTON = By.xpath("//button[@onclick=\"fn_cookie_accept_all();\"]");
    private static final By Products_List_Search = By.xpath("//ul[@class='snize-ac-results-multicolumn-list']//li[@style='cursor: pointer;']");
    private static final By HOME_PAGE_LOGO = By.xpath("//div[@class='span16 et-fw-wrap margin-top margin-bottom hidden-phone hidden-tablet']//img");
    private static final By HOME_PAGE_PRODUCTS = By.xpath("//*[@id=\"sidebox_511_93\"]");
    private static final By SEARCH_FIELD = By.xpath("//*[@id=\"search_input702\"]");

    // Constants
    private static final Duration DEFAULT_WAIT = Duration.ofSeconds(10);

    public void openHomePage() {
        log.info("Opening home page...");
        manager.openBrowser();
        manager.getDriver().get("https://www.foxfishing.ro/");
        manager.getDriver().manage().window().maximize();
    }

    public boolean validateACCEPT_ALL_BUTTON() {
        log.info("Clicking on 'Accept All' button...");
        waitElementToBeClickable(ACCEPT_ALL_BUTTON);
        actions.clickElement(ACCEPT_ALL_BUTTON);
        return isElementGone(ACCEPT_ALL_BUTTON);
    }

    private void waitElementToBeClickable(By element) {
        log.debug("Waiting for element to be clickable: " + element);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), DEFAULT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private boolean isElementGone(By element) {
        log.debug("Validating that element is no longer visible: " + element);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), DEFAULT_WAIT);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void ASTA_E_OK_BUTTON() {
        log.info("Validating 'Asta e ok' button click...");
        waitElementToBeClickable(ASTA_E_OK_BUTTON);
        actions.clickElement(ASTA_E_OK_BUTTON);

        // Ensure the button is no longer visible
        if (!isElementGone(ASTA_E_OK_BUTTON)) {
            log.error("'Asta e ok' button is still visible after clicking.");
            throw new AssertionError("'Asta e ok' button should no longer be visible.");
        }
    }

    public String homePageTitle() {
        log.info("Getting home page title...");
        return manager.getDriver().getTitle();
    }

    public boolean isLogoDisplayed() {
        log.info("Checking if logo is displayed...");
        return actions.isElementDisplayed(HOME_PAGE_LOGO);
    }

    public boolean isLogoEnabled() {
        log.info("Checking if logo is enabled...");
        return actions.isElementEnabled(HOME_PAGE_LOGO);
    }

    public List<WebElement> productsDisplayed() {
        log.info("Retrieving displayed products...");
        return actions.getElements(HOME_PAGE_PRODUCTS);
    }

    public List<WebElement> getSearchResults() {
        log.info("Getting search results...");
        return actions.getElements(Products_List_Search);
    }
}
