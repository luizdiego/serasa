import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Variables
    @FindBy(xpath = "//div/button[@data-gtm-name='Entrar']")
    private WebElement btnEntrar;

    // Methods
    public void clickEntrar(){
        btnEntrar.click();
    }
}
