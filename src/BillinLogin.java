import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BillinLogin {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://billing.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@name='email']"));
        txtUsername.sendKeys("amolujagare@gmail.com");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@name='password']"));
        txtPassword.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@name='btn_login']"));
        btnLogin.click();

        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='View Clients']")).click();


        String name = "Admin2";

        driver.findElement(By.xpath("//tr[td/a[text()='"+name+"']]//div")).click();
        driver.findElement(By.xpath("//tr[td/a[text()='"+name+"']]//i[contains(@class,'edit')]")).click();


    }
}
