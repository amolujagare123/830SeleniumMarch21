package TestNGDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AddCustomer {
    WebDriver driver;
    @BeforeClass
    public void doLogin()
    {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://stock.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.name("password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void addCustomerTestValidData()
    {

        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();

        String custName = "Monica123";

        WebElement txtName = driver.findElement(By.id("name"));
        txtName.sendKeys(custName);

        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys("abc xyz");

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys("898989");

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys("8987889");

        WebElement btnAdd = driver.findElement(By.name("Submit"));
        btnAdd.click();

        String expected ="[ "+custName+" ] Customer Details Added !";

        String actual="";
        try {
            actual = driver.findElement(By.xpath("//div[contains(@class,'round')]")).getText();
            //div[contains(@class,'confirmation-box')]
            System.out.println("actual="+actual);
        }
        catch (Exception e)
        {
        }

        Assert.assertEquals(actual,expected,"customer is not added");
    }

    @Test
    public void addCustomerTestValidData2()
    {

        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();

        String custName = "Monica125";

        WebElement txtName = driver.findElement(By.id("name"));
        txtName.sendKeys(custName);

        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys("abc xyz");

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys("898989");

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys("8987889");

        WebElement btnAdd = driver.findElement(By.name("Submit"));
        btnAdd.click();

        String expected ="Customer Details Added";
        // sucess message should contain the above string

        String actual="";
        try {
            actual = driver.findElement(By.xpath("//div[contains(@class,'round')]")).getText();
            //div[contains(@class,'confirmation-box')]
            System.out.println("actual="+actual);
        }
        catch (Exception e)
        {
        }

       // how to check whether some string is there in some another string

        boolean result = actual.contains(expected); // true or false value

        Assert.assertTrue(result,"customer is not added / wrong message");

        //Assert.assertEquals(actual,expected,"customer is not added");
    }


    @Test
    public void addCustomerTestDuplicateData()
    {

        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();

        String custName = "Monica123";

        WebElement txtName = driver.findElement(By.id("name"));
        txtName.sendKeys(custName);

        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys("abc xyz");

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys("898989");

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys("8987889");

        WebElement btnAdd = driver.findElement(By.name("Submit"));
        btnAdd.click();

        String expected ="Dublicat Entry. Please Verify";

        String actual="";
        try {
            actual = driver.findElement(By.xpath("//div[contains(@class,'round')]")).getText();
            //div[contains(@class,'confirmation-box')]
            System.out.println("actual="+actual);
        }
        catch (Exception e)
        {
        }

        Assert.assertEquals(actual,expected,"customer is not added");
    }

    @Test
    public void addCustomerTestNoData()
    {

        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();

        String custName = "";

        WebElement txtName = driver.findElement(By.id("name"));
        txtName.sendKeys(custName);

        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys("");

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys("");

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys("");

        WebElement btnAdd = driver.findElement(By.name("Submit"));
        btnAdd.click();

        String expected ="PLEASE ENTER A CUSTOMER NAME";

        String actual="";
        try {
            actual = driver.findElement(By.xpath("//label[@class='error']")).getText();
            //div[contains(@class,'confirmation-box')]
            System.out.println("actual="+actual);
        }
        catch (Exception e)
        {
        }

        Assert.assertEquals(actual,expected,"wrong or no error");
    }

    @Test
    public void addCustomerTest3DigitCont1()
    {

        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();

        String custName = "amol1234";

        WebElement txtName = driver.findElement(By.id("name"));
        txtName.sendKeys(custName);

        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys("");

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys("12");

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys("");

        WebElement btnAdd = driver.findElement(By.name("Submit"));
        btnAdd.click();

        String expected ="PLEASE ENTER AT LEAST 3 CHARACTERS.";

        String actual="";
        try {
            actual = driver.findElement(By.xpath("//label[@for='buyingrate']")).getText();
            //div[contains(@class,'confirmation-box')]
            System.out.println("actual="+actual);
        }
        catch (Exception e)
        {
        }

        Assert.assertEquals(actual,expected,"wrong or no error");
    }


    @Test
    public void addCustomerTestRest()
    {

        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();

        String custName = "Monica123";

        WebElement txtName = driver.findElement(By.id("name"));
        txtName.sendKeys(custName);

        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys("abc xyz");

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys("898989");

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys("8987889");

        WebElement btnReset = driver.findElement(By.name("Reset"));
        btnReset.click();

        ArrayList<String> expectedAllFieldsValues = new ArrayList<>();
            for(int i=0;i<4;i++)
                expectedAllFieldsValues.add("");

        ArrayList<String> actualAllFieldsValues = new ArrayList<>();


        actualAllFieldsValues.add(txtName.getAttribute("value"));
        actualAllFieldsValues.add(txtContact1.getAttribute("value"));
        actualAllFieldsValues.add(txtContact2.getAttribute("value"));
        actualAllFieldsValues.add(txtAddress.getAttribute("value"));


        System.out.println("actualAllFieldsValues="+actualAllFieldsValues);

        System.out.println("expectedAllFieldsValues="+expectedAllFieldsValues);

        Assert.assertEquals(actualAllFieldsValues,expectedAllFieldsValues,
                "all or some field are not reset");

    }
}
