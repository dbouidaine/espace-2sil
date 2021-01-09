import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;


public class Exo2Steps {

    private static WebDriver driver;

    @Given("I am in the page {string}")
    public void iAmInThePage(String page) {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(page);
    }

    @When("I search for {string}")
    public void iSearchFor(String search) {
        WebElement inputSearch =  driver.findElement(By.id("gh-ac"));
        inputSearch.sendKeys(search);
        inputSearch.submit();
    }

    @And("I choose {string} as product")
    public void iChooseAsProduct(String product) {
        WebElement shoes= driver.findElement(By.linkText(product));
        shoes.click();
    }

    @And("I select {string} as color and {string} as size")
    public void iSelectAsColorAndAsSize(String color, String size) {
        Select colors=new Select( driver.findElement(By.name("Manufacturer Colour")));
        colors.selectByVisibleText(color);
        Select sizes=new Select( driver.findElement(By.name("Shoe Size")));
        sizes.selectByVisibleText(size);
    }

    @And("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        WebElement AddToCart = driver.findElement(By.id("isCartBtn_btn"));
        AddToCart.click();
    }


    @Then("I expect {string} as a total price")
    public void iExpectAsATotalPrice(String total_expected) {
        WebElement subtotal = driver.findElement(By.xpath("//div[@data-test-id='SUBTOTAL']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(subtotal.getText(), total_expected);
        driver.quit();
    }


}
