package su.ivt.test.selenium.lan.test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "user")
    private WebElement usernameLocator;
    @FindBy(id = "pass")
    private WebElement passwordLocator;
    @FindBy(xpath = "/html/body/form/div/a/img")
    private WebElement buttonLocator;
    @FindBy(xpath = "/html/body/div[4]/div[1]/div/div[3]/div/div[5]/span")
    private WebElement profileLocator;

    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public LoginPage enterUsername (String username) {
        usernameLocator.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword (String password) {
        passwordLocator.sendKeys(password);
        return this;
    }

    public void login(){
        buttonLocator.click();
    }

    public WebElement getProfileLocator() {
        return profileLocator;
    }
}
