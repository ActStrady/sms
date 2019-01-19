package com.eos.util;

import com.eos.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultToObjUtil {


    /**
     * ResultSet 转换Student
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    public static Student changeStu(Student student, ResultSet resultSet) throws SQLException {
        student.setStuNum(resultSet.getInt("stuNum"));
        student.setStuName(resultSet.getString("stuName"));
        student.setPassword(resultSet.getString("password"));
        student.setStuAge(resultSet.getInt("stuAge"));
        student.setStuGender(resultSet.getString("stuGender"));
        student.setStuPhoneNumber(resultSet.getString("stuPhoneNumber"));
        student.setStuIDNumber(resultSet.getString("stuIDNumber"));
        student.setStuCollege(resultSet.getString("stuCollege"));
        student.setStuMajor(resultSet.getString("stuMajor"));
        student.setStuClass(resultSet.getString("stuClass"));
        student.setStuRemarks(resultSet.getString("stuRemarks"));
        student.setCreateTime(resultSet.getTimestamp("createTime"));
        student.setUpdateTime(resultSet.getTimestamp("updateTime"));
        student.setIsDelete(resultSet.getInt("isDelete"));
        return student;
    }
}
