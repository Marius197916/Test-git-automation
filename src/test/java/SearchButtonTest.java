import org.automation.framework.BrowserManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchButtonTest {
    BrowserManager manager = new BrowserManager();

    @Test
    public void testSearchButton() throws InterruptedException {
        manager.openBrowser();
        WebDriver driver = manager.getDriver();
        driver.get("https://www.foxfishing.ro");

        // XPath for the button
        String buttonXPath = "//*[@id=\"products_search\"]/div[2]/div/div[4]/div/div/div/div[2]/div[2]/div/form/button";
        driver.findElement(By.xpath(buttonXPath)).click();

        // Wait for 10 seconds (you might want to use WebDriverWait instead of Thread.sleep)
        Thread.sleep(10000);

        // Close the browser after the test
        driver.quit();
    }
}
