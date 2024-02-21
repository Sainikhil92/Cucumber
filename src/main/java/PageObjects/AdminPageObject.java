package PageObjects;

import Utilities.OrangeHrmUtilities;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPageObject {
    public WebDriver driver;

    @FindBy(xpath = "//span[text()=\"Admin\"]")
    WebElement adminpath;

    @FindBy(xpath = "//label[text()=\"Username\"]//following::input[@class=\"oxd-input oxd-input--active\"]")
    WebElement searchUserPath;

    @FindBy(xpath = "//button[text()=\" Search \"]")
    WebElement searchButton;

    public AdminPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AdminPageObject navigateToAdmin() {
        adminpath.click();
        return this;
    }

    public AdminPageObject enterSearchUsername(String username){
        searchUserPath.sendKeys(username);
        return this;
    }

    public AdminPageObject Search(){
        searchButton.click();
        return this;
    }



}
