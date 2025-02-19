package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SumTest extends BaseTest {

    @DataProvider(name = "positive numbers")
    public Object[][] doubleNumbersForSum() {
        return new Object[][]{
                {2, 3, 5},
                {5.2, 6, 11.2},
                {1.1, 0, 1.1},
                {1000, 10, 1010},
                {1, 0, 1}
        };
    }

    @DataProvider(name = "negative numbers")
    public Object[][] negativeNumbersForSum() {
        return new Object[][]{
                {-2, 3, 1},
                {-2, -2, -4},
                {-2.1, 3.1, 1},
                {-2.1, -3.1, -5.2},
                {-1, 0, -1}
        };
    }

    @Test(dataProvider = "positive numbers", priority = 2, description = "addition of whole and double positive numbers",
            retryAnalyzer = Retry.class, groups = "sum")
    public void sumDoubleIntTest(double x, double y, double z) {
        double a = calculator.sum(x, y);
        assertThat(a, equalTo(z));
    }

    @Test(priority = 4, description = "addition of double numbers", retryAnalyzer = Retry.class)
    public void sumTheSameIntTest() {
        double x = 2;
        double y = 2;
        double a = calculator.sum(x, y);
        Assert.assertEquals(a, x * 2);
    }

    @Test(dataProvider = "negative numbers", priority = 1, description = "addition of whole and double negative numbers",
            retryAnalyzer = Retry.class)
    public void sumNegativeIntTest(double x, double y, double z) {
        double a = calculator.sum(x, y);
        assertThat(a, equalTo(z));
    }
}
