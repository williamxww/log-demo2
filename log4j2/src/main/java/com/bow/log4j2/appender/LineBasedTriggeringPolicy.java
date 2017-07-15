package com.bow.log4j2.appender;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rolling.RollingFileManager;
import org.apache.logging.log4j.core.appender.rolling.TriggeringPolicy;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.status.StatusLogger;

/**
 * @author vv
 * @since 2017/7/15.
 */
@Plugin(name = "LineBasedTriggeringPolicy", category = "Core", printObject = true)
public class LineBasedTriggeringPolicy implements TriggeringPolicy {
    /**
     * Allow subclasses access to the status logger without creating another
     * instance.
     */
    protected static final Logger LOGGER = StatusLogger.getLogger();

    private int counter = 0;

    private long lastUpdateTime = System.currentTimeMillis();

    /**
     * Rollover threshold size in bytes.
     */
    private static final long MAX_LINE_SIZE = 10 * 1024 * 2; // let 20k line

    private static final int MAX_ELAPSE_TIME = 24 * 60 * 60 * 1000; // 1day

    private final long maxLineSize;

    private final int maxElapsedTime; // in ms

    private RollingFileManager manager;

    /**
     * Constructs a new instance.
     */
    protected LineBasedTriggeringPolicy() {
        this.maxLineSize = MAX_LINE_SIZE;
        maxElapsedTime = MAX_ELAPSE_TIME;
    }

    /**
     * Constructs a new instance.
     *
     * @param maxFileSize rollover threshold size in bytes.
     */
    protected LineBasedTriggeringPolicy(final long maxFileSize, int maxElapsedTime) {
        this.maxLineSize = maxFileSize;
        this.maxElapsedTime = maxElapsedTime;
    }

    /**
     * Initialize the TriggeringPolicy.
     *
     * @param manager The RollingFileManager.
     */
    public void initialize(final RollingFileManager manager) {
        this.manager = manager;
    }

    /**
     * Returns true if a rollover should occur.
     *
     * @param event A reference to the currently event.
     * @return true if a rollover should take place, false otherwise.
     */
    public boolean isTriggeringEvent(final LogEvent event) {
        counter++;
        int cur = counter;
        boolean ret = cur >= maxLineSize;
        if (!ret) {
            long time = System.currentTimeMillis() - lastUpdateTime;
            if (time > maxElapsedTime) {
                ret = true;
            }
        }

        if (ret) {
            counter = 0;
            lastUpdateTime = System.currentTimeMillis();
        }
        return ret;
    }

    @Override
    public String toString() {
        return "SizeBasedTriggeringPolicy(size=" + maxLineSize + ")";
    }

    /**
     * Create a SizeBasedTriggeringPolicy.
     *
     * @param size The size of the file before rollover is required.
     * @return A SizeBasedTriggeringPolicy.
     */
    @PluginFactory
    public static LineBasedTriggeringPolicy createPolicy(@PluginAttribute("size")
    final String size, @PluginAttribute("maxElapsedTime")
    final String maxElapsedTime) {
        final long maxSize = size == null ? MAX_LINE_SIZE : Integer.valueOf(size);
        int time = maxElapsedTime == null ? MAX_ELAPSE_TIME / 1000 : Integer.valueOf(maxElapsedTime);
        return new LineBasedTriggeringPolicy(maxSize, time * 1000);
    }
}
