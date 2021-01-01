import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class Exo3 extends PageObject{
    @FindBy(id="gh-ac") public WebElement inputSearch;
    @FindBy(linkText="New Men's Lace up Athletic Sneakers Sport Shoes Breathable Mesh Running shoes") public WebElement shoes;
    @FindBy(id="msku-sel-1") public WebElement color;
    @FindBy(id="msku-sel-2") public WebElement size;
    public void select_color(String valeur){
        Select statusDropdown=new Select(color);
        statusDropdown.selectByValue(valeur);
    }
    public void select_size(String valeur){
        Select statusDropdown=new Select(size);
        statusDropdown.selectByValue(valeur);
    }
    @FindBy(id="isCartBtn_btn") public WebElement AddToCart;
    @FindBy(xpath="//div[@class='val-col total-row']") public WebElement subtotal;

    public Exo3(WebDriver driver) {
        super(driver);
    }
    public String Total(String recherche,String couleur,String taille){
        this.inputSearch.sendKeys(recherche);
        this.inputSearch.submit();
        this.shoes.click();
        this.select_color(couleur);
        this.select_size(taille);
        this.AddToCart.click();
        return this.subtotal.getText();
    }
}

