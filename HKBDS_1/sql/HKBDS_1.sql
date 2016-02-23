CREATE DATABASE HKBDS_1;
USE HKBDS_1;
#创建管理员表
CREATE TABLE t_admin
(
admin VARCHAR(30) PRIMARY KEY,
pasword VARCHAR(40)

);
INSERT INTO t_admin VALUES('kejiameitian','5264202xz');
#创建公告表
CREATE TABLE t_notice
(
n_id  INT PRIMARY KEY AUTO_INCREMENT,
n_item varchar(50),
notice varchar(100),
n_date varchar(50)
);

#创建留言表
CREATE TABLE t_message
(
m_id  INT PRIMARY KEY AUTO_INCREMENT,
m_name varchar(20),
m_item varchar(50),
m_emil varchar(20),
m_address varchar(50),
m_date varchar(50),
m_message varchar(100)
);

#创建产品表
CREATE TABLE t_product
(
p_id  INT PRIMARY KEY AUTO_INCREMENT,
p_name varchar(20),
p_image varchar(50),
p_content varchar(20),
p_price varchar(50),
p_date varchar(50),
p_category varchar(50)
);