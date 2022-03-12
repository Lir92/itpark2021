package lesson28;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson28.service.FoodService;
import lesson28.service.PrintService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@SpringBootApplication // аннотация для определения SpringBoot приложения. Данная аннотация наследует другие аннотации
// SpringBoot с конфигурациями.
// @SpringBootApplication наследует @ComponentScan, а это значит, что он автоматически сканирует все классы и ищет бины,
// которые были созданы в нижележащих пакетах. Если необходимо подтянуть, какой-то бин из другого пакета, то необходимо
// вручную прописать аннотацию @ComponentScan и в ней указать откуда брать бин
@ConditionalOnProperty(name = "app.foodService.enabled") // аннотация условия, когда бин должен быть вызван и использован
public class SpringBootRunner {


    public static void main(String[] args) {
        final ConfigurableApplicationContext appContext = SpringApplication.run(SpringBootRunner.class, args);
        FoodService foodService = appContext.getBean(FoodService.class);
        foodService.feed();

        PrintService printService = appContext.getBean(PrintService.class);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
