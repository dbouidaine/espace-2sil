import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class Exo2 {
    static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() {

        driver.get("https://www.ebay.com/");
        WebElement inputSearch = driver.findElement(By.id("gh-ac"));
        inputSearch.sendKeys("shoes for men");
        inputSearch.submit();
        WebElement shoes=driver.findElement(By.linkText("New Men's Lace up Athletic Sneakers Sport Shoes Breathable Mesh Running shoes"));
        shoes.click();
        Select color=new Select(driver.findElement(By.id("msku-sel-1")));
        color.selectByValue("0");
        Select size=new Select(driver.findElement(By.id("msku-sel-2")));
        size.selectByValue("4");
        WebElement AddToCart = driver.findElement(By.id("isCartBtn_btn"));
        AddToCart.click();
        WebElement subtotal = driver.findElement(By.xpath("//div[@class='val-col total-row']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(subtotal.getText(), "AU $10.98");
    }

    @AfterClass
    public static void setUpAfterClass() {
        driver.quit();

    }
}
