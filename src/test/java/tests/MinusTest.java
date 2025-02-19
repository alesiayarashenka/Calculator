package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MinusTest extends BaseTest {
    @DataProvider(name = "positive numbers")
    public Object[][] positiveNumbersForSubtraction() {
        return new Object[][]{
                {5, 2, 3},
                {6.5, 4, 2.5},
                {7.1, 6.1, 1},
                {7.1, 0, 7.1},
                {10, 0, 10},
                {7.5, 6.2, 1.3},
                {3, 4, -1},
                {3.5, 4, -0.5},
        };
    }

    @DataProvider(name = "negative numbers")
    public Object[][] negativeNumbersForSubtraction() {
        return new Object[][]{
                {-5, 2, -7},
                {-6.5, 4, -10.5},
                {-7.1, 6.1, -13.2},
                {-7.1, 0, -7.1},
                {-10, 0, -10},
                {-7.5, -6.2, -1.3},
                {-3, -4, 1},
        };
    }

    @Test(dataProvider = "positive numbers", priority = 2, description = "subtraction of whole and double positive numbers",
            retryAnalyzer = Retry.class)
    public void minusWholeIntTest(double x, double y, double z) {
        double a = calculator.minus(x, y);
        assertThat(a, equalTo(z));
    }

    @Test(dataProvider = "negative numbers", priority = 1, description = "subtraction of whole and double negative numbers",
            retryAnalyzer = Retry.class)
    public void minusZeroFromNumbersTest(double x, double y, double z) {
        double a = calculator.minus(x, y);
        assertThat(a, equalTo(z));
    }
}
