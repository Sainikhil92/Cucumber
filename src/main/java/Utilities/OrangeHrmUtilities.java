package Utilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class OrangeHrmUtilities {

    private static WebDriver driver;
    private static Logger log;
    private static Properties properties;

    public OrangeHrmUtilities() throws IOException {
        initialize();

    }

    public  WebDriver getDriver() {
        return driver;
    }

    public  Logger getLog() {
        return log;
    }

    public  Properties getProperties() {
        return properties;
    }


    public  void initialize() throws IOException {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        log = LogManager.getLogger(OrangeHrmUtilities.class);
        setFileProperties();

    }


    private  void setFileProperties() throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Incubation\\CucumberFramework\\src\\test\\resources\\file.properties");
        properties = new Properties();
        properties.load(inputStream);
    }

    public void  takeScreenshot(String name) throws IOException {
        TakesScreenshot screenshot= (TakesScreenshot) getDriver();
        File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("C:\\Incubation\\CucumberFramework\\target\\logs\\"+name+".png"));
    }


}
