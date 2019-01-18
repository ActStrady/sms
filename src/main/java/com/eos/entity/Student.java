package com.eos.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {

    private int stuNum;

    private String stuName;

    private String password;

    private int stuAge;

    private String stuGender;

    private String stuPhoneNumber;

    private String stuIDNumber;

    private String stuCollege;

    private String stuMajor;

    private String stuClass;

    private String stuRemarks;

    private Date createTime;

    private Date updateTime;

    private int isDelete;

}
