package su.ivt.test.selenium.lan.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

public class WebDriverThread {

    private WebDriver webdriver;
    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");
    public WebDriver getDriver() throws Exception {
        if (null == webdriver) {
            System.out.println(" ");
            System.out.println("Current Operating System: " + operatingSystem);
            System.out.println("Current Architecture: " + systemArchitecture);
            System.out.println("Current Browser Selection: Сhrome");
            System.out.println(" ");
            System.setProperty("webdriver.chrome.driver", "/Install/ChromeDriver/chromedriver.exe");
            webdriver = new ChromeDriver(DesiredCapabilities.chrome());
            webdriver.manage().window().maximize();
            webdriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }
        return webdriver;
    }

    public void quitDriver() {
        if (null != webdriver) {
            webdriver.quit();
            webdriver = null;
        }
    }
}
