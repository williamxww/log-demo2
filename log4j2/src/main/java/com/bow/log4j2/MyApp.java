package com.bow.log4j2;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.ThreadContext;

import java.util.UUID;

/**
 * @author vv
 * @since 2017/4/15.
 */
public class MyApp {

    private static Logger logger = LogManager.getLogger(MyApp.class);

    /**
     * 可以单独过滤出打了标记的日志
     */
    private static final Marker SQL_MARKER = MarkerManager.getMarker("SQL");

    private static final Marker UPDATE_MARKER = MarkerManager.getMarker("SQL_UPDATE").setParents(SQL_MARKER);

    private static final Marker QUERY_MARKER = MarkerManager.getMarker("SQL_QUERY").setParents(SQL_MARKER);

    public String doQuery(String table) {
        logger.entry(table);

        logger.debug(QUERY_MARKER, "SELECT * FROM {}", table);

        return logger.exit("name");
    }

    public String doUpdate(String table, String params) {
        logger.entry(params);
        if (logger.isDebugEnabled()) {
            logger.debug(UPDATE_MARKER, "UPDATE {} SET {}", table, "NN");
        }
        return logger.exit("name");
    }

    public static void main(String[] args) {
        // 只有手机号15812345678才会记录日志，其他号码不记录日志
        ThreadContext.put("phoneNumber", "15812345678");
        MyApp app = new MyApp();
        app.doQuery("PERSON");
        app.doUpdate("PERSON", "vv");
        ThreadContext.clearAll();
    }

}
