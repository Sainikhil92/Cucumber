package Step_def;

import PageObjects.LoginPage;
import PageObjects.Signout_Object;
import Utilities.OrangeHrmUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class SignOut_Test {


    private OrangeHrmUtilities utilities;
    private Signout_Object signOutObject;

    private LoginPage loginPage;
    public SignOut_Test(OrangeHrmUtilities utilities) throws IOException {
        this.utilities = utilities;
    }


    @And("Clicking on the profile icon")
    public void click_on_Profile(){
        signOutObject=new Signout_Object(utilities.getDriver());
        signOutObject.navigateToProfile();

    }
    @And("logging out of orange hrm")
    public void logging_out(){

        signOutObject.logout();
    }
    @Then("verifying we are in login page")
    public void verifying_we_are_inLogin_page(){
        loginPage=new LoginPage(utilities.getDriver());
        loginPage.validateLoginPage();
    }
}
