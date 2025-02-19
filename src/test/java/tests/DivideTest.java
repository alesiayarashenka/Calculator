package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DivideTest extends BaseTest {
    @DataProvider(name = "positive numbers")
    public Object[][] positiveNumbersForQuotient() {
        return new Object[][]{
                {5, 2, 2.5},
                {5, 2.5, 2},
                {2, 5, 0.4},
                {10, 2.5, 4},
        };
    }

    @DataProvider(name = "negative numbers")
    public Object[][] negativeNumbersForQuotient() {
        return new Object[][]{
                {5, -2, -2.5},
                {-5, 2.5, -2},
                {-2, -5, 0.4},
                {10, -2.5, -4},
        };
    }

    @DataProvider(name = "zero for quotient")
    public Object[][] ZeroForQuotient() {
        return new Object[][]{
                {5, 0, 0},
                {-5, 0, 0},
                {-2.5, 0, 0},
                {2.5, 0, 0},
        };
    }

    @Test(dataProvider = "positive numbers", priority = 2, description = "quotient of whole and double positive numbers",
            retryAnalyzer = Retry.class)
    public void quotientOfPositiveIntTest(double x, double y, double z) {
        double a = calculator.divide(x, y);
        assertThat(a, equalTo(z));
    }

    @Test(dataProvider = "negative numbers", priority = 3, description = "quotient of whole and double negative numbers",
            retryAnalyzer = Retry.class)
    public void quotientOfNegativeNumbersTest(double x, double y, double z) {
        double a = calculator.divide(x, y);
        assertThat(a, equalTo(z));
    }

    @Test(dataProvider = "zero for quotient", priority = 1, description = "division by zero", retryAnalyzer = Retry.class)
    public void divisionByZeroTest(double x, double y, double z) {
        double a = calculator.divide(x, y);
        assertThat(a, equalTo(z));
    }
}
