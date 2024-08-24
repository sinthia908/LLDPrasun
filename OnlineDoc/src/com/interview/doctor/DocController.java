package com.interview.doctor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


public class DocController {
	
	
	private static DocController instance;
	private final Map<Integer,Doctor> doctors;
	private final Map<Integer,Patient> patients;
	private final Map<Integer,Department> departments;

	
	// Initialize 
	private DocController() {
		
	doctors = new ConcurrentHashMap<>();
	patients =  new ConcurrentHashMap<>();
	departments = new ConcurrentHashMap<>();
	}
	
		
	// Create a single instance of the class 
	public static synchronized DocController getInstance() {
		if (instance == null) {
			instance = new DocController();
		}
		return instance;
	}
	

	// Register a doctor 
	
	public void registerDoc(Doctor doctor) {
		User doc = new Doctor(1788,"Prasun","prasunmazumder@gmail.com",9538672);
		doctors.put(doc.getId(),(Doctor) doc);
		System.out.println("");
		
	}
	
	
	// Register a patient 
	
	
	
	
	
	// Book an appointment 
	
	
	
	// Cancel appoinment 
	
	
	
	
	
	
	
	

}
