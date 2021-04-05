import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginJunit {


    @Test
    public void myLoginTest1()
    {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

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
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://stock.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.cssSelector("input#login-username")); // using id

        txtUsername.sendKeys("sdsd");

        WebElement txtPassword = driver.findElement(By.cssSelector("input#login-password"));
        txtPassword.sendKeys("dsd");

        WebElement btnLogin = driver.findElement(By.cssSelector("input.button"));
        btnLogin.click();
    }

    @Test
    public void myLoginTest3()
    {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://stock.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.cssSelector("input#login-username")); // using id

        txtUsername.sendKeys("");

        WebElement txtPassword = driver.findElement(By.cssSelector("input#login-password"));
        txtPassword.sendKeys("");

        WebElement btnLogin = driver.findElement(By.cssSelector("input.button"));
        btnLogin.click();
    }

}
