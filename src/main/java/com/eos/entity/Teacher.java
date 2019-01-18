package com.eos.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Teacher {

    private int teaNum;

    private String teaName;

    private String passWord;

    private int teaAge;

    private String teaGender;

    private String teaPost;

    private String teaPhoneNumber;

    private String teaIDNumber;

    private String teaCollege;

    private String teaMajor;

    private String teaRemarks;

    private Date createTime;

    private Date updateTime;

    private int isDelete;
}


