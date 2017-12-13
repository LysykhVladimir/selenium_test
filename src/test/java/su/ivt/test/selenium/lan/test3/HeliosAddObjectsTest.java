package su.ivt.test.selenium.lan.test3;

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

    @BeforeClass
    public static void setup() throws InterruptedException {
        By usernameLocator = By.id("user");
        By passwordLocator = By.id("pass");
        By buttonLocator = By.xpath("/html/body/form/div/a/img");
        By profileLocator = By.xpath("/html/body/div[4]/div[1]/div/div[3]/div/div[5]/span");
        By selectMenuLocator = By.name("admin");
        By panelLocator = By.className("GD5V5V5DM3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-label");
        By treeLocator = By.className("GD5V5V5DETD-su-ivt-helios-web-ui-widgets-tree-customTree-BaseTreeResources-Style-arrow");

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

    @Before
    public void selectTreeNode() throws InterruptedException {

        By selectTreeNodeLocator = By.xpath("//*[@id=\"1352\"]/div[1]/div/div[4]/div");
        By nameNodeLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GD5V5V5DM3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GD5V5V5DF3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GD5V5V5DP2C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GD5V5V5DP3D-su-ivt-helios-web-ui-layout-ThreeColumnContentView_ThreeColumnContentViewUiBinderImpl_GenCss_style-center > div > div.GD5V5V5DI3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-content > div > div > div:nth-child(2) > div > div > div > div > form > div > ul > li:nth-child(1) > div:nth-child(2)");

        WebElement treeNode = driver.findElement(selectTreeNodeLocator);
        treeNode.click();
        Thread.sleep(1000);

        WebElement nodeName = driver.findElement(nameNodeLocator);
        String nodeNameText = nodeName.getText();
        Assert.assertEquals("Testing", nodeNameText);
    }

    @Test
    public void addGroup() throws InterruptedException {
        By addButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div/div");
        //By addButtonLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GD5V5V5DM3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GD5V5V5DF3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GD5V5V5DP2C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GD5V5V5DP3D-su-ivt-helios-web-ui-layout-ThreeColumnContentView_ThreeColumnContentViewUiBinderImpl_GenCss_style-center > div > div.GD5V5V5DI3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-content > div > div > div:nth-child(1) > div > div > div.GD5V5V5DP1D-su-ivt-helios-web-pages-admin-infoPanel-FormPanelView_FormPanelViewUiBinderImpl_GenCss_style-headerContainer > div:nth-child(4) > div > div");
        By radioButtonLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GD5V5V5DM3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GD5V5V5DF3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GD5V5V5DP2C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GD5V5V5DP3D-su-ivt-helios-web-ui-layout-ThreeColumnContentView_ThreeColumnContentViewUiBinderImpl_GenCss_style-center > div > div.GD5V5V5DI3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-content > div > div > div:nth-child(1) > div > div > div.GD5V5V5DF2D-su-ivt-helios-web-pages-admin-infoPanel-FormPanelView_FormPanelViewUiBinderImpl_GenCss_style-optionsContainer > div:nth-child(1) > span > label");
        By nameGroupLocator = By.id("x-auto-3-input");
        By descriptionGroupLocator = By.id("x-auto-4-input");
        By saveButtonLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GD5V5V5DM3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GD5V5V5DF3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GD5V5V5DP2C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GD5V5V5DP3D-su-ivt-helios-web-ui-layout-ThreeColumnContentView_ThreeColumnContentViewUiBinderImpl_GenCss_style-center > div > div.GD5V5V5DI3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-content > div > div > div:nth-child(2) > div > div > div > div > div > div > div.GD5V5V5DJSD-su-ivt-helios-web-ui-widgets-threeRowScrollPanel-ThreeRowPanelResources-Style-footer > div > div:nth-child(1) > div > div");
        By nameVerificationLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GD5V5V5DM3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GD5V5V5DF3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GD5V5V5DP2C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GD5V5V5DP3D-su-ivt-helios-web-ui-layout-ThreeColumnContentView_ThreeColumnContentViewUiBinderImpl_GenCss_style-center > div > div.GD5V5V5DI3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-content > div > div > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > ul > li:nth-child(1) > div:nth-child(2)");

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
        Thread.sleep(1000);

        WebElement nameVerification = driver.findElement(nameVerificationLocator);
        String nameVerificationText = nameVerification.getText();
        Assert.assertEquals("Новая группа", nameVerificationText);

    }

    @Test
    public void addGeoObject() throws InterruptedException {
        By addButtonLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GD5V5V5DM3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GD5V5V5DF3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GD5V5V5DP2C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GD5V5V5DP3D-su-ivt-helios-web-ui-layout-ThreeColumnContentView_ThreeColumnContentViewUiBinderImpl_GenCss_style-center > div > div.GD5V5V5DI3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-content > div > div > div:nth-child(1) > div > div > div.GD5V5V5DP1D-su-ivt-helios-web-pages-admin-infoPanel-FormPanelView_FormPanelViewUiBinderImpl_GenCss_style-headerContainer > div:nth-child(4) > div > div");
        By radioButtonLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GD5V5V5DM3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GD5V5V5DF3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GD5V5V5DP2C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GD5V5V5DP3D-su-ivt-helios-web-ui-layout-ThreeColumnContentView_ThreeColumnContentViewUiBinderImpl_GenCss_style-center > div > div.GD5V5V5DI3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-content > div > div > div:nth-child(1) > div > div > div.GD5V5V5DF2D-su-ivt-helios-web-pages-admin-infoPanel-FormPanelView_FormPanelViewUiBinderImpl_GenCss_style-optionsContainer > div:nth-child(2) > span > label");
        By nameGeoLocator = By.id("x-auto-5-input");
        By typeGeoLocator = By.id("x-auto-6-input");
        By latitudeGeoLocator = By.id("x-auto-7-input");
        By longitudeGeoLocator = By.id("x-auto-8-input");
        By timeZoneGeoLocator = By.id("x-auto-9-input");
        By saveButtonLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GD5V5V5DM3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GD5V5V5DF3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GD5V5V5DP2C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GD5V5V5DP3D-su-ivt-helios-web-ui-layout-ThreeColumnContentView_ThreeColumnContentViewUiBinderImpl_GenCss_style-center > div > div.GD5V5V5DI3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-content > div > div > div:nth-child(2) > div > div > div > div > div > div > div.GD5V5V5DJSD-su-ivt-helios-web-ui-widgets-threeRowScrollPanel-ThreeRowPanelResources-Style-footer > div > div:nth-child(1) > div > div");
        By nameVerificationLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GD5V5V5DM3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GD5V5V5DF3D-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GD5V5V5DP2C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GD5V5V5DP3D-su-ivt-helios-web-ui-layout-ThreeColumnContentView_ThreeColumnContentViewUiBinderImpl_GenCss_style-center > div > div.GD5V5V5DI3C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-content > div > div > div:nth-child(2) > div > div > div > div > form > div > ul > li:nth-child(1) > div:nth-child(2)");


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
        Thread.sleep(1000);

        WebElement nameVerification = driver.findElement(nameVerificationLocator);
        String nameVerificationText = nameVerification.getText();
        Assert.assertEquals("Новый район", nameVerificationText);
    }
/*
    @Test
    public void addHeliosObject() {
        By addButtonLocator = By.cssSelector("div.GEM1H5MDEPD-su-ivt-helios-web-ui-widgets-heliosButton-HeliosButtonResources-HeliosButtonResourcesStyle-button:nth-child(4) > div:nth-child(2) > div:nth-child(2)");
        By radioButtonLocator = By.cssSelector(".GEM1H5MDP5D-su-ivt-helios-web-pages-admin-infoPanel-FormPanelView_FormPanelViewUiBinderImpl_GenCss_style-optionsContainer > div:nth-child(3) > span:nth-child(1) > label:nth-child(2)");

        WebElement addButton = driver.findElement(addButtonLocator);
        addButton.click();
        WebElement radioButton = driver.findElement(radioButtonLocator);
        radioButton.click();
    }
*/

   /* @AfterClass
    public static void tearDown() {
        WebElement logoutButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[3]/div/div[5]/a"));
        logoutButton.click();
        driver.quit();
    }*/
}
