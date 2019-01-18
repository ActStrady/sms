package com.eos.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Admin {

    private int adminId;

    private String adminName;

    private String password;

    private Date createTime;

    private Date updateTime;

    private int isDelete;
}
