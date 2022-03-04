package lesson26.HW26CurrencyGiude;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.Scanner;

@Configuration
@ComponentScan
public class CurrencyGuideRunner {

    public static void main(String[] args) {

        final AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(CurrencyGuideRunner.class);
        final CurrencyGuide cGuide = appContext.getBean(CurrencyGuide.class);

        System.out.print("Введите валюту: ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            String number = scanner.next();
            System.out.println(number + " - вы ввели число, а не название валюты");
        }
        String name = scanner.next().toUpperCase(Locale.ROOT);
        System.out.println(cGuide.getCurrencyByName(name));
    }
}
