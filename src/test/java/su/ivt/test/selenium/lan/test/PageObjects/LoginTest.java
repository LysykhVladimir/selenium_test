package su.ivt.test.selenium.lan.test.PageObjects;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class LoginTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Install/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test(groups = "login test")
    public void logInToWebsite(){
        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://test.helios2.ivt.lan/login.html");

        loginPage.enterUsername("lysykh87")
                .enterPassword("lysykh87")
                .login();

        Assert.assertEquals("Vladimir Lysykh", loginPage.getProfileLocator().getText());
    }
}
