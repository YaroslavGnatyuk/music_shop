package ua.gnatyuk.yaroslav.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.yaroslav.music_shop.SpringConfig;
import ua.gnatyuk.yaroslav.music_shop.utils.Connection;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Created by yaroslav on 12.05.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
@PropertySource("classpath:config.properties")
public class TestServices {
    @Inject
    Environment environment;

    @Inject
    @Named(value = "ftpUpload")
    Connection connection;

    @Ignore
    @Test
    public void showProperties(){
        System.out.println(environment.getProperty("ftp.user") +" " +
                environment.getProperty("ftp.port") + " " +
                environment.getProperty("ftp.ip") + " " +
                environment.getProperty("ftp.password") );
    }

    @Test
    public void testConnectionToFTP(){
        File file = new File("/home/yaroslav/Pictures/25209763_234371096.jpg");
        assertEquals(connection.isConnect(),true);
//        assertEquals(connection.uploadFile(file,"/img/artist"),true);
    }

}
