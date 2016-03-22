package com.java.hiveutil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class WriterResultSetHandler implements IResultSetHandler {

    private Writer writer;
    private boolean withHeader;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public WriterResultSetHandler(Writer writer, boolean withHeader) {
        this.writer = writer;
        this.withHeader = withHeader;
    }

    @Override
    public void handle(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int numberOfColumns = rsmd.getColumnCount();
        String lineSeparator = System.getProperty("line.separator");
        try {
            if (withHeader) {
                StringBuilder header = new StringBuilder();
                for (int i = 1; i <= numberOfColumns; i++) {
                    if (i > 1) {
                        header.append("\t");
                    }
                    String columnName = rsmd.getColumnName(i);
                    header.append(columnName);
                }
                writer.write(header.toString());
                writer.write(lineSeparator);
            }
            while (rs.next()) {
                StringBuilder row = new StringBuilder();
                for (int i = 1; i <= numberOfColumns; i++) {
                    if (i > 1) {
                        row.append("\t");
                    }
                    String columnValue = rs.getString(i);
                    if (columnValue != null) {
                        row.append(columnValue);
                    }
                }
                writer.write(row.toString());
                writer.write(lineSeparator);
            }
        } catch (IOException e) {
            logger.error("Failed writing to output stream", e);
            throw new RuntimeException("WriterResultSetHandler problem", e);
        }

    }


}
