package com.walker.weibox.model;

import java.math.BigDecimal;

import com.walker.weibox.common.BaseModel;

public class FlowSolution extends BaseModel {
	private static final long serialVersionUID = -1413597911894749864L;
	private int id;
	private int textMsgNum; //该套餐拥有的文本信息条数
	private int imgtxtMsgNum; //该套餐拥有的图文信息条数
	private int vadioMsgNum; //该套餐拥有的语音信息条数
	private BigDecimal solutionPrice; //套餐购买价格
	private int solutionDiscount; //套餐折扣
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTextMsgNum() {
		return textMsgNum;
	}
	public void setTextMsgNum(int textMsgNum) {
		this.textMsgNum = textMsgNum;
	}
	public int getImgtxtMsgNum() {
		return imgtxtMsgNum;
	}
	public void setImgtxtMsgNum(int imgtxtMsgNum) {
		this.imgtxtMsgNum = imgtxtMsgNum;
	}
	public int getVadioMsgNum() {
		return vadioMsgNum;
	}
	public void setVadioMsgNum(int vadioMsgNum) {
		this.vadioMsgNum = vadioMsgNum;
	}
	public BigDecimal getSolutionPrice() {
		return solutionPrice;
	}
	public void setSolutionPrice(BigDecimal solutionPrice) {
		this.solutionPrice = solutionPrice;
	}
	public int getSolutionDiscount() {
		return solutionDiscount;
	}
	public void setSolutionDiscount(int solutionDiscount) {
		this.solutionDiscount = solutionDiscount;
	}
}
