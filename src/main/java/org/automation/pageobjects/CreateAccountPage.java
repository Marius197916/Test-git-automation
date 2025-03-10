package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;

public class CreateAccountPage {
    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);
    private BrowserManager manager;
    private SeleniumActions actions;

    private final static By ACCEPT_ALL_BUTTON = By.xpath("//*[@id='tygh_container']/div[5]/div[2]/div[2]/div[2]/button");
    private final static By INREGISTRARE_ACCOUNT_BUTTON = By.xpath("//*[@id='account_info_711']/div[2]/a[2]");

    public CreateAccountPage(BrowserManager browserManager) {
        this.manager = browserManager;
        this.actions = new SeleniumActions(manager);
    }

    public void clickInregistrareAccountButton() {
        log.info("Clicking on 'Inregistrare' button...");
        actions.clickElement(INREGISTRARE_ACCOUNT_BUTTON);
    }

    public boolean validateAcceptAllButton() {
        log.info("Clicking on 'Accept All' button...");
        actions.clickElement(ACCEPT_ALL_BUTTON);
        return actions.isElementInvisible(ACCEPT_ALL_BUTTON);
    }
}
