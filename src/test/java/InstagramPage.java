import org.automation.framework.BrowserManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InstagramPage {
    BrowserManager manager = new BrowserManager();

    @Test
    public void InstagramPage() throws InterruptedException {
        manager.openBrowser();

        WebDriver driver = manager.getDriver();
        driver.get("https://www.foxfishing.ro");


        String icon = "//*[@id=\"index_index\"]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/a[2]/i";
        driver.findElement(By.xpath(icon)).click();

        Thread.sleep(10000);


    }
}
