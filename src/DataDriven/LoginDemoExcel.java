package DataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class LoginDemoExcel {


    @Test (dataProvider = "getData")
    public void myLoginTest1(String user ,String pass)
    {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://stock.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.cssSelector("input#login-username")); // using id

        txtUsername.sendKeys(user);

        WebElement txtPassword = driver.findElement(By.cssSelector("input#login-password"));
        txtPassword.sendKeys(pass);

        WebElement btnLogin = driver.findElement(By.cssSelector("input.button"));
        btnLogin.click();
    }


       @DataProvider
       public  Object[][]  getData() throws IOException {
       //1.  Read the file :
       FileInputStream fis = new FileInputStream("Data/MyData.xls");

       //2.  Convert file object into workbook object
       HSSFWorkbook workbook = new  HSSFWorkbook(fis);

        // 3. Identify the sheet name & create sheet object
        HSSFSheet sheet = workbook.getSheet("all login data");

        // 4. count the number of active rows in the sheet
        int rowCount = sheet.getPhysicalNumberOfRows(); // 5

        Object[][] data = new Object[rowCount][2];

         // 5. traverse the rows
           for(int i=0;i<rowCount;i++)
           {
               HSSFRow row = sheet.getRow(i);

               data[i][0] = row.getCell(0).toString().trim();
               data[i][1] = row.getCell(1).toString().trim();
           }
/*
           data[0][0] ="admin"; // user
           data[0][1] ="admin"; // pass

           data[1][0] ="wewewe";
           data[1][1] ="uyuyu";

           data[2][0] ="";
           data[2][1] ="";*/

           return  data;
       }


}
