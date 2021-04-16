package ExtentReportDemos.util;

import TestNGDemos.RealDemos.utl.OpenUrl;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static ExtentReportDemos.util.ForExtentReports.initExtentObject;
import static ExtentReportDemos.util.ForExtentReports.takingscreenshot;

public class MyExtentListners extends OpenUrl implements ITestListener {

    static ExtentReports extent;
    ExtentTest test;

    public  void onStart(ITestContext context) // before the test tag
    {
        if(extent==null)
            extent = initExtentObject();
    }


    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {

        test.info(result.getMethod().getMethodName()+":Test is passed");
    }

    public  void onTestFailure(ITestResult result) {
        test.info(result.getMethod().getMethodName()+":Test is failed");
        test.fail(result.getThrowable());

        try {
            test.addScreenCaptureFromPath("./screenshots/"+takingscreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void onTestSkipped(ITestResult result) {

        test.info(result.getMethod().getMethodName()+":Test is skipped");
        test.skip(result.getThrowable());

        try {
            test.addScreenCaptureFromPath("./screenshots/"+takingscreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public  void onFinish(ITestContext context) {

        extent.flush();
    }

}
