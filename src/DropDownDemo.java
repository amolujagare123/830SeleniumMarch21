import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://lifepartner.in");


        WebElement mStatus = driver.findElement(By.name("ms"));

        Select selMStatus = new Select(mStatus);

       // selMStatus.selectByVisibleText("Never married");

        selMStatus.selectByValue("7");
    }
    }
