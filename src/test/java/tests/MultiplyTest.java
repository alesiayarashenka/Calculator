package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MultiplyTest extends BaseTest {
    @DataProvider(name = "positive numbers")
    public Object[][] wholeDoubleNumbersForProduct() {
        return new Object[][]{
                {5, 2, 10},
                {10, 10, 100},
                {1, 0, 0},
                {11.1, 1, 11.1},
                {1.1, 1.2, 1.32},
        };
    }

    @DataProvider(name = "negative number")
    public Object[][] multiplyWithNegativeNumber() {
        return new Object[][]{
                {-2, 2, -4},
                {-2.5, 2.5, -6.25},
                {-2, -2, 4},
                {-1.1, -1.2, 1.32},
        };
    }

    @Test(dataProvider = "positive numbers", priority = 2, description = "product of positive numbers",
            retryAnalyzer = Retry.class)
    public void productWholeIntTest(double x, double y, double z) {
        double a = calculator.multiply(x, y);
        assertThat(a, equalTo(z));
    }

    @Test(dataProvider = "negative number", priority = 1, description = "product of negative numbers",
            retryAnalyzer = Retry.class, groups = "multiply")
    public void minusNegativeNumbersTest(double x, double y, double z) {
        double a = calculator.multiply(x, y);
        assertThat(a, equalTo(z));
    }
}
