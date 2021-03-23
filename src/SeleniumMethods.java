import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class SeleniumMethods {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
         // 2. Maximize the browser
        driver.manage().window().maximize();
        // 3. open url
        driver.get("https://facebook.com");

        driver.navigate().to("http://gmail.com");

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();


    }


}
