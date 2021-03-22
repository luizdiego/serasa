import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class TestHomePage {
    HomePage page;
    WebDriver driver;

    @Before
    public void setUpTest(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, java.util.concurrent.TimeUnit.SECONDS);
        driver.get("https://www.serasaconsumidor.com.br");
        page = new HomePage(driver);
        page.clickEntrar();
    }

    @Test
    public void check_Login_Page_Is_Displayed_When_Click_Entrar(){
        Assert.assertEquals(page.getDigitYourCpfMessage(),"Digite seu CPF");
    }

    @Test
    public void check_Message_Returns_When_Invalid_CPF(){
        page.informYourCPFNumber("000.000.000-00");
        page.clickConfirmar();
        Assert.assertEquals(page.getInformationUnderCpfInput(),"Você precisa informar um CPF válido.");
    }

    @Test
    public void check_Validation_Message_When_CPF_Is_Empty(){
        page.clickConfirmar();
        Assert.assertEquals(page.getInformationUnderCpfInput(),"Por favor preencha seu CPF.");
    }

    @Test
    public void check_CPF_Is_Valid_And_Create_Account(){
        page.informYourCPFNumber("000.275.620-00"); //Generated on 4Devs
        page.clickConfirmar();

        CreateAccountPage account = new CreateAccountPage(driver);
        Assert.assertEquals(account.getCreateAccountWithMessage(), "Criar conta com");
    }

    @After
    public void tearDown(){
        if(driver!= null){
            driver.quit();
        }
    }

}
