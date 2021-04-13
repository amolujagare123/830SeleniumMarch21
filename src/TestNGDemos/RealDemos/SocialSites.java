package TestNGDemos.RealDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SocialSites {

    WebDriver driver;
    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (priority = 1)
    public void facebook()
    {
        driver.get("https://facebook.com");
    }

    @Test (priority = 2)
    public void twitter()
    {
        driver.get("https://twitter.com");
    }

    @Test (priority = 3)
    public void instagram()
    {
        driver.get("https://instagram.com");
    }

    @Test (priority = 4)
    public void linkedIn()
    {
        driver.get("https://linkedIn.com");
    }




}
