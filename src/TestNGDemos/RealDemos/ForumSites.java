package TestNGDemos.RealDemos;

import TestNGDemos.RealDemos.utl.OpenUrl;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForumSites extends OpenUrl {



    @Test
    public void quora()
    {
        driver.get("https://quora.com");
    }

    @Test
    public void stackoverflow()
    {
        driver.get("https://stackoverflow.com");

        Assert.assertEquals(true,false,"this site is wrong");

    }

    @Test
    public void sqaforums()
    {
        driver.get("https://sqaforums.com");
    }
}
