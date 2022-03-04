package lesson26.impl;

import lesson26.ArgumentA;
import lesson26.ArgumentB;
import lesson26.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//("superCalculator" /*в скобках можно давать имя, что бы потом иметь возможность получить доступ к этому классу, через аннотацию*/)
// @Component - аннотация бина. Все объекты в данном классе будут считаться Спрингом бинами.
@RequiredArgsConstructor
public class CalculatorImpl implements Calculator {

    private final ArgumentA argumentA;
    private final ArgumentB argumentB;

//    @Autowired // также контекстная аннотация для Спринга. Данная аннотация помогает Спрингу определить что именно использовать.
//    // также можно в этом же классе создать свой конструктор, который нами будет использоваться для инициализации объектов.
//    public CalculatorImpl(ArgumentA argumentA, ArgumentB argumentB) {
//        this.argumentA = argumentA;
//        this.argumentB = argumentB;
//    }
//
//    public CalculatorImpl (ArgumentA argA) {
//        this.argumentA = argA;
//        this.argumentB = new ArgumentB();
//    }



    @Override
    public int sum() {
        return argumentA.getValue() + argumentB.getValue();
    }

    @Override
    public int devide() {
        return argumentA.getValue() / argumentB.getValue();
    }
}
