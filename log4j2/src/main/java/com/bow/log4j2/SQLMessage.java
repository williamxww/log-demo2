package com.bow.log4j2;

import org.apache.logging.log4j.message.Message;

import java.util.Map;

/**
 * @author vv
 * @since 2017/4/15.
 */
public class SQLMessage implements Message {
    public enum SQLType {
        UPDATE, QUERY
    };

    private final SQLType type;

    private final String table;

    private final Map<String, String> cols;

    public SQLMessage(SQLType type, String table) {
        this(type, table, null);
    }

    public SQLMessage(SQLType type, String table, Map<String, String> cols) {
        this.type = type;
        this.table = table;
        this.cols = cols;
    }

    public String getFormattedMessage() {
        switch (type) {
        case UPDATE:
            return createUpdateString();
        case QUERY:
            return createQueryString();
        default:
            return null;
        }
    }

    @Override
    public String getFormat() {
        return null;
    }

    public String getMessageFormat() {
        return type + " " + table;
    }

    public Object[] getParameters() {
        return cols.values().toArray();
    }

    @Override
    public Throwable getThrowable() {
        return null;
    }

    private String createUpdateString() {
        return "";
    }

    private String createQueryString() {
        return "";
    }

    private String formatCols(Map<String, String> cols) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : cols.entrySet()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            first = false;
        }
        return sb.toString();
    }
}
