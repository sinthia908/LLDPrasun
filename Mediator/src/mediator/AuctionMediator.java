package mediator;

import colleague.Colleague;

public interface AuctionMediator {
	
	public void addBider(Colleague bidder);
	
	public void placeBid(Colleague bidder,int bidAmounts);
	

}
