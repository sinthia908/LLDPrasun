package com.practice;

public class PercentSplit extends Split{
	private double percent;
	public PercentSplit(User user,double percent) {
		super(user);
		this.amount = amount;
	}
	
	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}
	

}
