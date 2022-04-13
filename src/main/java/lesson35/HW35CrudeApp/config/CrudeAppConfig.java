package lesson35.HW35CrudeApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrudeAppConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(StringUtils.delimitedListToStringArray("https://ITpark.itpark2021/", ",", " "))
                .allowCredentials(true)
                .allowedMethods("GET, POST, PUT, PATCH, DELETE, OPTIONS");
    }
}