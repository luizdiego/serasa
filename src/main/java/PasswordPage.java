import net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor;
import org.apache.bcel.ExceptionConstants;
import org.apache.http.util.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage {

    WebDriver driver;

    public PasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Variables
    @FindBy(xpath = "//form//label/span")
    private WebElement msgInformPassword;

    // Methods
    public String getInformYourPasswordMessage() {
        return msgInformPassword.getText();
    }
}
