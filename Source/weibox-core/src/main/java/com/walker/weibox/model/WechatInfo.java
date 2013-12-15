package com.walker.weibox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.walker.weibox.common.BaseModel;

@Entity
@Table(name="wechat_info")
public class WechatInfo extends BaseModel {
	private static final long serialVersionUID = -6132303801045471343L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="wechat_name")
	private String wechatName; //微信公众帐号名称
	@Column(name="wechat_id")
	private String wechatId; //微信公众帐号原始id，是在腾讯公司的微信帐号原始id，可在微信公众帐号的后台看到
	@Column(name="wechat_passport")
	private String wechatPassport; //微信公众帐号
	@Column(name="head_img")
	private String headImg; //公众帐号头像地址
	@Column(name="interface_url")
	private String interfaceUrl; //公众帐号服务接口地址
	@Column(name="interface_token")
	private String interfaceToken; //公众帐号服务接口验证key
	@Column(name="service_email")
	private String serviceEmail; //服务邮箱
	@ManyToOne
	@JoinColumn(name="wechat_type_id")
	private WechatType wechatType; //公众帐号类型
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWechatName() {
		return wechatName;
	}
	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}
	public String getWechatId() {
		return wechatId;
	}
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
	public String getWechatPassport() {
		return wechatPassport;
	}
	public void setWechatPassport(String wechatPassport) {
		this.wechatPassport = wechatPassport;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getInterfaceUrl() {
		return interfaceUrl;
	}
	public void setInterfaceUrl(String interfaceUrl) {
		this.interfaceUrl = interfaceUrl;
	}
	public String getInterfaceToken() {
		return interfaceToken;
	}
	public void setInterfaceToken(String interfaceToken) {
		this.interfaceToken = interfaceToken;
	}
	public String getServiceEmail() {
		return serviceEmail;
	}
	public void setServiceEmail(String serviceEmail) {
		this.serviceEmail = serviceEmail;
	}
	public WechatType getWechatType() {
		return wechatType;
	}
	public void setWechatType(WechatType wechatType) {
		this.wechatType = wechatType;
	}
}
