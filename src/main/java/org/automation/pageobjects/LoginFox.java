package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.automation.framework.constants.LoginDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFox {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager = new BrowserManager();
    SeleniumActions actions = new SeleniumActions(manager);

    private final static By USERNAME_FIELD = By.xpath("//*[@id=login_popup711]");
    private final static By PASSWORD_FIELD = By.xpath("//*[@id=psw_popup711]");
    private final static By SUMIT_BUTTON = By.xpath("//*[@id=popup711_login_popup_form_container]/form/div[4]/div[1]/button");


    public void openFoxLoginPage() {
        log.info("Open Fox login page");
        manager.openBrowser();
        manager.getDriver().get("https://www.foxfishing.ro/");
        manager.getDriver().manage().window().maximize();


    }

    // a fost creata automat
    public void FoxLoginPage() {
        log.info("Login to Fox");

        String user = LoginDetails.INVALID_USER.getUsername();
        String pass = LoginDetails.INVALID_USER.getPassword();
        actions.sendKeys(USERNAME_FIELD,user);
        actions.sendKeys(PASSWORD_FIELD,pass);
        actions.clickElement(SUMMIT_BUTTON);
    }
}
