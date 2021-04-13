package TestNGDemos.RealDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TutorialsSites {

    WebDriver driver;
    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void scriptingLogic()
    {
       driver.get("https://scriptinglogic.com");
    }

    @Test
    public void tutorialspoint()
    {
        driver.get("https://www.tutorialspoint.com/");
    }

    @Test
    public void javatpoint()
    {
        driver.get("https://www.javatpoint.com/");
    }

    @Test
    public void geeks()
    {
        driver.get("https://www.geeksforgeeks.org/");
    }

}
