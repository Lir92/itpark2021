package lesson22;

import lesson21.CalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// ниже способ объединения нескольких тестов в один, что бы прогнать необходимые стесты вместе.
@RunWith(Suite.class)
@Suite.SuiteClasses({AverageServiceTest.class, CalculatorTest.class}) // тут указываются все тест-классы, которые необходимо запустить
public class MathematicsSuite {
}
