package com.yancy.model;

/**
 * 账户信息
 * 
 * @author Yancy
 *
 */
public class AccInfo {

	private String userid;
	private String account;
	private double currentDeposit; // 活期
	private double timeDeposit; // 定期
	private double finacialDeposit; // 其他理财金

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

	public double getCurrentDeposit() {
		return currentDeposit;
	}

	public void setCurrentDeposit(double currentDeposit) {
		this.currentDeposit = currentDeposit;
	}

	public double getTimeDeposit() {
		return timeDeposit;
	}

	public void setTimeDeposit(double timeDeposit) {
		this.timeDeposit = timeDeposit;
	}

	public double getFinacialDeposit() {
		return finacialDeposit;
	}

	public void setFinacialDeposit(double finacialDeposit) {
		this.finacialDeposit = finacialDeposit;
	}

	public String toString() {
		return "User: " + this.getAccount() + " " + this.getCurrentDeposit() + " " + this.getFinacialDeposit() + " "
				+ this.getTimeDeposit() + " " + this.getUserid();
	}
}
