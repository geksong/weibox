-- ---------------------------------
-- weibox init sql script
-- create by geksong
-- contact:zengzhangsong@sina.com
-- ---------------------------------
USE walker_weibox;
-- --------------------
-- drop exists tables
DROP TABLE IF EXISTS user_info;
DROP TABLE IF EXISTS flow_solution;
DROP TABLE IF EXISTS wechat_info;
DROP TABLE IF EXISTS wechat_type;
DROP TABLE IF EXISTS wechat_msg;
-- drop exists tables end
-- ---------------------
-- --------------------
-- create table user_info
CREATE TABLE user_info
(
        id int NOT NULL auto_increment,
        user_name VARCHAR(50),
        user_phone VARCHAR(50),
        user_id VARCHAR(50),
        user_qq VARCHAR(50),
        user_email VARCHAR(255),
        user_head_img VARCHAR(255),
        user_txt_msg_num int,
        user_imgtxt_msg_num int,
        user_vadio_msg_num int,
        user_password VARCHAR(50),
        PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;
-- create table user_info end
-- -----------------------------
-- create table flow_solution
CREATE TABLE flow_solution
(
        id int NOT NULL auto_increment,
        text_msg_num int,
        imgtxt_msg_num int,
        vadio_msg_num VARCHAR(50),
        solution_price DECIMAL(11,2),
        solution_discount int,
        PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;
-- create table flow_solution end
-- ----------------------------------
-- create table wechat_info
CREATE TABLE wechat_info
(
        id int NOT NULL auto_increment,
        wechat_name VARCHAR(50),
        wechat_id VARCHAR(50),
        wechat_passport VARCHAR(50),
        head_img VARCHAR(255),
        interface_url VARCHAR(255),
        interface_token VARCHAR(50),
        service_email VARCHAR(255),
        wechat_type_id int,
        PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;
-- create table wechat_info end
-- ----------------------------------
-- create table wechat_type
CREATE TABLE wechat_type
(
        id int NOT NULL auto_increment,
        wechat_type_name VARCHAR(50),
        PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;
-- create table wechat_type end
-- ------------------------------------
-- create table wechat_msg
CREATE TABLE wechat_msg
(
        id int NOT NULL auto_increment,
        title VARCHAR(50),
        content VARCHAR(255),
        page_img VARCHAR(255),
        out_url VARCHAR(255),
        out_time int,
        PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;