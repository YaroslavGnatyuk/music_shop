package ua.gnatyuk.yaroslav.music_shop;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.WebApplicationContext;
import ua.gnatyuk.yaroslav.music_shop.domain.FillDataBase;
import ua.gnatyuk.yaroslav.music_shop.utils.FtpUpload;

import javax.inject.Inject;
import javax.sql.DataSource;

/**
 * Created by yaroslav on 25.03.16.
 */
@Configuration
@ComponentScan(value = {
        "ua.gnatyuk.yaroslav.music_shop.dao",
        "ua.gnatyuk.yaroslav.music_shop.domain",
        "ua.gnatyuk.yaroslav.music_shop.services.impl",
        "ua.gnatyuk.yaroslav.music_shop.utils"
})
@EnableTransactionManagement
@PropertySource("classpath:config.properties")
public class SpringConfig {
    @Inject
    private Environment env;
    private static final Logger log = LoggerFactory.getLogger(FillDataBase.class);

    @Bean
    public DataSource dataSource() {

        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(env.getProperty("sqldb.url"));
        hikariConfig.setUsername(env.getProperty("sqldb.username"));
        hikariConfig.setPassword(env.getProperty("sqldb.password"));

        /* hikariConfig.setJdbcUrl("jdbc:h2:mem:books_db;DB_CLOSE_DELAY=-1");*/

        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
                "ua.gnatyuk.yaroslav.music_shop.domain.musicrecord"
                ,"ua.gnatyuk.yaroslav.music_shop.domain.user"
                ,"ua.gnatyuk.yaroslav.music_shop.domain.article");
        sessionFactory.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));

        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }

    @Bean(name = "ftpUpload")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public FtpUpload ftpUpload(){
        FtpUpload  ftpUpload = new FtpUpload(
                    env.getProperty("ftp.ip"),
                    env.getProperty("ftp.port"),
                    env.getProperty("ftp.user"),
                    env.getProperty("ftp.password"));

        return ftpUpload;
    }

}