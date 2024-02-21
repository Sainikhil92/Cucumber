package Step_def;

import PageObjects.LoginPage;
import Utilities.OrangeHrmUtilities;
import cucumber.api.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.io.IOException;

public class Login_PageTest {

    private OrangeHrmUtilities utilities;
    private LoginPage loginPage;

    public Login_PageTest(OrangeHrmUtilities utilities) throws IOException {
        this.utilities = utilities;
    }

    @Given("Opening the login portal")
    public void opening_The_Login_portal() {
        loginPage = new LoginPage(utilities.getDriver());
        utilities.getDriver().get(utilities.getProperties().getProperty("url"));

    }

    @When("I enter my valid username {} and password")
    public void Entering_MyValidUsername_and_password(String username) {

        if (username.equals("Admin")) {
            loginPage.setUsername(utilities.getProperties().getProperty("Username"))
                    .setPassword(utilities.getProperties().getProperty("Password"));
        }
        else {
            Assert.fail("user not found");
        }

    }

    @When("I enter my valid username {} and password {}")
    public void i_enter_My_valida_username_and_password(String username,String password){
        loginPage.setUsername(username).setPassword(password);
    }

    @And("I click on Sign In button")
    public void click_On_sign_IN(){
        loginPage.signIn();
    }

    @Then("I should be successfully logged in")
    public void succesfully_Logged_IN() {
       loginPage.verifyTxt("Dashboard");
    }
    @Then("I should get error message as {}")
    public void should_get_error_message(String txt){
        loginPage.invalidtxt(txt);
    }
    @After
    public void tearDown(){
        utilities.getDriver().quit();
    }


}
