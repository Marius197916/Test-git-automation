import org.automation.framework.BrowserManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest {

    BrowserManager manager = new BrowserManager();

    @Test
    public void browserTest() throws InterruptedException {
        manager.openBrowser();
        WebDriver driver = manager.getDriver();
        driver.get("https://www.foxfishing.ro");
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("foxfishing"));

        Thread.sleep(10000);
        driver.quit();
    }
}
