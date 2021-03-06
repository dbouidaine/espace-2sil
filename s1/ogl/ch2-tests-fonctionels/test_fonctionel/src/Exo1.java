import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class Exo1 {

	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass(){
        System.setProperty("webdriver.chrome.driver","D:/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void test() {
		
	    driver.get("https://www.ebay.com/");
		WebElement shopByCategory=driver.findElement(By.id("gh-shop-a"));
		shopByCategory.click();
		WebElement kidsToys=driver.findElement(By.linkText("Kids toys"));
		kidsToys.click();
		WebElement Action = driver.findElement(By.xpath("//p[@class='b-guidancecard__title'][text()='Action']"));
		Action.click();
		WebElement Car = driver.findElement(By.xpath("//a[@href='https://www.ebay.com/b/Action-Diecast-and-Toy-Car/222/bn_1848704']"));
		Car.click();
		WebElement Toyota = driver.findElement(By.xpath("//p[@class='b-guidancecard__title'][text()='Toyota']"));
		Toyota.click();
		WebElement nbrProduit=driver.findElement(By.xpath("//h2[@class='srp-controls__count-heading']"));
		driver.manage().timeouts(). implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals(nbrProduit.getText(),"1-8 of 8 Results");
	}

	@AfterClass
	public static void setUpAfterClass(){
		driver.quit();

	}


}
