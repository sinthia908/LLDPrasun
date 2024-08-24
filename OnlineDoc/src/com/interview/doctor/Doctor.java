package com.interview.doctor;

import java.util.*;

public class Doctor extends User{
	
    private List<Slot> slots;
	Doctor(int id,String name,String email,int mobileNumber){
		super(id,name,email,mobileNumber);
		slots = new ArrayList<>();
	}

	
	public List<Slot> getSlots() {
	        return slots;
	    }

	  
	  
}
