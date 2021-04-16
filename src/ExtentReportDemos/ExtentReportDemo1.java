package ExtentReportDemos;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static ExtentReportDemos.util.ForExtentReports.takingscreenshot;

public class ExtentReportDemo1 {


    ExtentSparkReporter reporter;
    ExtentReports extent;

    @BeforeClass
    public void init()
    {
        reporter = new ExtentSparkReporter("Reports\\report.html");
        extent = new ExtentReports();

        reporter.config().setReportName("All regression tests");
        reporter.config().setDocumentTitle("Stock management");

        extent.attachReporter(reporter);

        extent.setSystemInfo("Project Name","Stock management");
        extent.setSystemInfo("Tester Name","Visha");
        extent.setSystemInfo("Developers Name","Pooja");
        extent.setSystemInfo("Managers Name","Gowthama");
        extent.setSystemInfo("Due date","30/04/2021");

    }


    @AfterClass
    public void writeToReport()
    {
        extent.flush();
    }


    @Test
    public void validLoginTest() throws IOException {
        ExtentTest test = extent.createTest("validLoginTest");

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        test.info("browser is opened");

        driver.get("http://stock.scriptinglogic.net");

        test.info("url is opened");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.name("password"));
        txtPassword.sendKeys("admin");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        test.info("Login button is clicked");

        String expected = "http://stock.scriptinglogic.net/dashboard.php";
        String actual = driver.getCurrentUrl();

        try {
            Assert.assertEquals(actual, expected, "this is not a correct page");
            test.pass("we are on correct page");
            test.addScreenCaptureFromPath("./screenshots/"+takingscreenshot(driver));

        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+takingscreenshot(driver));
        }

    }

    @Test
    public void invalidLoginTest() throws IOException {
        ExtentTest test = extent.createTest("invalidLoginTest");

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        test.info("browser is opened");

        driver.get("http://stock.scriptinglogic.net");

        test.info("url is opened");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("fdf");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.name("password"));
        txtPassword.sendKeys("fdf");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        test.info("Login button is clicked");

        String expected = "http://stock.scriptinglogic.net/index.php?msg=Wrong%20Username%20or%20Password&type=error";
        String actual = driver.getCurrentUrl();

        try {
            Assert.assertEquals(actual, expected, "this is not a correct page");
            test.pass("we are on correct page");
            test.addScreenCaptureFromPath("./screenshots/"+takingscreenshot(driver));

        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+takingscreenshot(driver));
        }

    }

    @Test
    public void blankLoginTest() throws IOException {
        ExtentTest test = extent.createTest("blankLoginTest");

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        test.info("browser is opened");

        driver.get("http://stock.scriptinglogic.net");

        test.info("url is opened");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.name("password"));
        txtPassword.sendKeys("");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        test.info("Login button is clicked");

        String expected = "http://stock.scriptinglogic.net";
        String actual = driver.getCurrentUrl();

        try {
            Assert.assertEquals(actual, expected, "this is not a correct page");
            test.pass("we are on correct page");
            test.addScreenCaptureFromPath("./screenshots/"+takingscreenshot(driver));

        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+takingscreenshot(driver));
        }

    }




}
