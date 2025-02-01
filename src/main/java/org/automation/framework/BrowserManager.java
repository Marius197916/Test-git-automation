package org.automation.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManager {

    public static WebDriver driver;

    public void openBrowser() {
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        if (driver == null) {
            openBrowser();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.close();
    }
}