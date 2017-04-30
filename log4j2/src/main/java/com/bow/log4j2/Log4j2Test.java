package com.bow.log4j2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

    /**
     * spring 使用的commons-logging 依赖log4j 1.x .
     * 因此用log4j2的时候需要增加一个兼容包log4j-1.2-api
     */
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    }
}
