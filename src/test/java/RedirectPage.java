import org.automation.framework.BrowserManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedirectPage {

    BrowserManager manager = new BrowserManager();

    @Test
    public void FaceBookPage() throws InterruptedException {
        manager.openBrowser();

        WebDriver driver = manager.getDriver();
        driver.get("https://www.foxfishing.ro");

        //String facebook = "//*[@id="facebook"]/body/div[3]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div/span/span";
        String icon = "//*[@id=\"index_index\"]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/a[1]/i";
        driver.findElement(By.xpath(icon)).click();

       Thread.sleep(10000);

       //driver.findElement(By.xpath("//*[@id="facebook"]/body/div[3]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div/span/span")).click();
      //  driver.findElement(By.xpath(icon)).click();

        Thread.sleep(10000);




    }

    public static class InstagramPage {
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

    public static class YouTubePage {
        BrowserManager manager = new BrowserManager();

        @Test
        public void testYouTube() throws InterruptedException {
            manager.openBrowser();
            WebDriver driver = manager.getDriver();
            driver.get("https://www.foxfishing.ro");

            // Așteaptă până la 10 secunde pentru ca elementul să fie prezent
          //  WebDriverWait wait = new WebDriverWait(driver, 10);
           // WebElement acceptAllButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/form[2]/div/div/button/span")));
         //   acceptAllButton.click();

            // Face clic pe iconiță
            String iconXPath = "//*[@id=\"index_index\"]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/a[3]/i";
            driver.findElement(By.xpath(iconXPath)).click();

            // Așteaptă 10 secunde (ideal să folosești WebDriverWait)
            Thread.sleep(10000);

            // Verifică dacă elementul este vizibil și activ înainte de a face clic
            WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/form[2]/div/div"));
            if (checkElement.isDisplayed() && checkElement.isEnabled()) {
                checkElement.click();
            } else {
                System.out.println("Elementul nu este vizibil pe pagină");
            }

            // Închide browserul după test
            driver.quit();
        }
    }
}



