package lesson33;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CalculatorWebRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(CalculatorWebRunner.class, args);
    }
}
