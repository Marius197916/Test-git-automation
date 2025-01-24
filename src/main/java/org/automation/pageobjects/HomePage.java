package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By HOME_PAGE_BANNER = By.xpath("////*[@id=\"index_index\"]/div[3]/div/div[1]/div/div");
    private final static By HOME_PAGE_PRODUCTS = By.xpath("//*[@id=\"sidebox_511_93\"]");

    public void openHomePage() {
        log.info("Open home page");
        manager.openBrowser();
        manager.getDriver().get("https://www.foxfishing.ro/");
        manager.getDriver().manage().window().maximize();
    }

    public String homePageTitle() {
        log.info("Get home page title");
        return manager.getDriver().getTitle();
    }

    public boolean isBannerDisplayed() {
        log.info("Check if banner is displayed");
        return actions.isElementDisplayed(HOME_PAGE_BANNER);
    }

    public boolean isBannerEnabled() {
        log.info("Check if banner is enabled");
        return actions.isElementEnabled(HOME_PAGE_BANNER);
    }

    public List<WebElement> productsDisplayed() {
        log.info("Check if products are displayed");
        return actions.getElements(HOME_PAGE_PRODUCTS);
    }
}
