import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {

    public static void main(String[] args) {

        // 1. open a browser (chrome)
        System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 2. Maximize the browser

        driver.manage().window().maximize();

        // 3. open url

        driver.get("https://facebook.com");



    }


}
