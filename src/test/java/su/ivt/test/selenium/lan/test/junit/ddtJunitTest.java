package su.ivt.test.selenium.lan.test.junit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class ddtJunitTest {
    private static WebDriver driver;


    private String name;
    private String description;

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(
                new Object[][] {
                        {"Группа 1", "Описание группы 1"},
                        {"Группа 2", "Описание группы 2"},
                        {"Группа 3", "Описание группы 3"},
                        {"Группа 4", "Описание группы 4"},
                        {"Группа 5", "Описание группы 5"},
                }
        );
    }
    public ddtJunitTest(String name, String description){
        this.name = name;
        this.description = description;
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
        Thread.sleep(999);

        WebElement panelName = driver.findElement(panelLocator);
        String panelNameText = panelName.getText();
        Assert.assertEquals("ОБЪЕКТЫ", panelNameText);

        WebElement treeButton = driver.findElement(treeLocator);
        treeButton.click();
        Thread.sleep(999);
    }

    @Before
    public void selectTreeNode() throws InterruptedException {

        By selectTreeNodeLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[1]/div/div[2]/div/div/div[2]/div[8]/div[1]/div/div[4]/div");
        By nameNodeLocator = By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/form/div/ul/li[1]/div[2]");

        WebElement treeNode = driver.findElement(selectTreeNodeLocator);
        treeNode.click();
        Thread.sleep(999);

        WebElement nodeName = driver.findElement(nameNodeLocator);
        String nodeNameText = nodeName.getText();
        Assert.assertEquals("Testing", nodeNameText);
        Thread.sleep(999);
    }

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
        nameGroupField.sendKeys(name);
        WebElement DescriptionGroupField = driver.findElement(descriptionGroupLocator);
        DescriptionGroupField.sendKeys(description);

        WebElement saveButton = driver.findElement(saveButtonLocator);
        saveButton.click();
        Thread.sleep(3000);

        WebElement nameVerification = driver.findElement(nameVerificationLocator);
        String nameVerificationText = nameVerification.getText();
        Assert.assertEquals(name, nameVerificationText);

    }
}
