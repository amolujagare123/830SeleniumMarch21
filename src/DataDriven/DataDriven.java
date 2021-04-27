package DataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataDriven

{
        @Test(dataProvider = "Data")
        public void Testing1(String user, String pass)
        {
          //  System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://stock.scriptinglogic.net");
            driver.findElement(By.cssSelector("input#login-username")).sendKeys(user);
            driver.findElement(By.cssSelector("input#login-password")).sendKeys(pass);
            driver.findElement(By.cssSelector("input[name=submit]")).click();
        }

        @DataProvider
    public Object[][] Data() throws IOException {

 FileInputStream file= new FileInputStream("data/mydata1.xls");
 HSSFWorkbook workbook= new HSSFWorkbook(file);
 HSSFSheet sheet= workbook.getSheet("Sheet1");
 int rowcount= sheet.getPhysicalNumberOfRows();

         int colcount= sheet.getRow(0).getLastCellNum();
            Object[][] data = new Object[rowcount-1][colcount];
            for(int i=0;i<rowcount-1; i++)
            {
                HSSFRow row= sheet.getRow(i+1);

                for(int j=0; j<colcount;j++){
                    try {

                        data[i][j] = row.getCell(j).toString().trim();
                    }
                    catch(Exception e)
                    {
                        data[i][j] = "";
                    }
                }

            }
            return data;
        }
    }

