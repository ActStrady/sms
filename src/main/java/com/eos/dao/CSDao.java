package com.eos.dao;

import com.eos.entity.CS;

import java.util.List;

public interface CSDao {

    /**
     * 通过学号和课程号查询选课信息
     * @param stdNum
     * @param courseId
     * @return
     */
    CS queryByStuAndCour(int stdNum, int courseId);

    /**
     * 通过课程号查询选课信息
     * @param courseId
     * @return
     */
    List<CS> queryByCour(int courseId);

    /**
     * 通过学号查询选课信息
     * @param courseId
     * @return
     */
    List<CS> queryByStu(int courseId);

    /**
     * 增加选课信息
     * @param cs
     * @return
     */
    int addCS(CS cs);
}
