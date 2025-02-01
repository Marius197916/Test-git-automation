package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
// nu vede org.automation.constants.LoginDetails
import org.automation.constants.LoginDetails;

import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;

public class LoginFox {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By USERNAME_FIELD = By.xpath("//*[@id=login_popup711]");
    private final static By PASSWORD_FIELD = By.xpath("//*[@id=psw_popup711]");
    private final static By SUBMIT_BUTTON = By.xpath("//*[@id=popup711_login_popup_form_container]/form/div[4]/div[1]/button");

    // Metoda care face login-ul pe site cu datele primite ca parametri
    public void FoxLoginPage(String username, String password) {
        log.info("Login to Fox with username: " + username);
        actions.sendKeys(USERNAME_FIELD, username);
        actions.sendKeys(PASSWORD_FIELD, password);
        actions.clickElement(SUBMIT_BUTTON);
    }

    // Metoda care deschide pagina de login Fox
    public void openFoxLoginPage() {
        log.info("Opening Fox login page...");
        manager.getDriver().get("https://www.foxfishing.ro/");
        manager.getDriver().manage().window().maximize();
    }
}
