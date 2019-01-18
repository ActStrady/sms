package com.eos.dao;

import com.eos.entity.Teacher;

import java.util.List;

public interface TeacherDao {

    /**
     * 通过教师编号查找教师
     * @return
     */
    Teacher queryByTeaNum(int teaNum);

    /**
     * 查找全部教师
     * @return
     */
    List<Teacher> queryAll();

    /**
     * 添加教师
     * @param teacher
     * @return
     */
    int addTeacher(Teacher teacher);

    /**
     * 更新教师
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    /**
     * 通过教师编号删除教师
     * @param teaNum
     * @return
     */
    int deleteTeacher(int teaNum);
}
