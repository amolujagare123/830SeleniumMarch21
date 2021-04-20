package DataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
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

    @Test (dataProvider = "getData")
    public void addCustomerTestValidData(String name,String contact1,
                                         String contact2,String address,
                                         String expected,String xpathActual)
    {

        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();

        WebElement txtName = driver.findElement(By.id("name"));
        txtName.sendKeys(name);

        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys(address);

        int con1 = (int) Double.parseDouble(contact1);

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys(""+con1);

        int con2 = (int) Double.parseDouble(contact2);
        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys(""+con2);

        WebElement btnAdd = driver.findElement(By.name("Submit"));
        btnAdd.click();


        String actual="";
        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
            System.out.println("actual="+actual);
        }
        catch (Exception e)
        {
        }
        Assert.assertEquals(actual,expected,"customer is not added");
    }


    @DataProvider
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("Data/MyDataX.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Add Cutomer");
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();
        System.out.println("colCount="+colCount);

        Object[][] data = new Object[rowCount-1][colCount];

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for(int j=0; j < colCount ; j++ )
                data[i][j] = row.getCell(j).toString().trim();
        }

        return data;
    }

}
