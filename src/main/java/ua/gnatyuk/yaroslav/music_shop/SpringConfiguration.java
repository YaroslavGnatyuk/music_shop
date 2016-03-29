package ua.gnatyuk.yaroslav.music_shop;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.gnatyuk.yaroslav.music_shop.app.FillDataBase;

import javax.sql.DataSource;

/**
 * Created by yaroslav on 25.03.16.
 */
@Configuration
@ComponentScan()
@EnableTransactionManagement
public class SpringConfiguration {
    private static final Logger log = LoggerFactory.getLogger(FillDataBase.class);

    @Bean
    public DataSource dataSource() {
        log.info("I'm in datasource");
        final HikariConfig hikariConfig = new HikariConfig();
       /* hikariConfig.setJdbcUrl("jdbc:mysql://178.219.93.93:3306/music_shop_autogen");
        hikariConfig.setUsername("123");
        hikariConfig.setPassword("123");*/

        hikariConfig.setJdbcUrl("jdbc:h2:mem:books_db;DB_CLOSE_DELAY=-1");

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        log.info("I'm in sessionFactory");
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("ua.gnatyuk.yaroslav.music_shop.domain.musicrecord",
                "ua.gnatyuk.yaroslav.music_shop.dao");
        sessionFactory.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));

        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        log.info("I'm in txManager");
        return new HibernateTransactionManager(sessionFactory().getObject());
    }
}