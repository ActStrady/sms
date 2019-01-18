package com.eos.dao;

import com.eos.entity.Course;

import java.util.List;

public interface CourseDao {

    /**
     * 通过课程id查询课程
     * @param courseId
     * @return
     */
    Course queryByCourseId(int courseId);

    /**
     * 查询所有课程
     * @return
     */
    List<Course> queryAll();

    /**
     * 添加课程
     * @param course
     * @return
     */
    int addCourse(Course course);

    /**
     * 更新课程
     * @param course
     * @return
     */
    int updateCourse(Course course);

    /**
     * 通过课程id删除课程
     * @param courseId
     * @return
     */
    int deleteCourse(int courseId);
}
