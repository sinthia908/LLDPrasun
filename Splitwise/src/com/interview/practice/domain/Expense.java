package com.interview.practice.domain;

import com.interview.practice.statergy.Split;

import java.util.List;

public abstract class Expense {
    private String id;
    private double amount;
    private User paidBy;
    private List<Split> splitList;
    private ExpenseMetaData expenseMetaData;

    public Expense(double amount,User paidBy,List<Split> splitList,ExpenseMetaData expenseMetaData){
           this.expenseMetaData = expenseMetaData;
           this.amount = amount;
           this.paidBy = paidBy;
           this.splitList = splitList;
           this.expenseMetaData = expenseMetaData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<Split> getSplits() {
        return splitList;
    }

    public void setSplits(List<Split> splitList) {
        this.splitList = splitList;
    }

    public ExpenseMetaData getMetadata() {
        return expenseMetaData;
    }

    public void setMetadata(ExpenseMetaData expenseMetaData) {
        this.expenseMetaData = expenseMetaData ;
    }

    public abstract boolean validate();

}
