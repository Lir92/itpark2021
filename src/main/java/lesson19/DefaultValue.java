package lesson19;

import java.lang.annotation.*;

@Documented // означает, что пользовательская аннотация может быть задукоментирована и использована, как Java Doc
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)

public @interface DefaultValue {

    String value() default "15"; // аттрибут аннотации

    // ссылочные типы в аннотациях использовать нельзя, только константные выражения (примитивы, строки)
    // В качестве аргумента аннотации также можно передавать только примитивы и строки.
}
