package lesson26;

import lesson26.impl.CalculatorImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationRunner {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext("lesson26");// контекст будет анализировать только бины из 26 урока

        final Calculator calc = appContext.getBean(Calculator.class);
        System.out.println(calc.sum());

//        CalculatorImpl calculator = new CalculatorImpl(new ArgumentA());
//        System.out.println(calculator.sum());
    }
}