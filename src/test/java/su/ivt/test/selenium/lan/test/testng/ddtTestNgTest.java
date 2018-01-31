package su.ivt.test.selenium.lan.test.testng;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ddtTestNgTest {
    private static WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @DataProvider
    public  Object[][] groupData() {
        return new Object[][] {
                new Object[] {"Группа 1", "Описание группы 1"},
                new Object[] {"Группа 2", "Описание группы 2"},
                new Object[] {"Группа 3", "Описание группы 3"},
                new Object[] {"Группа 4", "Описание группы 4"},
                new Object[] {"Группа 5", "Описание группы 5"},
        };
    }

    @DataProvider
    public  Object[][] geoData() {
        return new Object[][] {
                new Object[] {"Губкинский", "44,11","34,31"},
                new Object[] {"Корочанский", "44,15","34,51"},
                new Object[] {"Яковлевский", "44,18","34,61"},
                new Object[] {"Белгородский", "44,19","34,41"},
                new Object[] {"Новооскольский", "44,21","34,81"},
        };
    }

    @DataProvider
    public  Object[][] heliosData() {
        return new Object[][] {
                new Object[] {"Гелиос 2-1","100","1","SWN2NV93LDN13481","5274240944323451","+79041234451","11.12.2017","6","11.12.2018","6"},
                new Object[] {"Гелиос 2-2","100","1","SWN2NV93LDN13482","5274240944323452","+79041234452","12.12.2017","6","12.12.2018","6"},
                new Object[] {"Гелиос 2-3","100","1","SWN2NV93LDN13483","5274240944323453","+79041234453","13.12.2017","6","13.12.2018","6"},
                new Object[] {"Гелиос 2-4","100","1","SWN2NV93LDN13484","5274240944323454","+79041234454","14.12.2017","6","14.12.2018","6"},
                new Object[] {"Гелиос 2-5","100","1","SWN2NV93LDN13485","5274240944323455","+79041234455","15.12.2017","6","15.12.2018","6"},
        };
    }

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

        checkName("ОБЪЕКТЫ", panelLocator);

        WebElement treeButton = driver.findElement(treeLocator);
        treeButton.click();
    }


    @Test(dataProvider = "groupData", groups = {"testAddObjectGroup"})
    public void addGroup(String name, String description) throws InterruptedException {
        try{
            By addButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div/div");
            By radioButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div/div[2]/div[1]/span/label");
            By nameGroupLocator = By.id("x-auto-3-input");
            By descriptionGroupLocator = By.id("x-auto-4-input");
            By saveButtonLocator = By.cssSelector(".GGTUI1GBMHE-su-ivt-helios-web-ui-form-UIBinderFormBaseView_EditorFormUiBinderImpl_GenCss_style-buttonsContainer > div:nth-child(1) > div:nth-child(2) > div:nth-child(2)");
            By nameVerificationLocator = By.cssSelector("#ext-gen6 > div:nth-child(15) > div.GGTUI1GBCCE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-mainContainer > div.GGTUI1GBLBE-su-ivt-helios-web-ui-layout-LayoutView_LayoutUiBinderImpl_GenCss_style-center.GGTUI1GBI3C-su-ivt-helios-web-ui-layout-LayoutResources-LayoutStyle-centerMinimized > div > div.GGTUI1GBFCE-su-ivt-helios-web-ui-layout-ThreeColumnContentView_ThreeColumnContentViewUiBinderImpl_GenCss_style-center > div > div.GGTUI1GBB4C-su-ivt-helios-web-ui-panel-contentPanel-ContentPanelResources-ContentPanelCss-content > div > div > div:nth-child(2) > div > div > div > div > div > div:nth-child(2) > ul > li:nth-child(1) > div:nth-child(2)");

            selectTreeNode();
            WebElement addButton = driver.findElement(addButtonLocator);
            addButton.click();
            retryingFindClick(radioButtonLocator);
            WebElement radioButton = driver.findElement(radioButtonLocator);
            radioButton.click();

            WebElement nameGroupField = driver.findElement(nameGroupLocator);
            nameGroupField.sendKeys(name);
            WebElement descriptionGroupField = driver.findElement(descriptionGroupLocator);
            descriptionGroupField.sendKeys(description);

            WebElement saveButton = driver.findElement(saveButtonLocator);
            saveButton.click();
            Thread.sleep(2000);
            checkName(name, nameVerificationLocator);

        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(dataProvider = "geoData", groups = {"testAddObjectGroup"})
    public void addGeoObject(String name, String latitude, String longitude) throws InterruptedException {
        try {
            By addButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div/div[1]/div[4]/div/div");
            By radioButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div/div[2]/div[2]/span/label");
            By nameGeoLocator = By.id("x-auto-5-input");
            By typeGeoLocator = By.id("x-auto-6-input");
            By latitudeGeoLocator = By.id("x-auto-7-input");
            By longitudeGeoLocator = By.id("x-auto-8-input");
            By timeZoneGeoLocator = By.id("x-auto-9-input");
            By saveButtonLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[3]/div/div[1]/div/div");
            By nameVerificationLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/form/div/ul/li[1]/div[2]");

            selectTreeNode();
            WebElement addButton = driver.findElement(addButtonLocator);
            addButton.click();

            WebElement radioButton = driver.findElement(radioButtonLocator);
            radioButton.click();

            retryingFindClick(nameGeoLocator);
            WebElement nameGeoField = driver.findElement(nameGeoLocator);
            nameGeoField.sendKeys(name);

            WebElement typeGeoField = driver.findElement(typeGeoLocator);
            Actions builder = new Actions(driver);
            builder.click(typeGeoField).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

            WebElement latitudeGeoField = driver.findElement(latitudeGeoLocator);
            latitudeGeoField.sendKeys(latitude);

            WebElement longitudeGeoField = driver.findElement(longitudeGeoLocator);
            longitudeGeoField.sendKeys(longitude);

            WebElement timeZoneField = driver.findElement(timeZoneGeoLocator);
            builder.click(timeZoneField).sendKeys(Keys.ENTER).build().perform();

            WebElement saveButton = driver.findElement(saveButtonLocator);
            saveButton.click();
            Thread.sleep(3000);

            checkName(name, nameVerificationLocator);

        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }
    @Test (dataProvider = "heliosData",groups = {"testAddObjectGroup"})
    public void addHeliosObject(String name, String nominal, String ktt, String fn, String sn,
                                String phone, String shipmentDate, String guarantee, String batteryReplacementDate,
                                String guaranteePeriod) throws InterruptedException {
        try {
            selectTreeNode();
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
            Thread.sleep(1000);

            retryingFindClick(radioButtonLocator);
            WebElement radioButton = driver.findElement(radioButtonLocator);
            radioButton.click();

            Thread.sleep(4000);
            retryingFindClick(nameHeliosLocator);
            WebElement nameHeliosField = driver.findElement(nameHeliosLocator);
            nameHeliosField.sendKeys(name);

            WebElement versionCCField = driver.findElement(versionCCLocator);
            Actions builder = new Actions(driver);
            builder.click(versionCCField).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

            WebElement typeCCField = driver.findElement(typeCCLocator);
            builder = new Actions(driver);
            builder.click(typeCCField).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

            WebElement nominalField = driver.findElement(nominalLocator);
            nominalField.sendKeys(nominal);

            WebElement kttField = driver.findElement(kttLocator);
            kttField.sendKeys(ktt);

            WebElement fnField = driver.findElement(fnLocator);
            fnField.sendKeys(fn);

            WebElement snField = driver.findElement(snLocator);
            snField.sendKeys(sn);

            WebElement phoneField = driver.findElement(phoneLocator);
            phoneField.sendKeys(phone);

            WebElement gsmField = driver.findElement(gsmLocator);
            builder = new Actions(driver);
            builder.click(gsmField).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

            WebElement shipmentDateField = driver.findElement(shipmentDateLocator);
            builder = new Actions(driver);
            builder.click(shipmentDateField).sendKeys(shipmentDate).sendKeys(Keys.ENTER).build().perform();

            WebElement guaranteeField = driver.findElement(guaranteeLocator);
            guaranteeField.sendKeys(guarantee);

            WebElement batteryReplacementDateField = driver.findElement(batteryReplacementDateLocator);
            builder = new Actions(driver);
            builder.click(batteryReplacementDateField).sendKeys(batteryReplacementDate).sendKeys(Keys.ENTER).build().perform();

            WebElement commissioningDateField = driver.findElement(commissioningDateLocator);
            builder = new Actions(driver);
            builder.click(commissioningDateField).sendKeys(Keys.ENTER).build().perform();

            WebElement guaranteePeriodCUField = driver.findElement(guaranteePeriodCULocator);
            guaranteePeriodCUField.sendKeys(guaranteePeriod);

            WebElement saveButton = driver.findElement(saveButtonLocator);

            saveButton.click();
            checkName(name, nameVerificationLocator);
            Thread.sleep(10000);

        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(dataProvider = "groupData",dependsOnGroups = {"testAddObjectGroup"})
    public void deleteGroup(String name, String description) throws InterruptedException {
        String type = "GroupObject";
        delete(name,type);
    }

    @Test(dataProvider = "geoData",dependsOnGroups = {"testAddObjectGroup"})
    public void deleteGeoObject(String name, String latitude, String longitude) throws InterruptedException {
        String type = "GeoObject";
        delete(name,type);
    }

    @Test(dataProvider = "heliosData",dependsOnGroups = {"testAddObjectGroup"})
    public void deleteHeliosObject(String name, String nominal, String ktt, String fn, String sn,
                                   String phone, String shipmentDate, String guarantee, String batteryReplacementDate,
                                   String guaranteePeriod) throws InterruptedException {
        String type = "HeliosObject";
        delete(name,type);
    }

    private void  selectTreeNode() throws InterruptedException {
        By selectTreeNodeLocator = By.xpath("//*[@id=\"1007\"]/div[1]/div/div[4]/div");
        By nameNodeLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/form/div/ul/li[1]/div[2]");

        WebElement treeNode = driver.findElement(selectTreeNodeLocator);
        treeNode.click();
        checkName("Testing", nameNodeLocator);
    }

    private static void checkName(String condition, By panelLocator) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElementLocated(panelLocator,condition));

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals(condition, panelNameText);
    }

    private void delete(String name, String type) throws InterruptedException {
        try {

            By searchFieldLocator = By.cssSelector("input.gwt-TextBox");
            By searchButtonLocator = By.cssSelector("a.gwt-Anchor.GGTUI1GBCVD-su-ivt-helios-web-ui-widgets-searchField-SearchFieldResources-Style-find");
            By searchResultLocator = By.xpath("//div[4]/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div[2]/div/div[1]/div/div[4]/div");
            By deleteGroupButtonLocator = By.xpath("//div[@class='GGTUI1GBFAE-su-ivt-helios-web-pages-admin-infoPanel-FormPanelView_FormPanelViewUiBinderImpl_GenCss_style-headerContainer']//div[.='Удалить группу']");
            By deleteGeoObjectButtonLocator = By.xpath("//*[@id=\"ext-gen6\"]/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div/div");
            By deleteHeliosObjectButtonLocator = By.xpath("//*[@id=\"ext-gen6\"]/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div/div");

            By confirmButtonLocator = By.xpath("//div[@class='GGTUI1GBFGD-su-ivt-helios-web-ui-widgets-dialog-CustomDialogResources-Style-buttonsPanel']//div[.='Да']");
            By confirmAttachButtonLocator = By.xpath("//div[@class='GGTUI1GBFGD-su-ivt-helios-web-ui-widgets-dialog-CustomDialogResources-Style-buttonsPanel']//div[.='Да']");
            By eraseButtonLocator = By.cssSelector("a.gwt-Anchor");

            retryingFindClick(searchFieldLocator);
            WebElement searchField = driver.findElement(searchFieldLocator);
            searchField.clear();
            searchField.sendKeys(name);

            WebElement searchButton = driver.findElement(searchButtonLocator);
            searchButton.click();

            retryingFindClick(searchResultLocator);

            WebElement searchResult = driver.findElement(searchResultLocator);
            searchResult.click();

            WebElement deleteButton;
            switch (type) {
                case "GroupObject":
                    deleteButton = driver.findElement(deleteGroupButtonLocator);
                    deleteButton.click();
                    break;
                case "GeoObject":
                    deleteButton = driver.findElement(deleteGeoObjectButtonLocator);
                    deleteButton.click();
                    break;
                case "HeliosObject":
                    deleteButton = driver.findElement(deleteHeliosObjectButtonLocator);
                    deleteButton.click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid object type");
            }

            WebElement confirmButton = driver.findElement(confirmButtonLocator);
            confirmButton.click();

            if (type.equals("HeliosObject")){
                WebElement confirmAttachButton = driver.findElement(confirmAttachButtonLocator);
                confirmAttachButton.click();
            }

            WebElement eraseButton = driver.findElement(eraseButtonLocator);
            eraseButton.click();
            Thread.sleep(3000);
        }catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    private boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }
    @AfterClass()
    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail (verificationErrorString);
        }
    }
}
