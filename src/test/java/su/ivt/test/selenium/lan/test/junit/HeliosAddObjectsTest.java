package su.ivt.test.selenium.lan.test.junit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HeliosAddObjectsTest {
    private static WebDriver driver;
    @Ignore
    @BeforeClass
    public static void setup() throws InterruptedException {
        By usernameLocator = By.id("user");
        By passwordLocator = By.id("pass");
        By buttonLocator = By.xpath("/html/body/form/div/a/img");
        By profileLocator = By.xpath("/html/body/div[4]/div[1]/div/div[3]/div/div[5]/span");
        By selectMenuLocator = By.name("admin");
        By panelLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBGCE-su-ivt-helios-web-ui-layout-ThreeColumnContentView_ThreeColumnContentViewUiBinderImpl_GenCss_style-left > div > div.GGTUI1GBD4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-header > div.GGTUI1GBF4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        By treeLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div[1]/div/div[1]");

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

        WebElement objectButton = driver.findElement(selectMenuLocator);
        objectButton.click();
        Thread.sleep(1000);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("ОБЪЕКТЫ", panelNameText);

        WebElement treeButton = driver.findElement(treeLocator);
        treeButton.click();
        Thread.sleep(1000);
    }
    @Ignore
    @Before
    public void selectTreeNode() throws InterruptedException {

        By selectTreeNodeLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div[2]/div[8]/div[1]/div/div[4]/div");
        By nameNodeLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/form/div/ul/li[1]/div[2]");

        WebElement treeNode = driver.findElement(selectTreeNodeLocator);
        treeNode.click();
        Thread.sleep(1000);

        WebElement nodeName = driver.findElement(nameNodeLocator);
        String nodeNameText = nodeName.getText();
        Assert.assertEquals("Testing", nodeNameText);
        Thread.sleep(1000);
    }
    @Ignore
    @Test
    public void addGroup() throws InterruptedException {

        By addButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div/div");
        By radioButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div/div[2]/div[1]/span/label");
        By nameGroupLocator = By.id("x-auto-3-input");
        By descriptionGroupLocator = By.id("x-auto-4-input");
        By saveButtonLocator = By.cssSelector(".GGTUI1GBMHE-su-ivt-helios-web-ui-form-UIBinderFormBaseView_EditorFormUiBinderImpl_GenCss_style-buttonsContainer > div:nth-child(1) > div:nth-child(2) > div:nth-child(2)");
        By nameVerificationLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBFCE-su-ivt-helios-web-ui-layout-ThreeColumnContentView_ThreeColumnContentViewUiBinderImpl_GenCss_style-center > div > div.GGTUI1GBB4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-content > div > div > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > ul > li:nth-child(1) > div:nth-child(2)");

        WebElement addButton = driver.findElement(addButtonLocator);
        addButton.click();
        WebElement radioButton = driver.findElement(radioButtonLocator);
        radioButton.click();
        Thread.sleep(1000);

        WebElement nameGroupField = driver.findElement(nameGroupLocator);
        nameGroupField.sendKeys("Новая группа");
        WebElement DescriptionGroupField = driver.findElement(descriptionGroupLocator);
        DescriptionGroupField.sendKeys("Описание новой группы");

        WebElement saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();
        Thread.sleep(3000);

        WebElement nameVerification = driver.findElement(nameVerificationLocator);
        String nameVerificationText = nameVerification.getText();
        Assert.assertEquals("Новая группа", nameVerificationText);
    }
    @Ignore
    @Test
    public void addGeoObject() throws InterruptedException {
        By addButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div/div");
        By radioButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div/div[2]/div[2]/span/label");
        By nameGeoLocator = By.id("x-auto-5-input");
        By typeGeoLocator = By.id("x-auto-6-input");
        By latitudeGeoLocator = By.id("x-auto-7-input");
        By longitudeGeoLocator = By.id("x-auto-8-input");
        By timeZoneGeoLocator = By.id("x-auto-9-input");
        By saveButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[1]/div/div");
        By nameVerificationLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/form/div/ul/li[1]/div[2]");

        WebElement addButton = driver.findElement(addButtonLocator);
        addButton.click();
        WebElement radioButton = driver.findElement(radioButtonLocator);
        radioButton.click();

        WebElement nameGeoField = driver.findElement(nameGeoLocator);
        nameGeoField.sendKeys("Новый район");

        WebElement typeGeoField = driver.findElement(typeGeoLocator);
        Actions builder = new Actions(driver);
        builder.click(typeGeoField).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        WebElement latitudeGeoField = driver.findElement(latitudeGeoLocator);
        latitudeGeoField.sendKeys("33,11");
        WebElement longitudeGeoField = driver.findElement(longitudeGeoLocator);
        longitudeGeoField.sendKeys("66,22");
        WebElement timeZoneField = driver.findElement(timeZoneGeoLocator);
        builder.click(timeZoneField).sendKeys(Keys.ENTER).build().perform();

        WebElement saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();
        Thread.sleep(3000);

        WebElement nameVerification = driver.findElement(nameVerificationLocator);
        String nameVerificationText = nameVerification.getText();
        Assert.assertEquals("Новый район", nameVerificationText);
    }
    @Ignore
    @Test
    public void addHeliosObject() throws InterruptedException {
        By addButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div/div");
        By radioButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div/div[2]/div[3]/span/label");
        By saveButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[1]/div/div");
        By nameVerificationLocator = By.xpath("//*[@id=\"ext-gen6\"]/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/form/div/ul/li[1]/div[2]");
        By nameHeliosLocator = By.id("x-auto-18-input");
        By versionCCLocator = By.id("x-auto-17-input");
        By typeCCLocator = By.id("x-auto-16-input");
        By nominalLocator = By.id("x-auto-19-input");
        By kttLocator = By.id("x-auto-22-input");
        By fnLocator = By.id("x-auto-25-input");
        By snLocator = By.id("x-auto-26-input");
        By phoneLocator = By.id("x-auto-34-input");
        By gsmLocator = By.id("x-auto-35-input");
        By shipmentDateLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/form/div/div[5]/div[2]/div/ul/li[1]/div[2]/input");
        By guaranteeLocator = By.id("x-auto-71-input");
        By batteryReplacementDateLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/form/div/div[5]/div[2]/div/ul/li[3]/div[2]/input");
        By commissioningDateLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/form/div/div[5]/div[2]/div/ul/li[4]/div[2]/input");
        By guaranteePeriodCULocator = By.id("x-auto-73-input");

        WebElement addButton = driver.findElement(addButtonLocator);
        addButton.click();
        WebElement radioButton = driver.findElement(radioButtonLocator);
        radioButton.click();

        WebElement nameHeliosField = driver.findElement(nameHeliosLocator);
        nameHeliosField.sendKeys("Новый объект Гелиос 2");

        WebElement versionCCField = driver.findElement(versionCCLocator);
        Actions builder = new Actions(driver);
        builder.click(versionCCField).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        WebElement typeCCField = driver.findElement(typeCCLocator);
        builder = new Actions(driver);
        builder.click(typeCCField).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        WebElement nominalField = driver.findElement(nominalLocator);
        nominalField.sendKeys("100");

        WebElement kttField = driver.findElement(kttLocator);
        kttField.sendKeys("1");

        WebElement fnField = driver.findElement(fnLocator);
        fnField.sendKeys("SWN2NV93LDN13485");

        WebElement snField = driver.findElement(snLocator);
        snField.sendKeys("5274240944323451");

        WebElement phoneField = driver.findElement(phoneLocator);
        phoneField.sendKeys("+79041234455");

        WebElement gsmField = driver.findElement(gsmLocator);
        builder = new Actions(driver);
        builder.click(gsmField).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        WebElement shipmentDateField = driver.findElement(shipmentDateLocator);
        builder = new Actions(driver);
        builder.click(shipmentDateField).sendKeys("11.12.2017").sendKeys(Keys.ENTER).build().perform();

        WebElement guaranteeField = driver.findElement(guaranteeLocator);
        guaranteeField.sendKeys("6");

        WebElement batteryReplacementDateField = driver.findElement(batteryReplacementDateLocator);
        builder = new Actions(driver);
        builder.click(batteryReplacementDateField).sendKeys("11.12.2018").sendKeys(Keys.ENTER).build().perform();

        WebElement commissioningDateField = driver.findElement(commissioningDateLocator);
        builder = new Actions(driver);
        builder.click(commissioningDateField).sendKeys(Keys.ENTER).build().perform();

        WebElement guaranteePeriodCUField = driver.findElement(guaranteePeriodCULocator);
        guaranteePeriodCUField.sendKeys("6");

        WebElement saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();
        Thread.sleep(15000);

        WebElement nameVerification = driver.findElement(nameVerificationLocator);
        String nameVerificationText = nameVerification.getText();
        Assert.assertEquals("Новый объект Гелиос 2", nameVerificationText);
    }
    @Ignore
    @AfterClass
    public static void tearDown() throws InterruptedException {
        WebElement logoutButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[3]/div/div[5]/a"));
        logoutButton.click();
        driver.quit();
    }
}
