package TestFiles;
import Step_def.Login_PageTest;
import Utilities.OrangeHrmUtilities;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeaturesFile/Task2_featurefile.feature",
        glue = {"Step_def","PageObjects","Utilities"},monochrome = true,
        plugin = {"pretty","json:target/cucumber-json-reports/cucumber.json","html:target/cucumber-reports.html"}

)
@Test
public class Task_2_Runner {


}
