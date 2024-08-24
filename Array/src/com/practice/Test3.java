// Water Bottels

// There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.

// The operation of drinking a full water bottle turns it into an empty bottle.

// Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.



package com.practice;

public class Test3 {

	public static void main(String[] args) {
		
		int numBottles = 9 ;
		int numExchange = 3	;
	
		int  = numBottles;
		
		int bottles = 0;
		
		do {
			full = full + 
		}
	    
	    
	    System.out.print("The answer is : "
	    		+ "" + ans);

	}

}


class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        long int full=numBottles;
        int bottles=0;
        do{
            full=full+(numBottles/numExchange);
            bottles=numBottles%numExchange;
            numBottles=numBottles/numExchange + bottles;
        }
        while(numBottles>=numExchange);
        return full;
    }
};