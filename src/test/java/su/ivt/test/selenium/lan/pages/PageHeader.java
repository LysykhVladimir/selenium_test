package su.ivt.test.selenium.lan.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import su.ivt.test.selenium.lan.config.DriverFactory;

public class PageHeader {

    @FindBy(name = "watch")
    private WebElement monitoringButton;
    @FindBy(name = "schedule")
    private WebElement scheduleButton;
    @FindBy(name = "admin")
    private WebElement objectButton;
    @FindBy(name = "reports")
    private WebElement reportButton;
    @FindBy(name = "workJournal")
    private WebElement taskButton;
    @FindBy(name = "monitoring")
    private WebElement eventButton;
    @FindBy(name = "map")
    private WebElement mapButton;
    @FindBy(name = "inventory")
    private WebElement inventoryButton;
    @FindBy(name = "users")
    private WebElement usersButton;
    @FindBy(name = "userLogs")
    private WebElement userLogsButton;
    @FindBy(name = "service")
    private WebElement serviceButton;
    @FindBy(name = "settings")
    private WebElement settingsButton;
    @FindBy(name = "lightBoxLogs")
    private WebElement lightBoxLogsButton;
    @FindBy(name = "lightSensors")
    private WebElement lightSensorsButton;
    @FindBy(css = "div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label")
    private WebElement nameOfMenuSection;


    public PageHeader () throws Exception {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public WebElement getNameOfMenuSection() {
        return nameOfMenuSection;
    }
    public void goToMonitoringPage(){
        monitoringButton.click();
    }
    public void goToSchedulePage(){
        scheduleButton.click();
    }
    public void goToObjectsPage(){
        objectButton.click();
    }
    public void goToReportPage(){
        reportButton.click();
    }
    public void goToTaskPage(){
        taskButton.click();
    }
    public void goToEventPage(){
        eventButton.click();
    }
    public void goToMapPage(){
        mapButton.click();
    }
    public void goToInventoryPage(){
        inventoryButton.click();
    }
    public void goToUsersPage(){
        usersButton.click();
    }
    public void goToUserLogsPage(){
        userLogsButton.click();
    }
    public void goToServicePage(){
        serviceButton.click();
    }
    public void goToSettingsPage(){
        settingsButton.click();
    }
    public void goTolightBoxLogsPage(){
        lightBoxLogsButton.click();
    }
    public void goToLightSensorsPage(){
        lightSensorsButton.click();
    }

}

