import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.framework.BrowserManager;
import org.automation.pageobjects.LoginFox;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FoxLoginPageTest{

    LoginFox login = new LoginFox();
    Logger log = LogManager.getRootLogger();

    @BeforeEach
    public void setUp() {
        login.FoxLoginPage();

    }

    @Test
    public void loginTest(){
        login.loginFox();
    }

    @AfterEach
    public void tearDown() {
        BrowserManager.closeDriver();
    }
}
