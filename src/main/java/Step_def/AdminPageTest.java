package Step_def;

import PageObjects.AdminPageObject;
import Utilities.OrangeHrmUtilities;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class AdminPageTest{
    private OrangeHrmUtilities utilities;

    private AdminPageObject adminPageObject;


    public AdminPageTest(OrangeHrmUtilities utilities) throws IOException  {
        this.utilities = utilities;
    }

    @And("navigating to admin page")
    public void navigating_to_Web_Page(){
        adminPageObject=new AdminPageObject(utilities.getDriver());
        adminPageObject.navigateToAdmin();

    }

    @When("entering the username {} for searching in admin page")
    public void enter_useername_forSearch(String username){

        adminPageObject.enterSearchUsername(username);
    }

    @And("clicking on the search button")
    public void click_on_search_button(){
        adminPageObject.Search();
    }
    @Then("verfying the Screenshot")
    public void verifying_the_attaching_ScreeShot() throws IOException {
        utilities.takeScreenshot("searchedUser");
    }
    @After
    public void tearDown(){
        utilities.getDriver().quit();
    }
}
