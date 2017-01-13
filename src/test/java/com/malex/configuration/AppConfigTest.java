package com.malex.configuration;


import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;


@Profile("test")
@Configuration
@Import(JPAConfigTest.class)
@ComponentScan(basePackages = {"com.malex"})
public class AppConfigTest {

    @Bean
    public PropertyPlaceholderConfigurer propertyConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();

        // MYSQL
        configurer.setLocation(new ClassPathResource("application_mysql.properties"));

        // POSTGRES
//        configurer.setLocation(new ClassPathResource("application_postgres.properties"));
        return configurer;
    }

}
