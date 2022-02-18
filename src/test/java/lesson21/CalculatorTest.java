package lesson21;

import lesson21.Calculator.CalculatorToTest;
import org.junit.*;

public class CalculatorTest {

    private CalculatorToTest calculator;

    @BeforeClass
    public static void init() {
        System.out.println("Начало выполнения тестов");
    }

    @AfterClass
    public static void destroy() {
        System.out.println("Завершение выполнения тестов");
    }

    @Before
    public void initBeforeTest() {
        calculator = new CalculatorToTest(27,3);
    }

    @After
    public void destroyBeforeTest() {
        calculator = null;
    }

    @Test
    public void shouldCalculateSum() {
        CalculatorToTest calc = new CalculatorToTest(10, 15);
        Assert.assertEquals("Проверка выполнения сумма завершилась некорректно", 25, calc.sum());

        CalculatorToTest calc2 = new CalculatorToTest(-10, 15);
        Assert.assertEquals(5, calc2.sum());

        CalculatorToTest calc3 = new CalculatorToTest(-20, 15);
        Assert.assertEquals(-5, calc3.sum());

        Assert.assertEquals(30, calculator.sum());
    }

    @Test
    public void shouldCalculateDivision() {
        CalculatorToTest cal = new CalculatorToTest(15, 3);
        Assert.assertEquals(5, cal.division());

        CalculatorToTest calc2 = new CalculatorToTest(49, 7);
        Assert.assertEquals(7, calc2.division());

        Assert.assertEquals(9, calculator.division());
    }

    @Test(expected = ArithmeticException.class)
    public void shouldCalculateDivisionByZero() {
        CalculatorToTest calculator = new CalculatorToTest(15, 0);
        calculator.division();
        //Assert.assertEquals(5, calculator.division());

//        try { // так лучше не делать, так как обрабатывает только деление на 0.
//            calculator.division();
//            Assert.fail();
//        } catch (ArithmeticException ae) {
//            Assert.assertTrue(true);
//        }

    }
}
