import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PasswordPage {

    WebDriver driver;

    public PasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='valgrind']//h4"), "...e digite sua senha"));
    }

    // Variables
    @FindBy(xpath = "//div[@id='valgrind']//div//span")
    private WebElement msgInformPassword;

    // Methods
    public String getInformYourPasswordMessage() {
        return msgInformPassword.getText();
    }
}
