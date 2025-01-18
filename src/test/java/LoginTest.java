import org.automation.framework.BrowserManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest {
    BrowserManager manager = new BrowserManager();

    @Test
    public void loginIphone() throws InterruptedException {
        manager.openBrowser();

        String icon = "//*[@id=\"sw_dropdown_711\"]/a/i";
        //   String klaro = "//*[@id='klaro']/div/div/div/div/div/button";
        //   String accountInfo = "//*[@id='sw_dropdown_711']/a/i";
        WebDriver driver = manager.getDriver();

        driver.get("https://www.foxfishing.ro");
        driver.findElement(By.xpath("//*[@id=\"tygh_container\"]/div[5]/div[2]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath(icon)).click();
        Thread.sleep(10000);
        //  driver.quit();


        //  driver.findElement(By.xpath("//*[@id="account_info_711"]/div[2]/a[1]")).click();
        // driver.findElement(By.xpath(icon)).click();
        //  Thread.sleep(10000);

         //  driver.findElement(By.xpath("/html/body/div[4]/div[1]/button")).click();
         //  driver.findElement(By.xpath(icon)).click();
         //  Thread.sleep(10000);

        // nu am variabila "klaro"
        // nu am variabila "account_info_711"


        //  driver.findElement(By.xpath("//*[@id='account_info_711']/div[2]/a[1]")).click();
        //  driver.findElement(By.xpath(icon)).click();
        //  Thread.sleep(10000);


        //   WebElement element = driver.findElement(By.xpath("//*[@id='account_info_711']/div[2]/a[1]"));
        //  if (element.isDisplayed() && element.isEnabled()) {
        //      element.click();
        //  } else {
        //      System.out.println("Elementul nu este vizibil in pagina");
        //  }


    }
}
// /html/body/div[4]/div[1]/button
// //*[@id="account_info_711"]/div[2]/a[1]