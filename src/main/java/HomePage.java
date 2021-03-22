import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Variables
    @FindBy(xpath = "//div/button[@data-gtm-name='Entrar']")
    private WebElement btnEntrar;

    @FindBy(xpath = "//div[@id='valgrind']//form//span")
    private WebElement msgInformCPF;

    @FindBy(xpath = "//input[@id='cpf']")
    private WebElement inputCPF;

    @FindBy(xpath = "//button[@class='button button--primary w-100']")
    private WebElement btnConfirmar;

    @FindBy(xpath = "//div[@id='valgrind']//form//small")
    WebElement msgUnderInput;

    // Methods
    public void clickEntrar(){
        btnEntrar.click();
    }

    public void clickConfirmar(){
        btnConfirmar.click();
    }

    public String getInformationUnderCpfInput() {
        return msgUnderInput.getText();
    }

    public String getDigitYourCpfMessage() {
        return msgInformCPF.getText();
    }

    public void informYourCPFNumber(String cpf) {
        inputCPF.click();
        inputCPF.sendKeys(cpf); ;
    }
}
