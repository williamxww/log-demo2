package com.bow.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author vv
 * @since 2017/4/14.
 */
public class Log4jTest {
    private static final Logger LOGGER = Logger.getLogger(Log4jTest.class);

    @Test
    public void test1(){
        LOGGER.info("test");
    }
}
