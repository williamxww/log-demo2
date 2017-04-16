package com.bow.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vv
 * @since 2017/4/14.
 */
public class LogbackTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void test1() {
        LOGGER.info("test {}", "nice");
    }
}
