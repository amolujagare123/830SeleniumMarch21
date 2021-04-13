package TestNGDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestAssert {

    @Test
    public void myLoginTest1()
    {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://demo.guru99.com/v4/");

        WebElement txtUsername = driver.findElement(By.cssSelector("input[name='uid']")); // using id
        txtUsername.sendKeys("mngr316336");

        WebElement txtPassword = driver.findElement(By.cssSelector("input[name='password']"));
        txtPassword.sendKeys("evUhabE");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[name='btnLogin']"));
        btnLogin.click();

        String expected = "Guru99 Bank Manager HomePage 1";
        String actual = driver.getTitle();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        /*if(expected.equals(actual))
            System.out.println("Test is passed");
        else
            System.out.println("Test is failed");*/

        Assert.assertEquals(actual,expected,"wrong page title");




    }
}
