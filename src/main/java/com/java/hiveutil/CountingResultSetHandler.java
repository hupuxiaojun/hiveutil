package com.java.hiveutil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountingResultSetHandler implements IResultSetHandler {

    private int numberOfRows = 0;
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void handle(ResultSet rs) throws SQLException {
        while (rs.next()) {
            numberOfRows++;
        }
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

}
