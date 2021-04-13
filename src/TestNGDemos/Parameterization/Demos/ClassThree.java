package TestNGDemos.Parameterization.Demos;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassThree {

    @Parameters("myUrl")
    @Test
    public void ClassThreeTest1(String u)
    {
        System.out.println("url="+u);
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
