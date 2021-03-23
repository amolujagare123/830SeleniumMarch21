import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class SeleniumDemo2 {

    public static void main(String[] args) {

        // 1. open a browser (chrome)
      //  System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");

       /* WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();*/

       /* WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();*/

        WebDriverManager.operadriver().setup();
        WebDriver driver = new OperaDriver(); // upcasting


        // 2. Maximize the browser
        driver.manage().window().maximize();

        // 3. open url
        driver.get("https://facebook.com");



    }


}
