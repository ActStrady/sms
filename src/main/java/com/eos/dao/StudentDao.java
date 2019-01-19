package com.eos.dao;

import com.eos.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

    /**
     * 通过学号查学生
     * @param stuNum
     * @return
     */
    Student queryByStuNum(int stuNum) throws SQLException, ClassNotFoundException;

    /**
     * 查询所有学生
     * @return
     */
    List<Student> queryAll() throws SQLException, ClassNotFoundException;

    /**
     * 插入学生
     * @param student
     * @return
     */
    int addStu(Student student);

    /**
     * 更新学生
     * @param student
     * @return
     */
    int updateStu(Student student);

    /**
     * 通过学号删除学生
     * @param stuNum
     * @return
     */
    int deleteStu(int stuNum);
}
