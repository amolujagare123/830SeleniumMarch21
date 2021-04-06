import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginJunit2 {

    static WebDriver driver;

    @BeforeClass // (1) Method with this annotation (@BeforeClass) will run before first test method of the class
    public static void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


  /*  @Before // (2)
    public  void testBefore()
    {
        driver.get("http://facebook.com");
    }*/


    @AfterClass // Method with this annotation (@AfterClass) will run after last test method of the class
    public static void closeBrowser() throws InterruptedException {
       Thread.sleep(4000);
        driver.close();
    }



    //int a;

    @Test
    public void myLoginTest1()
    {

        //a =10;

        driver.get("http://stock.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.cssSelector("input#login-username")); // using id

        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.cssSelector("input#login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.cssSelector("input.button"));
       // btnLogin.click();
    }

    @Test
    public void myLoginTest2()
    {

        driver.get("http://stock.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.cssSelector("input#login-username")); // using id

        txtUsername.sendKeys("sdsd");

        WebElement txtPassword = driver.findElement(By.cssSelector("input#login-password"));
        txtPassword.sendKeys("dsd");

        WebElement btnLogin = driver.findElement(By.cssSelector("input.button"));
       // btnLogin.click();
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
      //  btnLogin.click();
    }

}
