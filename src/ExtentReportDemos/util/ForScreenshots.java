package ExtentReportDemos.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForScreenshots {

    public static String takingscreenshot(WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());

        String fileName="image"+timeStamp+".png";

        FileUtils.copyFile(srcFile,new File("Reports\\screenshots\\"+fileName));

        return fileName;
    }
}
