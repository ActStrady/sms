package com.eos.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CS {

    private int id;

    private int stuNum;

    private int courseId;

    private int score;

    private Date createTime;

    private int isDelete;
}
