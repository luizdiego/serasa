import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    WebDriver driver;

    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Variables
    @FindBy(xpath = "//form[@id='sign_up_form']/h1")
    private WebElement msgCreateAccountWith;

    // Methods
    public String getCreateAccountWithMessage() {
        return msgCreateAccountWith.getText();
    }
}
