package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class SumTest extends BaseTest {

    @DataProvider(name = "whole numbers")
    public Object[][] wholeNumbersForSum() {
        return new Object[][]{
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8},
        };
    }

    @DataProvider(name = "zero number")
    public Object[][] sumWithZeroNumber() {
        return new Object[][]{
                {1, 0},
                {3, 0},
                {5, 0},
                {7, 0},
        };
    }

    @Test(dataProvider = "whole numbers", priority = 2, description = "addition of whole numbers",
            retryAnalyzer = Retry.class, groups = "sum")
    public void sumWholeIntTest(int x, int y) {
        double a = calculator.sum(x, y);
        assertThat(a, notNullValue());
    }

    @Test(priority = 4, description = "addition of double numbers",
            retryAnalyzer = Retry.class)
    public void sumDoubleIntTest() {
        double x = 12.0;
        double y = 13.4;
        double a = calculator.sum(x, y);
        Assert.assertEquals(a, 25.4);
    }

    @Test(priority = 1, description = "addition of double numbers",
            retryAnalyzer = Retry.class)
    public void sumTheSameIntTest() {
        double x = 2;
        double y = 2;
        double a = calculator.sum(x, y);
        Assert.assertEquals(a, x * 2);
    }

    @Test(dataProvider = "zero number", priority = 3, description = "addition zero to numbers",
            retryAnalyzer = Retry.class)
    public void sumZeroWithNumbersTest(int x, int y) {
        double a = calculator.sum(x, y);
        Assert.assertEquals(x, a);
    }
}
