package ru.example.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.example.api.SomeService;
import ru.example.api.SomeServiceFactory;

@Configuration
public class ServiceConfig {

    @Bean
    public SomeService someService() {
        return SomeServiceFactory.instance().getService(ServiceConfig.class.getClassLoader());
    }
}
