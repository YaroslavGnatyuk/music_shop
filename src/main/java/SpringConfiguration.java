import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by yaroslav on 25.03.16.
 */
@Configuration
@ComponentScan
@EnableTransactionManagement
public class SpringConfiguration {

    @Bean
    public DataSource dataSource() {
        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://178.219.93.93:3306/music_shop_autogen");
        hikariConfig.setUsername("123");
        hikariConfig.setPassword("123");
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("ua.gnatyuk.yaroslav.music_shop");
        sessionFactory.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));

        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }
}