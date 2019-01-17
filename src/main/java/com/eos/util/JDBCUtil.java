package com.eos.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {

    private final String URL = "jdbc:mysql://192.168.2.129/sms";
    private final String USER = "root";
    private final String PASSWORD = "Root...000";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("JDBCError" + e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("ConnectionCloseError" + e);
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("PreparedStatementCloseError" + e);
                }
            }
        }
        return preparedStatement;
    }
}
