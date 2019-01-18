package com.yancy.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 交易记录信息
 * 
 * @author Yancy
 *
 */
public class TransRecord {

	private String transFlowId; // 交易流水号
	private String userid;
	private String account;
	private Timestamp date;
	private BigDecimal amount;
	private String transType;// 交易类型
	private String transRemark;// 交易备注

	public String getTransFlowId() {
		return transFlowId;
	}

	public void setTransFlowId(String transFlowId) {
		this.transFlowId = transFlowId;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getTransRemark() {
		return transRemark;
	}

	public void setTransRemark(String transRemark) {
		this.transRemark = transRemark;
	}

}
