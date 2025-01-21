import org.automation.framework.BrowserManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


// update versiunea de chrom?
public class WishList {
    BrowserManager manager = new BrowserManager();

    @Test
    public void testWishList() throws InterruptedException {
        manager.openBrowser();
        WebDriver driver = manager.getDriver();
        driver.get("https://www.foxfishing.ro");

        String icon = "//*[@id=\"et-cw_507\"]/a[2]/i";
        driver.findElement(By.xpath(icon)).click();


      // Thread.sleep(10000);

        // Close the browser after the test
        driver.quit();
    }
}
