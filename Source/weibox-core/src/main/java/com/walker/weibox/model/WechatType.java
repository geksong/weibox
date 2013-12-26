package com.walker.weibox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.walker.weibox.common.BaseModel;

@Entity
@Table(name="wechat_type")
public class WechatType extends BaseModel{
	private static final long serialVersionUID = 3649435588145082802L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="wechat_type_name")
	private String wechatTypeName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWechatTypeName() {
		return wechatTypeName;
	}
	public void setWechatTypeName(String wechatTypeName) {
		this.wechatTypeName = wechatTypeName;
	}
}
