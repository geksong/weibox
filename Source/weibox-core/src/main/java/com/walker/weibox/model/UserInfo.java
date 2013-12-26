package com.walker.weibox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.walker.weibox.common.BaseModel;
/**
 * 行者通行证帐号信息
 * @author geksong
 *
 */
@Entity
@Table(name="user_info")
public class UserInfo extends BaseModel {
	private static final long serialVersionUID = 5008313227819939480L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="user_name")
	private String userName; //行者用户通行证
	@Column(name="user_id")
	private String userId; //行者用户通行证id
	@Column(name="user_password")
	private String userPassword; //行者用户通行证密码
	@Column(name="user_phone")
	private String userPhone; //用户手机
	@Column(name="user_qq")
	private String userQQ; //用户常用QQ
	@Column(name="user_email")
	private String userEmail; //用户常用邮箱
	@Column(name="user_head_img")
	private String userHeadImg; //用户头像图片路径
	@Column(name="user_txt_msg_num")
	private int userTxtMsgNum; //用户剩余文本信息条数
	@Column(name="user_imgtxt_msg_num")
	private int userImgtxtMsgNum; //用户剩余得图文信息条数
	@Column(name="user_vadio_msg_num")
	private int userVadioMsgNum; //用乎剩余的语音信息条数
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserQQ() {
		return userQQ;
	}
	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserHeadImg() {
		return userHeadImg;
	}
	public void setUserHeadImg(String userHeadImg) {
		this.userHeadImg = userHeadImg;
	}
	public int getUserTxtMsgNum() {
		return userTxtMsgNum;
	}
	public void setUserTxtMsgNum(int userTxtMsgNum) {
		this.userTxtMsgNum = userTxtMsgNum;
	}
	public int getUserImgtxtMsgNum() {
		return userImgtxtMsgNum;
	}
	public void setUserImgtxtMsgNum(int userImgtxtMsgNum) {
		this.userImgtxtMsgNum = userImgtxtMsgNum;
	}
	public int getUserVadioMsgNum() {
		return userVadioMsgNum;
	}
	public void setUserVadioMsgNum(int userVadioMsgNum) {
		this.userVadioMsgNum = userVadioMsgNum;
	}
}
