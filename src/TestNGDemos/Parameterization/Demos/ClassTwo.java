package TestNGDemos.Parameterization.Demos;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassTwo {

    @BeforeSuite
    public void myBeforeSuite()
    {
        System.out.println("myBeforeSuite()");
    }

    @AfterSuite
    public void myAfterSuite()
    {
        System.out.println("myAfterSuite()");
    }

    @Parameters("myUrl")
    @Test
    public void ClassTwoTest1(String u)
    {
        System.out.println("url="+u);
        System.out.println("ClassTwoTest1");
    }
    @Test
    public void ClassTwoTest2()
    {
        System.out.println("ClassTwoTest2");
    }
    @Test
    public void ClassTwoTest3()
    {
        System.out.println("ClassTwoTest3");
    }
}
