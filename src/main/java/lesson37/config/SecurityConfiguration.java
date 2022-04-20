package lesson37.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity // включение поддержки SpringSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring() // в данном данном методе указываются пути, где указываются пути, которые необходимо игнорировать
                // при запуске аутентификации. К ресурсным файлам доступ не скрывается.
                .antMatchers("/css/**", "/webjars/**", "/images/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception { // данный метод настраивает уровни доступности для адресов
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll() // здесь permitAll() - разрешает доступ к домашней странице.
                // Если домашнюю страницу надо также заблокировать, то этот метод выполнять не надо
                .and()
                .authorizeRequests().antMatchers( //здесь указаны адреса, которые должны быть защищены паролем
                        "/genres", "/genre/**",
                        "/books", "/book/**",
                        "/api/**").authenticated()//также, так как здесь указан "/api/**" - то все адреса имеющие "префикс"
                // api также будут защищены. В контроллерах нет необходимости ничего добавлять отдельно.
                .and()
                .formLogin(); // здесь указан способ аутентификации
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}