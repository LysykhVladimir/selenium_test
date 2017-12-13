package su.ivt.test.selenium.lan.test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SelectMenuTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Install/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://test.helios2.ivt.lan/login.html");

        loginPage.enterUsername("lysykh87")
                .enterPassword("lysykh87")
                .login();
    }

    @Test
    public void selectReports(){
        PageHeader menu = new PageHeader(driver);
        menu.goToReportPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ОТЧЕТЫ");
    }

    @Test
    public void selectMonitoring(){
        PageHeader menu = new PageHeader(driver);
        menu.goToMonitoringPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"НАБЛЮДЕНИЕ");
    }

    @Test
    public void selectEvent(){
        PageHeader menu = new PageHeader(driver);
        menu.goToEventPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"СОБЫТИЯ");
    }

    @Test
    public void selectInventory(){
        PageHeader menu = new PageHeader(driver);
        menu.goToInventoryPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ИНВЕНТАРИЗАЦИЯ");
    }
    @Test
    public void selectLightBoxLogs(){
        PageHeader menu = new PageHeader(driver);
        menu.goTolightBoxLogsPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ЛОГИ УСТРОЙСТВ");
    }

    @Test
    public void selectLightSensor(){
        PageHeader menu = new PageHeader(driver);
        menu.goToLightSensorsPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ДАТЧИКИ ОСВЕЩЕННОСТИ");
    }

    @Test
    public void selectMap(){
        PageHeader menu = new PageHeader(driver);
        menu.goToMapPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"КАРТА");
    }

    @Test
    public void selectObjects(){
        PageHeader menu = new PageHeader(driver);
        menu.goToObjectsPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ОБЪЕКТЫ");
    }

    @Test
    public void selectSchedule(){
        PageHeader menu = new PageHeader(driver);
        menu.goToSchedulePage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"РАСПИСАНИЕ");
    }

    @Test
    public void selectService(){
        PageHeader menu = new PageHeader(driver);
        menu.goToServicePage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ОБСЛУЖИВАНИЕ");
    }

    @Test
    public void selectSettings(){
        PageHeader menu = new PageHeader(driver);
        menu.goToSettingsPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"НАСТРОЙКИ СИСТЕМЫ");
    }

    @Test
    public void selectTask(){
        PageHeader menu = new PageHeader(driver);
        menu.goToTaskPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ЗАДАЧИ");
    }

    @Test
    public void selectUserLogs(){
        PageHeader menu = new PageHeader(driver);
        menu.goToUserLogsPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ДЕЙСТВИЯ ПОЛЬЗОВАТЕЛЕЙ");
    }

    @Test
    public void selectUsers(){
        PageHeader menu = new PageHeader(driver);
        menu.goToUsersPage();
        waitTextForNewMenuSection(menu.getNameOfMenuSection(),"ПОЛЬЗОВАТЕЛИ И РОЛИ");
    }

    private void waitTextForNewMenuSection(WebElement element, String condition) {
        try {
            (new WebDriverWait(driver, 5))
                    .until(ExpectedConditions.textToBePresentInElement(element,condition));

        } catch (Exception e) {
            Assert.fail("Элемент с именем "+condition+" не найден");
        }
    }
}
