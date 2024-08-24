package com.interview.doctor;

import java.util.*;

public class Department {
	private int id;
	private String Name;
	private List<Doctor> doctorsList;
    private DepartmentType depType;
    
    
    public Department(int id,String name,DepartmentType depType) {
    	   this.id = id;
    	   this.doctorsList = new ArrayList<Doctor>();
    	   this.depType = depType;
    	
    }
	

}

