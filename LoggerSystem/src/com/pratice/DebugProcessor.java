package com.pratice;

public class DebugProcessor extends LogProcessor{

	DebugProcessor(LogProcessor nextLogProcessor) {
		super(nextLogProcessor);
		// TODO Auto-generated constructor stub
	}
	
	public void log(int level,String message) {
	if ( level == DEBUG)
		 System.out.print("DEBUG:" + message);
	else 
		 super.log(level, message);
	}
}
