package com.eos.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtil {

    private static final Logger logger = LoggerFactory.getLogger(JDBCUtil.class);
    private static final String DRIVER;
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    private JDBCUtil() {
    }

    // 静态代码块，加载一次避免资源浪费
    static {
        // 读取.properties文件
        Properties properties = new Properties();
        InputStream resource = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc" +
                ".properties");
        try {
            properties.load(resource);
            logger.info("Read jdbc.properties successful!");
        } catch (IOException e) {
            logger.error("Properties read error", e);
        }
        DRIVER = properties.getProperty("driverClass");
        URL = properties.getProperty("jdbcUrl");
        USER = properties.getProperty("user");
        PASSWORD = properties.getProperty("password");
    }

    /**
     * 获取jdbc连接
     *
     * @return connection
     * @throws SQLException           sql获取连接异常
     * @throws ClassNotFoundException 加载驱动时异常
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("GetConnection successful!");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("JDBCConnectionError", e);
            throw e;
        }
        logger.debug("———————————————————————————");
        logger.info("Connection achieve success!");
        return connection;
    }

    /**
     * 关闭连接
     *
     * @param connection 一个连接
     * @throws SQLException sql关闭连接异常
     */
    public static void closeConnection(Connection connection) throws SQLException {
        try {
            connection.close();
            logger.info("CloseConnection successful!");
        } catch (SQLException e) {
            logger.error("closeConnectionError", e);
            throw e;
        }
    }

    /**
     * 关闭预编译器
     *
     * @param preparedStatement 预编译器
     * @throws SQLException sql关闭预编译异常
     */
    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        try {
            preparedStatement.close();
            logger.info("ClosePreparedStatement successful!");
        } catch (SQLException e) {
            logger.error("closePreparedStatement", e);
            throw e;
        }
    }

    /**
     * 关闭结果集
     *
     * @param resultSet 结果集
     * @throws SQLException sql获关闭结果集异常
     */
    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        try {
            resultSet.close();
            logger.info("CloseResultSet successful!");
        } catch (SQLException e) {
            logger.error("closeResultSet", e);
            throw e;
        }
    }

    /**
     * 通过反射机制查询单条记录
     *
     * @param sql
     * @param params
     * @param cls
     * @return
     * @throws Exception
     */
    public static <T> T findSimpleRefResult(String sql, List<Object> params,
                                     Class<T> cls) throws SQLException, IllegalAccessException,
            InstantiationException, NoSuchFieldException {
        T resultObject = null;
        int index = 1;
        preparedStatement = connection.prepareStatement(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setObject(index++, params.get(i));
            }
        }
        resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int cols_len = metaData.getColumnCount();
        if (resultSet.next()) {

            //通过反射机制创建一个实例
            resultObject = cls.newInstance();
            for (int i = 0; i < cols_len; i++) {
                String cols_name = metaData.getColumnName(i + 1);
                Object cols_value = resultSet.getObject(cols_name);
                if (cols_value == null) {
                    cols_value = "";
                }
                Field field = cls.getDeclaredField(cols_name);
                if (field.getType() == int.class) {
                    if (cols_value == "") {
                        cols_value = 0;
                    } else {
                        cols_value = Integer.parseInt(cols_value.toString());
                    }

                }
                field.setAccessible(true); //打开javabean的访问权限
                field.set(resultObject, cols_value);
            }
        }
        return resultObject;

    }

    /**
     * 通过反射机制查询多条记录
     *
     * @param sql
     * @param params
     * @param cls
     * @return
     * @throws Exception
     */
    public <T> List<T> findMoreRefResult(String sql, List<Object> params,
                                         Class<T> cls) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        List<T> list = new ArrayList<T>();
        int index = 1;
        preparedStatement = connection.prepareStatement(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setObject(index++, params.get(i));
            }
        }
        resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int cols_len = metaData.getColumnCount();
        while (resultSet.next()) {
            //通过反射机制创建一个实例
            T resultObject = cls.newInstance();
            for (int i = 0; i < cols_len; i++) {
                String cols_name = metaData.getColumnName(i + 1);
                Object cols_value = resultSet.getObject(cols_name);
                if (cols_value == null) {
                    cols_value = "";
                }
                Field field = cls.getDeclaredField(cols_name);
                if (field.getType() == int.class) {
                    if (cols_value == "") {
                        cols_value = 0;
                    } else {
                        cols_value = Integer.parseInt(cols_value.toString());
                    }

                }
                field.setAccessible(true); //打开javabean的访问权限
                field.set(resultObject, cols_value);
            }
            list.add(resultObject);
        }
        return list;
    }

    /**
     * 关闭连接和预编译
     *
     * @param connection        连接
     * @param preparedStatement 预编译
     * @throws SQLException 关闭连接和预编译异常
     */
    public static void closeConAndPre(Connection connection, PreparedStatement preparedStatement)
            throws SQLException {
        closeConnection(connection);
        closePreparedStatement(preparedStatement);
    }

    public static void closeConAndPreAndRes(Connection connection,
                                            PreparedStatement preparedStatement,
                                            ResultSet resultSet) throws SQLException {
        closeConnection(connection);
        closePreparedStatement(preparedStatement);
        closeResultSet(resultSet);
    }
}
