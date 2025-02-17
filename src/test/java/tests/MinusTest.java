package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class MinusTest extends BaseTest {
    @DataProvider(name = "whole numbers")
    public Object[][] wholeNumbersForSubtraction() {
        return new Object[][]{
                {5, 2},
                {6, 4},
                {7, 6},
                {10, 8},
        };
    }

    @DataProvider(name = "zero number")
    public Object[][] minusWithZeroNumber() {
        return new Object[][]{
                {1, 0},
                {3, 0},
                {5, 0},
                {7, 0},
        };
    }

    @Test(dataProvider = "whole numbers", priority = 2, description = "subtraction of whole numbers",
            retryAnalyzer = Retry.class)
    public void minusWholeIntTest(int x, int y) {
        double a = calculator.minus(x, y);
        assertThat(a, notNullValue());
    }

    @Test(dataProvider = "zero number", priority = 1, description = "subtraction zero from numbers",
            retryAnalyzer = Retry.class)
    public void minusZeroFromNumbersTest(int x, int y) {
        double a = calculator.minus(x, y);
        Assert.assertEquals(x, a);
    }
}
