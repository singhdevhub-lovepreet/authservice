package authservice;

import authservice.auth.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"authService.repository"})
@ComponentScan(basePackages = {"authService.controller", "authService.auth", "authService.service"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return new SecurityConfig().securityFilterChain(http);
//    }
}
