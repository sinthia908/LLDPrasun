package com.interview;

import java.util.List;

public class Restuarant {
	
	private int id;
    private String name;
	private String address;
	private List<MenuItems> menuItems;
	
	
	public Restuarant(int id,String name,String address,List<MenuItems> menuItems) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.menuItems = menuItems;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<MenuItems> getMenuItems() {
		return menuItems;
	}


	public void setMenuItems(List<MenuItems> menuItems) {
		this.menuItems = menuItems;
	}

		

}
