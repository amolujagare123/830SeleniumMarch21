package DataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginDemo {


    @Test (dataProvider = "getData")
    public void myLoginTest1(String user ,String pass)
    {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://stock.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.cssSelector("input#login-username")); // using id

        txtUsername.sendKeys(user);

        WebElement txtPassword = driver.findElement(By.cssSelector("input#login-password"));
        txtPassword.sendKeys(pass);

        WebElement btnLogin = driver.findElement(By.cssSelector("input.button"));
        btnLogin.click();
    }


       @DataProvider
       public  Object[][]  getData()
       {
           Object[][] data = new Object[3][2];

           data[0][0] ="admin"; // user
           data[0][1] ="admin"; // pass

           data[1][0] ="wewewe";
           data[1][1] ="uyuyu";

           data[2][0] ="";
           data[2][1] ="";

           return  data;
       }


}
