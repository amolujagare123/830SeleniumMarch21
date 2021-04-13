package TestNGDemos.Demos;

import org.testng.annotations.Test;

public class ClassThree {

    @Test (groups = "email")
    public void ClassThreeTest1()
    {
        System.out.println("ClassThreeTest1");
    }
    @Test
    public void ClassThreeTest2()
    {
        System.out.println("ClassThreeTest2");
    }
    @Test
    public void ClassThreeTest3()
    {
        System.out.println("ClassThreeTest3");
    }
}
