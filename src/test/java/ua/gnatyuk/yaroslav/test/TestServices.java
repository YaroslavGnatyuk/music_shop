package ua.gnatyuk.yaroslav.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.yaroslav.music_shop.SpringConfig;
import ua.gnatyuk.yaroslav.music_shop.SpringSequrityConfig;

import javax.inject.Inject;

/**
 * Created by yaroslav on 12.05.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class, SpringSequrityConfig.class})
@PropertySource("classpath:config.properties")
public class TestServices {
   @Inject
    Environment environment;

    @Ignore
    @Test
    public void showProperties(){
        System.out.println(environment.getProperty("sqldb.password"));
    }


}
