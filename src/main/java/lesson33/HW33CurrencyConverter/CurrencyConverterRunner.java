package lesson33.HW33CurrencyConverter;

import lesson33.HW33CurrencyConverter.service.CurrencyConverterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.Scanner;

//@Configuration
//@ComponentScan
@SpringBootApplication
public class CurrencyConverterRunner {

    public static void main(String[] args) {

//        final AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(CurrencyConverterRunner.class);
//        final CurrencyConverterService cGuide = appContext.getBean(CurrencyConverterService.class);
//
//        System.out.print("Введите валюту: ");
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextInt()) {
//            String number = scanner.next();
//            System.out.println(number + " - вы ввели число, а не название валюты");
//        }
//
//        System.out.print("Введите число: ");
//        Scanner currencyQtty = new Scanner(System.in);
//        while (!currencyQtty.hasNextInt()) {
//            String number = currencyQtty.next();
//            System.out.println(number + " - вы ввели не число");
//        }
//
//        String name = scanner.next().toUpperCase(Locale.ROOT);
//        int qtty = Integer.parseInt(currencyQtty.next());
//        System.out.println(qtty + " " + name + " = " + cGuide.convertCurrency(name, qtty) + " рублей");

        SpringApplication.run(CurrencyConverterRunner.class, args);
    }
}
