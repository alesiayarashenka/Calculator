package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class DivideTest extends BaseTest {
    @DataProvider(name = "whole numbers")
    public Object[][] wholeNumbersForQuotient() {
        return new Object[][]{
                {5, 2},
                {6, 4},
                {7, 6},
                {10, 8},
        };
    }

    @DataProvider(name = "same number")
    public Object[][] multiplyWithZeroNumber() {
        return new Object[][]{
                {1, 1},
                {3, 3},
                {5, 5},
                {7, 7},
        };
    }

    @Test(dataProvider = "whole numbers", priority = 2, description = "quotient of whole numbers",
            retryAnalyzer = Retry.class)
    public void quotientOfWholeIntTest(int x, int y) {
        double a = calculator.divide(x, y);
        assertThat(a, notNullValue());
    }

    @Test(dataProvider = "same number", priority = 1, description = "quotient the same numbers",
            retryAnalyzer = Retry.class)
    public void quotientOfSameNumbersTest(int x, int y) {
        double a = calculator.divide(x, y);
        Assert.assertEquals(a, 1);
    }
}
