package com.pratice;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogProcessor logObject = new InfoProcessor(new DebugProcessor(new ErrorProcessor(null)));
		
		//logObject.log(LogProcessor.ERROR, "exception happens");
	 //   logObject.log(LogProcessor.DEBUG, "need to debug this ");
	      logObject.log(LogProcessor.INFO, "just for info ");
	}

}
