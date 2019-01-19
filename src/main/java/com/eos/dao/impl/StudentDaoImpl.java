package com.eos.dao.impl;

import java.util.ArrayList;
import java.util.Date;

import com.eos.dao.StudentDao;
import com.eos.entity.Student;
import com.eos.util.JDBCUtil;
import com.eos.util.ResultToObjUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
    private Student student;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private Connection connection;

    @Override
    public Student queryByStuNum(int stuNum) throws SQLException, ClassNotFoundException {

        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from sms.student where stuNum = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, stuNum);
            resultSet = preparedStatement.executeQuery();
            Student student = new Student();
            while (resultSet.next()) {
                student = ResultToObjUtil.changeStu(student, resultSet);
            }

        } catch (SQLException |
                ClassNotFoundException e) {
            logger.error("queryByStuNum", e);
            throw e;
        } finally {
            JDBCUtil.closeConAndPreAndRes(connection, preparedStatement, resultSet);
        }
        logger.debug("queryByStuNum Debug {}", student);
        return student;
    }

    @Override
    public List<Student> queryAll() throws SQLException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from sms.student";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student = ResultToObjUtil.changeStu(student, resultSet);
                students.add(student);
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("queryAll", e);
            throw e;
        }
        return students;
    }

    @Override
    public int addStu(Student student) {
        return 0;
    }

    @Override
    public int updateStu(Student student) {
        return 0;
    }

    @Override
    public int deleteStu(int stuNum) {
        return 0;
    }
}
