package com.eos.dao.impl;

import com.eos.entity.Student;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoImplTest {
    private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);

    @Test
    public void queryByStuNum() throws SQLException, ClassNotFoundException {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        Student student = studentDao.queryByStuNum(20180201);
    }


    @Test
    public void queryAll() throws SQLException, ClassNotFoundException {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.queryAll();
        for (Student student : students) {
            logger.debug("queryAll {}", student);
        }
    }

    @Test
    public void addStu() {
    }

    @Test
    public void updateStu() {
    }

    @Test
    public void deleteStu() {
    }
}