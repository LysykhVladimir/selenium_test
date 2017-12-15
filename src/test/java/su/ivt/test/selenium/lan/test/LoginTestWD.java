package su.ivt.test.selenium.lan.test;

import org.junit.Assert;
import org.testng.annotations.Test;
import su.ivt.test.selenium.lan.config.DriverFactory;
import su.ivt.test.selenium.lan.pages.LoginPage;

public class LoginTestWD extends DriverFactory{

    private static final String URL = "http://test.helios2.ivt.lan/login.html";
    private static final String LOGIN = "lysykh87";
    private static final String PASSWORD = "lysykh87";
    private static final String USER_NAME = "Vladimir Lysykh";

    @Test(groups = "login test")
    public void logInToWebsite() throws Exception {
        LoginPage loginPage = new LoginPage();
        getDriver().get(URL);
        loginPage.enterUsername(LOGIN)
                .enterPassword(PASSWORD)
                .login();
        Assert.assertEquals(USER_NAME, loginPage.getProfileLocator().getText());
    }
}

