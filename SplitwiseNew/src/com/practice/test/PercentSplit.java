package com.practice.test;

public class PercentSplit extends Split{
	
	private final double percent;
	
    PercentSplit(User user,double percent){
    	super(user);
    	this.percent = percent;
    }
    
    
    @Override
    public double getAmount() {
    	return amount;
    } 
    
    public double getPercent() {
    	return percent;
    }
    

}
