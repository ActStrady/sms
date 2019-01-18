package com.eos.act;

import com.eos.util.JDBCUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestLocal {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String name;

    // 测试log
    @Test
    public void logbackTest() {
        logger.info("Info级别");
        logger.debug("debug级别");
        logger.error("error级别");
        logger.trace("trace级别");
        logger.warn("warn级别");
    }
    // 测试jdbc
    @Test
    public void JDBCTest() throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtil.getConnection();
        String sql = "create database sms;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        JDBCUtil.closeConAndPre(connection, preparedStatement);
    }
}
