package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Signout_Object {

    public WebDriver driver;

    public Signout_Object(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")
    WebElement profileButton;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]/following::a[text()=\"Logout\"]")
    WebElement logoutButton;


    public Signout_Object navigateToProfile(){
        profileButton.click();
        return this;
    }
    public Signout_Object logout(){
        logoutButton.click();
        return this;

    }


}
