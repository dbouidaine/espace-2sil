import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class Exo3Test {
    static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
    }
    @Test
    public void Test() {
        Exo3 Page = new Exo3(driver);
        String totalPrie=Page.Total("shoes for men","0","4");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(totalPrie, "AU $10.98");
    }
    @AfterClass
    public static void setUpAfterClass() {
        driver.quit();
    }

}