package com.bow.log4j2.appender;

import com.bow.log4j2.TestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.plugins.util.PluginManager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author vv
 * @since 2017/7/14.
 */
public class ConfigTest {


    public static void main(String[] args) throws Exception {
        PluginManager.addPackage("com.bow.log4j2.appender");
        File file = new File("log4j2/src/main/java/com/bow/log4j2/appender/appender.xml");
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        final ConfigurationSource source = new ConfigurationSource(in);
        Configurator.initialize(null, source);

        Logger logger = LogManager.getLogger(TestService.class);
        for(int i=0; i<20; i++){
            logger.info("------------------"+ i);
        }


    }
}
