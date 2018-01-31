package su.ivt.test.selenium.lan.test.junit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HeliosSelectMenuTest {
    private static WebDriver driver;
    @Ignore
    @BeforeClass
    public static void setup() {
        By usernameLocator = By.id("user");
        By passwordLocator = By.id("pass");
        By buttonLocator = By.xpath("/html/body/form/div/a/img");
        By profileLocator = By.xpath("/html/body/div[4]/div[1]/div/div[3]/div/div[5]/span");

        System.setProperty("webdriver.chrome.driver", "/Install/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://test3.helios2.ivt.lan/login.html");

        WebElement loginField = driver.findElement(usernameLocator);
        loginField.sendKeys("lysykh87");
        WebElement passwordField = driver.findElement(passwordLocator);
        passwordField.sendKeys("lysykh87");
        WebElement loginButton = driver.findElement(buttonLocator);
        loginButton.click();
        WebElement profileUser = driver.findElement(profileLocator);
        String gUser = profileUser.getText();

        Assert.assertEquals("Владимир Лысых", gUser);
    }
    @Ignore
    @Test
    public void selectMonitoring() throws InterruptedException {
        By selectLocator = By.name("watch");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

        WebElement monitoringButton = driver.findElement(selectLocator);
        monitoringButton.click();
        Thread.sleep(1000);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("НАБЛЮДЕНИЕ", panelNameText);
    }

    @Test
    public void selectSchedule() throws InterruptedException {
        By selectLocator = By.name("schedule");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

       WebElement scheduleButton = driver.findElement(selectLocator);
       scheduleButton.click();
       Thread.sleep(1000);

       WebElement panelName = driver.findElement(panelLocator);
       String panelNameText = panelName.getText();
       Assert.assertEquals("РАСПИСАНИЕ", panelNameText);
    }
    @Ignore
   @Test
    public void selectObjects() throws InterruptedException {
       By selectLocator = By.name("admin");
       By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

       WebElement reportButton = driver.findElement(selectLocator);
       reportButton.click();
       Thread.sleep(2000);

       WebElement panelName = driver.findElement(panelLocator);
       String panelNameText = panelName.getText();
       Assert.assertEquals("ОБЪЕКТЫ", panelNameText);
    }
    @Ignore
    @Test
    public void selectReports() throws InterruptedException {
        By selectLocator = By.name("reports");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

        WebElement reportButton = driver.findElement(selectLocator);
        reportButton.click();
        Thread.sleep(1000);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("ОТЧЕТЫ", panelNameText);
    }
    @Ignore
    @Test
    public void selectTasks() throws InterruptedException {
        By selectLocator = By.name("workJournal");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

        WebElement taskButton = driver.findElement(selectLocator);
        taskButton.click();
        Thread.sleep(1000);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("ЗАДАЧИ", panelNameText);
    }
    @Ignore
    @Test
    public void selectEvents() throws InterruptedException {
        By selectLocator = By.name("monitoring");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

        WebElement eventButton = driver.findElement(selectLocator);
        eventButton.click();
        Thread.sleep(1000);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("СОБЫТИЯ", panelNameText);
    }
    @Ignore
    @Test
    public void selectMap() throws InterruptedException {
        By selectLocator = By.name("map");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

        WebElement mapButton = driver.findElement(selectLocator);
        mapButton.click();
        Thread.sleep(1000);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("КАРТА", panelNameText);
    }
    @Ignore
    @Test
    public void selectInventory() throws InterruptedException {
        By selectLocator = By.name("inventory");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

        WebElement inventoryButton = driver.findElement(selectLocator);
        inventoryButton.click();
        Thread.sleep(1000);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("ИНВЕНТАРИЗАЦИЯ", panelNameText);
    }
    @Ignore
    @Test
    public void selectUsers() throws InterruptedException {
        By selectLocator = By.name("users");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

        WebElement usersButton = driver.findElement(selectLocator);
        usersButton.click();
        Thread.sleep(1000);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("ПОЛЬЗОВАТЕЛИ И РОЛИ", panelNameText);
    }
    @Ignore
    @Test
    public void selectUserLogs() throws InterruptedException {
        By selectLocator = By.name("userLogs");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

        WebElement userLogsButton = driver.findElement(selectLocator);
        userLogsButton.click();
        Thread.sleep(1000);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("ДЕЙСТВИЯ ПОЛЬЗОВАТЕЛЕЙ", panelNameText);
    }
    @Ignore
    @Test
    public void selectService() throws InterruptedException {
        By selectLocator = By.name("service");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

        WebElement serviceButton = driver.findElement(selectLocator);
        serviceButton.click();
        Thread.sleep(1000);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("ОБСЛУЖИВАНИЕ", panelNameText);
    }
    @Ignore
    @Test
    public void selectSettings() throws InterruptedException {
        By selectLocator = By.name("settings");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

        WebElement settingsButton = driver.findElement(selectLocator);
        settingsButton.click();
        Thread.sleep(1000);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("НАСТРОЙКИ СИСТЕМЫ", panelNameText);
    }
    @Ignore
    @Test
    public void selectLightBoxLogs() throws InterruptedException {
        By selectLocator = By.name("lightBoxLogs");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

        WebElement lightBoxLogsButton = driver.findElement(selectLocator);
        lightBoxLogsButton.click();
        Thread.sleep(1000);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("ЛОГИ УСТРОЙСТВ", panelNameText);
    }
    @Ignore
    @Test
    public void selectLightSensors() throws InterruptedException {
        By selectLocator = By.name("lightSensors");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");

        WebElement lightSensorsButton = driver.findElement(selectLocator);
        lightSensorsButton.click();
        Thread.sleep(1000);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("ДАТЧИКИ ОСВЕЩЕННОСТИ", panelNameText);
    }

    @Ignore
    @AfterClass
    public static void tearDown() {
        WebElement logoutButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[3]/div/div[5]/a"));
        logoutButton.click();
        driver.quit();
    }
}


