package lesson27.config;

import lombok.SneakyThrows;
import org.json.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

@Configuration
@ComponentScan("lesson27")
@PropertySource("classpath:db.properties") // данная аннотация заменяет код с Properties.
public class AppConfig {

//    private Properties properties;
//
//    public AppConfig() throws Exception {
//        this.properties = new Properties();
//        this.properties.load(AppConfig.class.getResourceAsStream("/db.properties"));
//    }
//
//    @Bean
//    @SneakyThrows
//    Connection connection() {
//        return DriverManager.getConnection(properties.getProperty("jdbc.url"),
//                properties.getProperty("db.login"), properties.getProperty("db.password"));
//    }


    @Scope("prototype") // пример того, как делать разные объекты из бинов. Значение "prototype" означает, что каждый раз будет создаваться новый объект.
    @Bean(destroyMethod = "close") // destroyMethod - метод, который даёт возможность автоматически закрывать соединение. Альтернативой является аннотация @PreDestroy
    @SneakyThrows
    Connection connection(@Value("${jdbc.url}") String jdbcUrl, // аннотация Spring @Value осуществляет подключение совместно с аннотацией @PropertySource.
                          @Value("${db.login}") String login, // данные аннотации дают возможность не писать блок с Properties и Connection.
                          @Value("${db.password}") String password) { // данные в фигурных скобках указываются те, которые прописаны в properties-файле.
        return DriverManager.getConnection(jdbcUrl, login, password);
    }
}
