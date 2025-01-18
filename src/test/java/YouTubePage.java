import org.automation.framework.BrowserManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTubePage {
    BrowserManager manager = new BrowserManager();

    @Test
    public void YouTube() throws InterruptedException {
        manager.openBrowser();

        WebDriver driver = manager.getDriver();
        driver.get("https://www.foxfishing.ro");

        //  WebDriverWait wait = new WebDriverWait(driver, 10); // Așteaptă până la 10 secunde
        //   WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id="yDmH0d"]/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/form[2]/div/div/button/span")))element.click();


        String icon = "//*[@id=\"index_index\"]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/a[3]/i";
        driver.findElement(By.xpath(icon)).click();

        Thread.sleep(10000);


        //   driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/form[1]/div/div/button/span")).click();
        //  driver.findElement(By.xpath(icon)).click();
        //  Thread.sleep(10000);

        // nu gaseste elementul in pagina....in cazul de fata butonul de accept all
        // numerge nici cu reject all

        // WebElement element = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/form[2]/div/div/button/span"));
        //  if (element.isDisplayed() && element.isEnabled()) {
        //     element.click();
        //   } else {
        //     System.out.println("Elementul nu este vizibil pe pagina");
        //  }

    }
}

