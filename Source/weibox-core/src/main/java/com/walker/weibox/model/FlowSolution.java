package com.walker.weibox.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.walker.weibox.common.BaseModel;

/**
 * 套餐信息
 * @author geksong
 *
 */
@Entity
@Table(name="flow_solution")
public class FlowSolution extends BaseModel {
	private static final long serialVersionUID = -1413597911894749864L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="text_msg_num")
	private int textMsgNum; //该套餐拥有的文本信息条数
	@Column(name="imgtxt_msg_num")
	private int imgtxtMsgNum; //该套餐拥有的图文信息条数
	@Column(name="vadio_msg_num")
	private int vadioMsgNum; //该套餐拥有的语音信息条数
	@Column(name="solution_price")
	private BigDecimal solutionPrice; //套餐购买价格
	@Column(name="solution_discount")
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
