package su.ivt.test.selenium.lan.test.testng;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HeliosSelectMenuTest {
    private static WebDriver driver;

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

        driver.get("http://test.helios2.ivt.lan/login.html");

        WebElement loginField = driver.findElement(usernameLocator);
        loginField.sendKeys("lysykh87");
        WebElement passwordField = driver.findElement(passwordLocator);
        passwordField.sendKeys("lysykh87");
        WebElement loginButton = driver.findElement(buttonLocator);
        loginButton.click();
        WebElement profileUser = driver.findElement(profileLocator);
        String gUser = profileUser.getText();

        Assert.assertEquals("Vladimir Lysykh", gUser);
    }

    @Test
    public void selectMonitoring() throws InterruptedException {
        By selectLocator = By.name("watch");
        By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBL3C-su-ivt-helios-web-ui-layout-TwoColumnContentResources-Style-colOne > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        WebElement monitoringButton = driver.findElement(selectLocator);
        monitoringButton.click();
        checkPanelName("НАБЛЮДЕНИЕ", panelLocator);
    }

    @Test
    public void selectSchedule() throws InterruptedException {
       By selectLocator = By.name("schedule");
       By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBL3C-su-ivt-helios-web-ui-layout-TwoColumnContentResources-Style-colOne > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
       WebElement scheduleButton = driver.findElement(selectLocator);
       scheduleButton.click();
       checkPanelName("РАСПИСАНИЕ", panelLocator);
    }


   @Test
    public void selectObjects() throws InterruptedException {
       By selectLocator = By.name("admin");
       By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBGCE-su-ivt-helios-web-ui-layout-ThreeColumnContentView_ThreeColumnContentViewUiBinderImpl_GenCss_style-left > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
       WebElement objectButton = driver.findElement(selectLocator);
       objectButton.click();
       checkPanelName("ОБЪЕКТЫ", panelLocator);
    }

    @Test
    public void selectReports() throws InterruptedException {
        By selectLocator = By.name("reports");
        By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBL3C-su-ivt-helios-web-ui-layout-TwoColumnContentResources-Style-colOne > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        WebElement reportButton = driver.findElement(selectLocator);
        reportButton.click();
        checkPanelName("ОТЧЕТЫ", panelLocator);
    }

    @Test
    public void selectTasks() throws InterruptedException {
        By selectLocator = By.name("workJournal");
        By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBL3C-su-ivt-helios-web-ui-layout-TwoColumnContentResources-Style-colOne > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        WebElement taskButton = driver.findElement(selectLocator);
        taskButton.click();
        checkPanelName("ЗАДАЧИ", panelLocator);
    }

    @Test
    public void selectEvents() throws InterruptedException {
        By selectLocator = By.name("monitoring");
        By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBL3C-su-ivt-helios-web-ui-layout-TwoColumnContentResources-Style-colOne > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        WebElement eventButton = driver.findElement(selectLocator);
        eventButton.click();
        checkPanelName("СОБЫТИЯ", panelLocator);
    }

    @Test
    public void selectMap() throws InterruptedException {
        By selectLocator = By.name("map");
        By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBL3C-su-ivt-helios-web-ui-layout-TwoColumnContentResources-Style-colOne > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        WebElement mapButton = driver.findElement(selectLocator);
        mapButton.click();
        checkPanelName("КАРТА", panelLocator);
    }

    @Test
    public void selectInventory() throws InterruptedException {
        By selectLocator = By.name("inventory");
        By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBL3C-su-ivt-helios-web-ui-layout-TwoColumnContentResources-Style-colOne > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        WebElement inventoryButton = driver.findElement(selectLocator);
        inventoryButton.click();
        checkPanelName("ИНВЕНТАРИЗАЦИЯ", panelLocator);
    }

    @Test
    public void selectUsers() throws InterruptedException {
        By selectLocator = By.name("users");
        By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBL3C-su-ivt-helios-web-ui-layout-TwoColumnContentResources-Style-colOne > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        WebElement usersButton = driver.findElement(selectLocator);
        usersButton.click();
        checkPanelName("ПОЛЬЗОВАТЕЛИ И РОЛИ", panelLocator);
    }

    @Test
    public void selectUserLogs() throws InterruptedException {
        By selectLocator = By.name("userLogs");
        By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBL3C-su-ivt-helios-web-ui-layout-TwoColumnContentResources-Style-colOne > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        WebElement userLogsButton = driver.findElement(selectLocator);
        userLogsButton.click();
        checkPanelName("ДЕЙСТВИЯ ПОЛЬЗОВАТЕЛЕЙ", panelLocator);
    }

    @Test
    public void selectService() throws InterruptedException {
        By selectLocator = By.name("service");
        By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBL3C-su-ivt-helios-web-ui-layout-TwoColumnContentResources-Style-colOne > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        WebElement serviceButton = driver.findElement(selectLocator);
        serviceButton.click();
        checkPanelName("ОБСЛУЖИВАНИЕ", panelLocator);
    }

    @Test
    public void selectSettings() throws InterruptedException {
        By selectLocator = By.name("settings");
        By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBL3C-su-ivt-helios-web-ui-layout-TwoColumnContentResources-Style-colOne > div > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        WebElement settingsButton = driver.findElement(selectLocator);
        settingsButton.click();
        checkPanelName("НАСТРОЙКИ СИСТЕМЫ", panelLocator);
    }

    @Test
    public void selectLightBoxLogs() throws InterruptedException {
        By selectLocator = By.name("lightBoxLogs");
        By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBL3C-su-ivt-helios-web-ui-layout-TwoColumnContentResources-Style-colOne > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        WebElement lightBoxLogsButton = driver.findElement(selectLocator);
        lightBoxLogsButton.click();
        checkPanelName("ЛОГИ УСТРОЙСТВ", panelLocator);
    }

    @Test
    public void selectLightSensors() throws InterruptedException {
        By selectLocator = By.name("lightSensors");
        By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBL3C-su-ivt-helios-web-ui-layout-TwoColumnContentResources-Style-colOne > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        WebElement lightSensorsButton = driver.findElement(selectLocator);
        lightSensorsButton.click();
        checkPanelName("ДАТЧИКИ ОСВЕЩЕННОСТИ", panelLocator);
    }

    private void checkPanelName(String condition, By panelLocator) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElementLocated(panelLocator,condition));

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals(condition, panelNameText);
    }

    @AfterClass
    public static void tearDown() {
        WebElement logoutButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[3]/div/div[5]/a"));
        logoutButton.click();
        driver.quit();
    }

}


