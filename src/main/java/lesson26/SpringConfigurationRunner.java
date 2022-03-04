package lesson26;

import lesson26.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigurationRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        final Calculator superCalculator = (Calculator) appContext.getBean("superCalculator"); // получаем доступ по переопределённому
//        имени класса в аннотации @Component
        final Calculator superCalculator = (Calculator) appContext.getBean("calculatorImpl"); // получить доступ к классу
        // можно по имени класса, только первая буква должна будет маленькой: CalculatorImpl -> "calculatorImpl"
        System.out.println(superCalculator.sum());
    }
}
