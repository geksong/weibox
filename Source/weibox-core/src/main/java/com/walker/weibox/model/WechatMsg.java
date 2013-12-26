package com.walker.weibox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.walker.weibox.common.BaseModel;

@Entity
@Table(name="wechat_msg")
public class WechatMsg extends BaseModel {
	private static final long serialVersionUID = -2942999831692592447L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="title")
	private String title; //信息标题
	@Column(name="content")
	private String content; //信息内容
	@Column(name="page_img")
	private String pageImg; //封面地址
	@Column(name="out_url")
	private String outUrl; //外部链接地址
	@Column(name="out_time")
	private int outTime; //分发时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPageImg() {
		return pageImg;
	}
	public void setPageImg(String pageImg) {
		this.pageImg = pageImg;
	}
	public String getOutUrl() {
		return outUrl;
	}
	public void setOutUrl(String outUrl) {
		this.outUrl = outUrl;
	}
	public int getOutTime() {
		return outTime;
	}
	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
}
