package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    public WebDriver driver;

    @FindBy(xpath = "//input[@name=\"username\"]")
    private WebElement usernamePath;

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement passwordPath;

    @FindBy(xpath = "//button[text()=\" Login \"]")
    private WebElement signInPath;

    @FindBy(xpath = "//span[text()=\"Dashboard\"]")
    private WebElement verifyText;

    @FindBy(xpath = "//p[text()=\"Invalid credentials\"]")
    private WebElement invalidText;
    @FindBy(xpath = "//div[@class=\"orangehrm-login-logo-mobile\"]/following::h5[text()=\"Login\"]")
    WebElement loginpageTxt;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage setUsername(String username) {
        usernamePath.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordPath.sendKeys(password);
        return this;
    }

    public LoginPage signIn() {
        signInPath.click();
        return this;
    }

    public void verifyTxt(String txt) {
        String s = verifyText.getText();
        Assert.assertEquals(s, txt);
    }

    public void invalidtxt(String txt) {
        Assert.assertEquals(invalidText.getText(), txt, "text is not matching");
    }

    public void validateLoginPage(){
        Assert.assertEquals(loginpageTxt.getText(),"Login","you are not in login page");
    }
}