package TestNGDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginDemoBeforeMethod {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.close();
    }


    @Test
    public void myLoginTest1()
    {



        driver.get("http://stock.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.cssSelector("input#login-username")); // using id

        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.cssSelector("input#login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.cssSelector("input.button"));
        btnLogin.click();
    }

    @Test
    public void myLoginTest2()
    {



        driver.get("http://stock.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.cssSelector("input#login-username")); // using id

        txtUsername.sendKeys("sdsd");

        WebElement txtPassword = driver.findElement(By.cssSelector("input#login-password"));
        txtPassword.sendKeys("dsds");

        WebElement btnLogin = driver.findElement(By.cssSelector("input.button"));
        btnLogin.click();
    }

    @Test
    public void myLoginTest3()
    {



        driver.get("http://stock.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.cssSelector("input#login-username")); // using id

        txtUsername.sendKeys("");

        WebElement txtPassword = driver.findElement(By.cssSelector("input#login-password"));
        txtPassword.sendKeys("");

        WebElement btnLogin = driver.findElement(By.cssSelector("input.button"));
        btnLogin.click();
    }
}
