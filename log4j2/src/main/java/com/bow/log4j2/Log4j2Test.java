package com.bow.log4j2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vv
 * @since 2017/4/15.
 */
public class Log4j2Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Log4j2Test.class);

    @Test
    public void test1() {
        LOGGER.info("test {}", "nice");
    }
}
