package ExtentReportDemos.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForExtentReports {

    public static String takingscreenshot(WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());

        String fileName="image"+timeStamp+".png";

        FileUtils.copyFile(srcFile,new File("Reports\\screenshots\\"+fileName));

        return fileName;
    }

    static ExtentSparkReporter reporter;
    static ExtentReports extent;

    public static ExtentReports initExtentObject()
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

        return extent;
    }
}
