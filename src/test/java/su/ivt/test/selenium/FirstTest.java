package su.ivt.test.selenium;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class FirstTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Install/ChromeDriver/chromedriver.exe");
        //driver=new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ukr.net/desktop/login");
    }

    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.id("id-1"));
        loginField.sendKeys("autotestorgua");
        WebElement passwordField = driver.findElement(By.id("id-2"));
        passwordField.sendKeys("testpass");
        WebElement loginButton = driver.findElement(By.className("button__content"));
      //WebElement loginButton = driver.findElement(By.xpath("//button[text()='Увійти']"));
        loginButton.click();
        WebElement profileUser = driver.findElement(By.cssSelector(".login-button__user"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("autotestorgua@ukr.net", mailUser);
    }

    @AfterClass
    public static void tearDown() {
        WebElement menuUser = driver.findElement(By.cssSelector(".login-button__menu-icon"));
        menuUser.click();
        WebElement logoutButton = driver.findElement(By.id("login__logout"));
        logoutButton.click();
        driver.quit();
    }

}