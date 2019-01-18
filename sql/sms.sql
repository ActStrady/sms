-- 数据库sms
DROP DATABASE IF EXISTS sms;
CREATE DATABASE sms;
USE sms;

-- 学生表
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
  `stuNum`         int AUTO_INCREMENT PRIMARY KEY COMMENT '学号',
  `stuName`        varchar(255) NOT NULL COMMENT '学生姓名',
  `password`       varchar(255) NOT NULL COMMENT '密码',
  `stuAge`         int(2)       NOT NULL COMMENT '年龄',
  `stuGender`      char(2)      NOT NULL COMMENT '性别',
  `stuPhoneNumber` varchar(255) NOT NULL COMMENT '手机号',
  `stuIDNumber`    varchar(255) NOT NULL COMMENT '身份证号',
  `stuCollege`     varchar(255) NOT NULL COMMENT '院系',
  `stuMajor`       varchar(255) NOT NULL COMMENT '专业',
  `stuClass`       varchar(255) NOT NULL COMMENT '班级',
  `stuRemarks`     varchar(255) COMMENT '备注',
  `createTime`     timestamp             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime`     timestamp COMMENT '修改时间',
  `isDelete`       int          NOT NULL DEFAULT 0 COMMENT '删除标记'
) ENGINE = InnoDB
  AUTO_INCREMENT = 20180201
  DEFAULT CHARSET = utf8 COMMENT '学生表';

-- 教师表
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`
(
  `teaNum`         int          NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '教师编号',
  `teaName`        varchar(255) NOT NULL COMMENT '姓名',
  `password`       varchar(255) NOT NULL COMMENT '密码',
  `teaAge`         int(2)       NOT NULL COMMENT '年龄',
  `teaGender`      char(2)      NOT NULL COMMENT '性别',
  `teaPost`        varchar(255) NOT NULL COMMENT '职务',
  `teaPhoneNumber` varchar(255) NOT NULL COMMENT '手机号',
  `teaIDNumber`    varchar(255) NOT NULL COMMENT '身份证号',
  `teaCollege`     varchar(255) NOT NULL COMMENT '院系',
  `teaMajor`       varchar(255) NOT NULL COMMENT '专业',
  `teaRemarks`     varchar(255) COMMENT '备注',
  `createTime`     timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime`     timestamp COMMENT '更新时间',
  `isDelete`       int       DEFAULT 0 COMMENT '删除标记'
) ENGINE = InnoDB
  AUTO_INCREMENT = 20180101
  DEFAULT CHARSET = utf8 COMMENT '教师表';

-- 管理员表
DROP TABLE IF EXISTS admin;
CREATE TABLE admin
(
  adminId    int                                 NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '管理员编号',
  adminName  varchar(255)                        NOT NULL COMMENT '姓名',
  password   varchar(255)                        NOT NULL COMMENT '密码',
  createTime timestamp default CURRENT_TIMESTAMP null comment '创建时间',
  updateTime timestamp                           null comment '修改时间',
  isDelete   int       default 0                 not null comment '删除标记'
) ENGINE = InnoDB
  AUTO_INCREMENT = 20180001
  DEFAULT CHARSET = utf8 COMMENT '管理员表';

-- 课程表
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`
(
  `courseId`     int          NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '课程id',
  `teaNum`       int          NOT NULL COMMENT '教师编号',
  `courseName`   varchar(255) NOT NULL COMMENT '课程名',
  `courseCredit` int          NOT NULL COMMENT '课程学分',
  `maxNum`       int          NOT NULL COMMENT '最大人数',
  `choseNum`     int COMMENT '已选人数',
  `createTime`   timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime`   timestamp COMMENT '更新时间',
  `isDelete`     int       DEFAULT 0 COMMENT '删除标识',
  constraint course_fk_teaNum
    foreign key (teaNum)
      references teacher (teaNum)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1001
  DEFAULT CHARSET = utf8 COMMENT '课程表';

-- 选课表
DROP TABLE IF EXISTS `cs`;
CREATE TABLE `cs`
(
  `id`         int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '选课id',
  `stuNum`     int NOT NULL COMMENT '学号',
  `courseId`   int NOT NULL COMMENT '课程id',
  `score`      int COMMENT '成绩',
  `createTime` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `isDelete`   int       DEFAULT 0 COMMENT '删除标记',
  constraint cs_fk_stuNum
    foreign key (stuNum)
      references student (stuNum),
  constraint cs_fk_courseId
    foreign key (courseId)
      references course (courseId)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '选课表';



