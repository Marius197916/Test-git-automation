
package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    //  private final static By ADMIN_SEARCH_BUTTON = By.xpath("//input[@placeholder='Search']");
    //  private final static By ADMIN_SEARCH_RESULT = By.xpath("//li[@class='oxd-main-menu-item-wrapper']");
    //  private final static By SEARCH_BOX_ADMIN_PAGE = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']");
    //  private final static By SEARCH_BUTTON_ADMIN_PAGE = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

    public void openFoxLoginPage() {
        log.info("Open Fox login page");
        manager.openBrowser();
        manager.getDriver().get("https://www.foxfishing.ro/");
        manager.getDriver().manage().window().maximize();
    }

    public void loginFox() {
        log.info("Login to Fox Page");
        String user = LoginDetails.LOGIN_USER.getUsername();
        String pass = LoginDetails.LOGIN_USER.getPassword();

        actions.waitElementToBeClickable(USERNAME_FIELD, 10);
        actions.sendKeys(USERNAME_FIELD, user);
        actions.sendKeys(PASSWORD_FIELD, pass);
        actions.clickElement(SUBMIT_BUTTON);
    }
}


