package com.pratice;

public class ErrorProcessor extends LogProcessor{

	ErrorProcessor(LogProcessor loggerProcessor) {
		super(loggerProcessor);
		// TODO Auto-generated constructor stub
	}
	

	public void log(int level,String message) {
	if ( level == ERROR)
		 System.out.print("ERROR:" + message);
	else 
		 super.log(level, message);
	}

}
