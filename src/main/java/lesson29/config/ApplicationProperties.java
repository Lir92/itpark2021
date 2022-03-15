package lesson29.config;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

//import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Locale;

@Data
@Component // аннотация, определяющая бин
@Validated // данная аннотация совместно с аннотацией @NotNull проверяет наличие значения в поле
@ConfigurationProperties("application") //аннотация, которая обращается к определённым поля в yaml-файле
public class ApplicationProperties {

    @NotNull
    private Integer value;

    private SettingsProperties setting;

    @Data
//    @ConfigurationProperties("settings")
    public static class SettingsProperties {
        private String name;
        private Resource file;
        private Locale locale;
        private List<String> lines;
    }
}
