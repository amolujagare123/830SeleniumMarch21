package TestNGDemos.Demos;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassOne {

    @BeforeTest
    public void myBeforeTest()
    {
        System.out.println("myBeforeTest()");
    }

    @AfterTest
    public void myAfterTest()
    {
        System.out.println("myAfterTest()");
    }



    @Test (groups = "email")
    public void ClassOneTest1()
    {
        System.out.println("ClassOneTest1");
    }

    @Test //(enabled = false)
    public void ClassOneTest2()
    {
        System.out.println("ClassOneTest2");
    }

    @Test
    public void ClassOneTest3()
    {
        System.out.println("ClassOneTest3");
    }
}
