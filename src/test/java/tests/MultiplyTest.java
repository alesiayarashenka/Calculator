package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class MultiplyTest extends BaseTest {
    @DataProvider(name = "whole numbers")
    public Object[][] wholeNumbersForProduct() {
        return new Object[][]{
                {5, 2},
                {6, 4},
                {7, 6},
                {10, 8},
        };
    }

    @DataProvider(name = "zero number")
    public Object[][] multiplyWithZeroNumber() {
        return new Object[][]{
                {1, 0},
                {3, 0},
                {5, 0},
                {7, 0},
        };
    }

    @Test(dataProvider = "whole numbers", priority = 2, description = "product of whole numbers",
            retryAnalyzer = Retry.class)
    public void productWholeIntTest(int x, int y) {
        double a = calculator.multiply(x, y);
        assertThat(a, notNullValue());
    }

    @Test(dataProvider = "zero number", priority = 1, description = "product zero and numbers",
            retryAnalyzer = Retry.class, groups = "multiply")
    public void minusZeroFromNumbersTest(int x, int y) {
        double a = calculator.multiply(x, y);
        Assert.assertEquals(a, 0);
    }
}
