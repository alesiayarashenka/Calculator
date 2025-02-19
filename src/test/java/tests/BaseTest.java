package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners(TestListener.class)
public class BaseTest{

    Calculator calculator;

    @BeforeMethod
    public void initTest(){
        calculator = new Calculator();
        System.out.println("Test is starting");
    }

    @AfterMethod
    public void endTest(){
        System.out.println("Test ended");
    }
}
