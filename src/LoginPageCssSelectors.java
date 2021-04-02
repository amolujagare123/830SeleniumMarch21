import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageCssSelectors {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://stock.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.cssSelector("input#login-username")); // using id
        //      #login-username

        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.cssSelector("input#login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.cssSelector("input.button"));
        btnLogin.click();

/*
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();

        WebElement txtName = driver.findElement(By.id("name"));
        txtName.sendKeys("Monica");

        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys("abc xyz");

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys("898989");

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys("8987889");

        WebElement btnAdd = driver.findElement(By.name("Submit"));
        btnAdd.click();*/

    }
    
}
