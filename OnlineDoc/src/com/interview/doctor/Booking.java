package com.interview.doctor;

public class Booking {
	
	private int id;
	private Doctor doctor;
	private Patient patient;
	private Department department;
	
	
	public Booking(int id,Doctor doctor,Patient patient,Department department) {
		   this.id = id;
		   this.doctor = doctor;
		   this.patient = patient;
		   this.department = department;
		
	}
	

}
