package com.pratice;

public class InfoProcessor extends LogProcessor{

	InfoProcessor(LogProcessor loggerProcessor) {
		super(loggerProcessor);
		// TODO Auto-generated constructor stub
	}
	
	public void log(int level,String message) {
		if (level == INFO) {
			System.out.print("INFO:" + message);
		} else {
			 super.log(level, message);
		}
			
	}

}
