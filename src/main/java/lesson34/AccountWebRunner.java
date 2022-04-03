package lesson34;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AccountWebRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(AccountWebRunner.class, args);
    }
}
