package com.malex.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Profile("test")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.malex.repository")
public class JPAConfigTest {
    @Value("${data.showsql}")
    private boolean showSql;

    @Value("${data.generateddl}")
    private boolean generateDdl;

    @Value("${data.database}")
    private String database;


    @Value("${data.username}")
    private String username;

    @Value("${data.password}")
    private String password;

    @Value("${data.jdbc.driver}")
    private String driver;

    @Value("${data.jdbc.url}")
    private String url;

    @Value("${data.entity.package}")
    private String packagesToScan;

    @Autowired
    public DataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(driver);
        source.setUsername(username);
        source.setPassword(password);
        source.setUrl(url);
        return source;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(showSql);
        jpaVendorAdapter.setGenerateDdl(generateDdl);
        jpaVendorAdapter.setDatabase(Database.valueOf(database));
        return jpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactory.setPackagesToScan(packagesToScan);
        Properties jpaProperties = new Properties();
        entityManagerFactory.setJpaProperties(jpaProperties);
        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
