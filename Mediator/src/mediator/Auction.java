package mediator;

import java.util.*;


import colleague.Colleague;

public class Auction implements AuctionMediator{
	
	ArrayList<Colleague> colleagues = new ArrayList<>();

	@Override
	public void addBider(Colleague bidder) {
		// TODO Auto-generated method stub
		colleagues.add(bidder);
		
	}

	@Override
	public void placeBid(Colleague bidder, int bidAmounts) {
		// TODO Auto-generated method stub
		for(Colleague collagues:colleagues) {
			
		}
		
		
	}




}
