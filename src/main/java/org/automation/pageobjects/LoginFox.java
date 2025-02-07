package org.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.framework.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginFox {

    Logger log = LogManager.getRootLogger();
    BrowserManager manager;
    SeleniumActions actions;

    // Locatori pentru elementele de pe pagina de login
    private final static By ASTA_E_OK_BUTTON = By.xpath("//*[@id=klaro]/div/div/div/div/div/button");
    private final static By ACCEPT_ALL_BUTTON = By.xpath("//*[@id='tygh_container']/div[5]/div[2]/div[2]/div[2]/button");
    private final static By LOGIN_ICON = By.xpath("//*[@id='sw_dropdown_711']");
    private final static By LOGIN_BUTTON = By.xpath("//*[@id='account_info_711']/div[2]/a[1]");
    private final static By USERNAME_FIELD = By.xpath("//*[@id='login_popup711']");
    private final static By PASSWORD_FIELD = By.xpath("//*[@id='psw_popup711']");
    private final static By SUBMIT_BUTTON = By.xpath("//*[@id='popup711_login_popup_form_container']/form/div[4]/div[1]/button");
  //  private final static By SEARCH_FIELD = By.xpath("//*[@id='search_input']");

    // Constructor pentru a initializa BrowserManager
    public LoginFox(BrowserManager browserManager) {
        this.manager = browserManager;
        this.actions = new SeleniumActions(manager);
    }

    // Metoda care dă click pe iconița de login
    public boolean validateLOGIN_ICON() {
        actions.clickElement(LOGIN_BUTTON);
        actions.clickElement(LOGIN_ICON);
        return true;
    }

    // Metoda care face login-ul pe site cu datele primite ca parametri
    public void FoxLoginPage(String username, String password) {
        log.info("Login to Fox with username: " + username);
        actions.sendKeys(USERNAME_FIELD, username);
        actions.sendKeys(PASSWORD_FIELD, password);
        actions.clickElement(SUBMIT_BUTTON);
    }

    // Metoda care deschide pagina de login Fox și acceptă cookies
    public void openFoxLoginPage() {
        log.info("Opening Fox login page...");
        manager.getDriver().get("https://www.foxfishing.ro/");
        manager.getDriver().manage().window().maximize();

    }

    // Metoda care verifică dacă login-ul a fost realizat cu succes
    public boolean isLoginSuccessful() {
        return manager.getDriver().getCurrentUrl().contains("https://www.foxfishing.ro/");
    }

    // Metoda  dă click pe butonul "Accept All"

    public boolean validateACCEPT_ALL_BUTTON() {
        log.info("Clicking on 'Accept All' button...");
        actions.clickElement(ACCEPT_ALL_BUTTON);
        return true;
    }

    // Metoda care validează și dă click pe butonul "Asta e ok"
    public boolean validateASTA_E_OK_BUTTON() {
        log.info("Clicking on 'Asta e ok' button...");
        actions.clickElement(ASTA_E_OK_BUTTON);
        return true;
    }

    // Metodă utilitară pentru a verifica dacă un element este vizibil pe pagină
    private boolean waitElementToBeClickable(By locator) {
        try {
            WebElement element = manager.getDriver().findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            log.error("Elementul nu este vizibil: " + locator, e);
            return true;
        }
    }
}
