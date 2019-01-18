package com.eos.entity;

import lombok.Data;

import java.util.Date;

@Data
public class course {

    private int courseId;

    private int teaNum;

    private String courseName;

    private int courseCredit;

    private int maxNum;

    private int choseNum;

    private Date createTime;

    private Date updateTime;

    private int isDelete;
}
