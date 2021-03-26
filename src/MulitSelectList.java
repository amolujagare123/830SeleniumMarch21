import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MulitSelectList {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///D:/Scriptinglogic%20docs/class%20Activities/Selenium/Mywebsite/amol.html");

        WebElement multiList = driver.findElement(By.id("multiSel"));

        Select selMultiList = new Select(multiList);

        selMultiList.selectByIndex(0);
        selMultiList.selectByIndex(2);
        selMultiList.selectByIndex(3);

        Thread.sleep(4000);

       // selMultiList.deselectByIndex(2);

        selMultiList.deselectAll();

    }
    }
