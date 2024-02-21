package TestFiles;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeaturesFile",
        glue = "Step_def",
        plugin = {"pretty","json:target/cucumber-json-reports/cucumber.json","html:target/cucumber-reports"}

)
@Test
public class Task_1_Runner {

}
