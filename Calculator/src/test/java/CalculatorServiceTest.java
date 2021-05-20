import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

public class CalculatorServiceTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("Подготовка перед тестами");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Подчищаем после тестов");
    }

    @DataProvider
    public Object[][] testObjectPositive() {
        return new Object[][]{
                {4, 2, '+', 6},
                {5, 2, '-', 3},
                {8, 5, '*', 40},
                {100, 20, '/', 5}
        };
    }

    @Test(dataProvider = "testObjectPositive")
    public void testEqualsPositive(int one, int two, char operation, int result) {
        Assert.assertEquals(result, CalculatorService.calc(one, two, operation), "Значения не равны");
    }

    @DataProvider
    public Object[][] testObjectNegative() {
        return new Object[][]{
                {4, 2, '+', 8},
                {5, 2, '-', 5},
                {8, 5, '*', 4},
                {100, 20, '/', 50}
        };
    }

    @Test(dataProvider = "testObjectNegative")
    public void testEqualsNegative(int one, int two, char operation, int result) {
        Assert.assertNotEquals(result, CalculatorService.calc(one, two, operation), "Значения равны");
    }

    @DataProvider
    public Object[][] testObjectsEquals() {
        return new Object[][]{
                {2147483647, 1, '+', -2147483648},
                {-2147483648, 1, '-', 2147483647},
                {-1, -1, '-', 0}

        };
    }

    @Test(dataProvider = "testObjectsEquals")
    public void testEqualsResult(int one, int two, char operation, int result) {
        Assert.assertEquals(result, CalculatorService.calc(one, two, operation), "Значения не равны");
    }
}