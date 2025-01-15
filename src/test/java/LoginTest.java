import org.automation.framework.BrowserManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {
    BrowserManager manager = new BrowserManager();

    @Test
    public void loginIphone() throws InterruptedException {
        manager.openBrowser();

        String icon = "//*[@id=\"sw_dropdown_711\"]/a/i";
        WebDriver driver = manager.getDriver();

        driver.get("https://www.foxfishing.ro");
        driver.findElement(By.xpath("//*[@id=\"tygh_container\"]/div[5]/div[2]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath(icon)).click();
        Thread.sleep(10000);
    }
}
