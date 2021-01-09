import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features/Exo2.feature", plugin ={"pretty", "html:report"})
public class Exo2Test {

}