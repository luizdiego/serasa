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
        driver.get("https://www.serasaconsumidor.com.br");
        page = new HomePage(driver);
        page.clickEntrar();
    }



    @After
    public void tearDown(){
        if(driver!= null){
            driver.quit();
        }
    }

}
