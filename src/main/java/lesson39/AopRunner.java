package lesson39;

import lesson18.dto.Person;
import lesson39.dao.PersonDao;
//import lesson39.service.PersonService;
import lesson39.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
//@EnableCaching(12) // днная аннотация позволяет влиять на порядок срабатывания аспектов
@SpringBootApplication
public class AopRunner {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(AopRunner.class, args);
        final PersonService dao = applicationContext.getBean(PersonService.class);
        Person block = dao.getByName("Block");
        log.info("Имя персоны {}", dao.getName());
    }
}