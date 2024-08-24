package com.practice.test;

import java.util.*;
import java.io.*;

import java.util.concurrent.CopyOnWriteArrayList;

public class Group {
	private String id;
	private String name;
	private List<Expense> expenses;
	private List<User> users;
	
	public Group(String id,String name) {
		this.id = id;
		this.name = name;
		this.expenses = new CopyOnWriteArrayList<>();
		this.users = new CopyOnWriteArrayList<>();
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void addExpense(Expense expense) {
		expenses.add(expense);
	}
	
	
	
	
}
