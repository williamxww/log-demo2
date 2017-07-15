package com.bow.log4j2.appender;

import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConfigurationFactoryData;
import org.apache.logging.log4j.core.appender.ManagerFactory;
import org.apache.logging.log4j.core.appender.rolling.RollingFileManager;
import org.apache.logging.log4j.core.appender.rolling.RolloverStrategy;
import org.apache.logging.log4j.core.appender.rolling.TriggeringPolicy;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.util.Constants;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

public class ArchiveRollingFileManager extends RollingFileManager {


    private static ArchiveRollingFileManagerFactory factory = new ArchiveRollingFileManagerFactory();

    protected ArchiveRollingFileManager(final LoggerContext loggerContext, final String fileName, final String pattern, final OutputStream os,
                                 final boolean append, final boolean createOnDemand, final long size, final long time,
                                 final TriggeringPolicy triggeringPolicy, final RolloverStrategy rolloverStrategy,
                                 final String advertiseURI, final Layout<? extends Serializable> layout, final boolean writeHeader, final ByteBuffer buffer) {
        super(loggerContext, fileName,pattern, os, append, createOnDemand,size,time,triggeringPolicy,rolloverStrategy, advertiseURI, layout, writeHeader, buffer);
    }

    /**
     * Returns a RollingFileManager.
     * @param fileName The file name.
     * @param pattern The pattern for rolling file.
     * @param append true if the file should be appended to.
     * @param bufferedIO true if data should be buffered.
     * @param policy The TriggeringPolicy.
     * @param strategy The RolloverStrategy.
     * @param advertiseURI the URI to use when advertising the file
     * @param layout The Layout.
     * @param bufferSize buffer size to use if bufferedIO is true
     * @param immediateFlush flush on every write or not
     * @param createOnDemand true if you want to lazy-create the file (a.k.a. on-demand.)
     * @param configuration The configuration.
     * @return A RollingFileManager.
     */
    public static ArchiveRollingFileManager getFileManager(final String fileName, final String pattern, final boolean append,
                                                    final boolean bufferedIO, final TriggeringPolicy policy, final RolloverStrategy strategy,
                                                    final String advertiseURI, final Layout<? extends Serializable> layout, final int bufferSize,
                                                    final boolean immediateFlush, final boolean createOnDemand, final Configuration configuration) {

        return (ArchiveRollingFileManager) getManager(fileName, new FactoryData(pattern, append,
                bufferedIO, policy, strategy, advertiseURI, layout, bufferSize, immediateFlush, createOnDemand, configuration), factory);
    }

    private static OutputStream getOutputStream(String name, boolean append, int bufferSize) throws IOException {
        OutputStream os = new FileOutputStream(name, append);

        if (bufferSize > 0) {
            os = new BufferedOutputStream(os, bufferSize);
        }

        if (name.endsWith(".gz")) {
            os = new GZIPOutputStream(os);
        } else if (name.endsWith(".zip")) {
            os = new ZipOutputStream(os);
        }

        return os;
    }

    protected void createFileAfterRollover() throws IOException {
        final OutputStream os = getOutputStream(getFileName(), isAppend(), getBufferSize());
        setOutputStream(os);
    }

    /**
     * Factory data.
     */
    private static class FactoryData extends ConfigurationFactoryData {
        private final String pattern;
        private final boolean append;
        private final boolean bufferedIO;
        private final int bufferSize;
        private final boolean immediateFlush;
        private final boolean createOnDemand;
        private final TriggeringPolicy policy;
        private final RolloverStrategy strategy;
        private final String advertiseURI;
        private final Layout<? extends Serializable> layout;

        /**
         * Creates the data for the factory.
         * @param pattern The pattern.
         * @param append The append flag.
         * @param bufferedIO The bufferedIO flag.
         * @param advertiseURI
         * @param layout The Layout.
         * @param bufferSize the buffer size
         * @param immediateFlush flush on every write or not
         * @param createOnDemand true if you want to lazy-create the file (a.k.a. on-demand.)
         * @param configuration The configuration
         */
        public FactoryData(final String pattern, final boolean append, final boolean bufferedIO,
                           final TriggeringPolicy policy, final RolloverStrategy strategy, final String advertiseURI,
                           final Layout<? extends Serializable> layout, final int bufferSize, final boolean immediateFlush,
                           final boolean createOnDemand, final Configuration configuration) {
            super(configuration);
            this.pattern = pattern;
            this.append = append;
            this.bufferedIO = bufferedIO;
            this.bufferSize = bufferSize;
            this.policy = policy;
            this.strategy = strategy;
            this.advertiseURI = advertiseURI;
            this.layout = layout;
            this.immediateFlush = immediateFlush;
            this.createOnDemand = createOnDemand;
        }

        public TriggeringPolicy getTriggeringPolicy()
        {
            return this.policy;
        }

        public RolloverStrategy getRolloverStrategy()
        {
            return this.strategy;
        }

        @Override
        public String toString() {
            final StringBuilder builder = new StringBuilder();
            builder.append(super.toString());
            builder.append("[pattern=");
            builder.append(pattern);
            builder.append(", append=");
            builder.append(append);
            builder.append(", bufferedIO=");
            builder.append(bufferedIO);
            builder.append(", bufferSize=");
            builder.append(bufferSize);
            builder.append(", policy=");
            builder.append(policy);
            builder.append(", strategy=");
            builder.append(strategy);
            builder.append(", advertiseURI=");
            builder.append(advertiseURI);
            builder.append(", layout=");
            builder.append(layout);
            builder.append("]");
            return builder.toString();
        }
    }


    /**
     * Factory to create a RollingFileManager.
     */
    private static class ArchiveRollingFileManagerFactory implements ManagerFactory<ArchiveRollingFileManager, FactoryData> {

        /**
         * Creates a RollingFileManager.
         * @param name The name of the entity to manage.
         * @param data The data required to create the entity.
         * @return a RollingFileManager.
         */
        @Override
        public ArchiveRollingFileManager createManager(final String name, final FactoryData data) {
            final File file = new File(name);
            final File parent = file.getParentFile();
            if (null != parent && !parent.exists()) {
                parent.mkdirs();
            }
            // LOG4J2-1140: check writeHeader before creating the file
            final boolean writeHeader = !data.append || !file.exists();
            try {
                final boolean created = data.createOnDemand ? false : file.createNewFile();
                LOGGER.trace("New file '{}' created = {}", name, created);
            } catch (final IOException ioe) {
                LOGGER.error("Unable to create file " + name, ioe);
                return null;
            }
            final long size = data.append ? file.length() : 0;

            try {
                final int actualSize = data.bufferedIO ? data.bufferSize : Constants.ENCODER_BYTE_BUFFER_SIZE;
                final ByteBuffer buffer = ByteBuffer.wrap(new byte[actualSize]);
                final OutputStream os = data.createOnDemand ? null : new FileOutputStream(name, data.append);
                final long time = data.createOnDemand? System.currentTimeMillis() : file.lastModified(); // LOG4J2-531 create file first so time has valid value

                return new ArchiveRollingFileManager(data.getLoggerContext(), name, data.pattern, os,
                        data.append, data.createOnDemand, size, time, data.policy, data.strategy, data.advertiseURI,
                        data.layout, writeHeader, buffer);
            } catch (final IOException ex) {
                LOGGER.error("RollingFileManager (" + name + ") " + ex, ex);
            }
            return null;
        }
    }


}
