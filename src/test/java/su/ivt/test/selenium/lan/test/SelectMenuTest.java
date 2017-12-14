package su.ivt.test.selenium.lan.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import su.ivt.test.selenium.lan.config.DriverFactory;
import su.ivt.test.selenium.lan.pages.LoginPage;
import su.ivt.test.selenium.lan.pages.PageHeader;

public class SelectMenuTest extends DriverFactory{

    public static final String URL = "http://test.helios2.ivt.lan/login.html";
    public static final String LOGIN = "lysykh87";
    public static final String PASSWORD = "lysykh87";

    @BeforeClass
    public void setUp() throws Exception {
        LoginPage loginPage = new LoginPage();
        getDriver().get(URL);
        loginPage.enterUsername(LOGIN)
                .enterPassword(PASSWORD)
                .login();
    }

    @Test
    public void selectReports() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goToReportPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ОТЧЕТЫ");
    }

    @Test
    public void selectMonitoring() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goToMonitoringPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"НАБЛЮДЕНИЕ");
    }

    @Test
    public void selectEvent() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goToEventPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"СОБЫТИЯ");
    }

    @Test
    public void selectInventory() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goToInventoryPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ИНВЕНТАРИЗАЦИЯ");
    }

    @Test
    public void selectLightBoxLogs() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goTolightBoxLogsPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ЛОГИ УСТРОЙСТВ");
    }

    @Test
    public void selectLightSensor() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goToLightSensorsPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ДАТЧИКИ ОСВЕЩЕННОСТИ");
    }

    @Test
    public void selectMap() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goToMapPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"КАРТА");
    }

    @Test
    public void selectObjects() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goToObjectsPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ОБЪЕКТЫ");
    }

    @Test
    public void selectSchedule() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goToSchedulePage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"РАСПИСАНИЕ");
    }

    @Test
    public void selectService() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goToServicePage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ОБСЛУЖИВАНИЕ");
    }

    @Test
    public void selectSettings() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goToSettingsPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"НАСТРОЙКИ СИСТЕМЫ");
    }

    @Test
    public void selectTask() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goToTaskPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ЗАДАЧИ");
    }

    @Test
    public void selectUserLogs() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goToUserLogsPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ДЕЙСТВИЯ ПОЛЬЗОВАТЕЛЕЙ");
    }

    @Test
    public void selectUsers() throws Exception {
        PageHeader menu = new PageHeader();
        menu.goToUsersPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ПОЛЬЗОВАТЕЛИ И РОЛИ");
    }

    private void waitTextForNewMenuSection(WebElement element, String condition) {
        try {
            (new WebDriverWait(getDriver(), 5))
                    .until(ExpectedConditions.textToBePresentInElement(element,condition));

        } catch (Exception e) {
            Assert.fail("Элемент с именем "+condition+" не найден");
        }
    }
}
