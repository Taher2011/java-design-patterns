package observer;

import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import lombok.Getter;

enum AuctionItem {
	ANITIQUE_VASE("Antique Vase"), MONET_PAINTING("Monet Painting");

	private String item;

	private AuctionItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return item;
	}
}

class Auction {

	private int currentBidingPrice;
	private AuctionItem auctionItem;

	Map<AuctionItem, Set<BidderSubscriber>> map = new EnumMap<>(AuctionItem.class);

	public Auction(AuctionItem auctionItems) {
		this.auctionItem = auctionItems;
		map.put(auctionItems, new LinkedHashSet<>());
	}

	public int getCurrentBidingPrice() {
		return currentBidingPrice;
	}

	public void setCurrentBidingPrice(int currentBidingPrice) {
		this.currentBidingPrice = currentBidingPrice;
		notifySubscribers(currentBidingPrice);
	}

	public void registerSubscribers(BidderSubscriber bidder) {
		Set<BidderSubscriber> bidders = map.get(this.auctionItem);
		bidders.add(bidder);
		map.put(auctionItem, bidders);
	}

	public void deregisterSubscribers(BidderSubscriber bidder) {
		Set<BidderSubscriber> bidders = map.get(this.auctionItem);
		bidders.remove(bidder);
		map.put(auctionItem, bidders);
	}

	public void notifySubscribers(int currentBidingPrice) {
		Set<BidderSubscriber> bidders = map.get(this.auctionItem);
		for (BidderSubscriber bidderSubscriber : bidders) {
			bidderSubscriber.update(this.auctionItem.toString(), currentBidingPrice);
		}
	}

}

interface BidderSubscriber {

	void update(String auctionItem, int price);
}

@Getter
class Bidder implements BidderSubscriber {

	private String bidderName;

	public Bidder(String bidderName) {
		this.bidderName = bidderName;
	}

	@Override
	public void update(String auctionItem, int price) {
		System.out
				.println(bidderName + " received update: Current bid for " + auctionItem.toString() + " is $" + price);
	}
}

public class AuctionClient {

	public static void main(String[] args) {

		Auction antiqueVase = new Auction(AuctionItem.ANITIQUE_VASE);
		Auction monetPainting = new Auction(AuctionItem.MONET_PAINTING);

		BidderSubscriber rahulBidder = new Bidder("Rahul");
		BidderSubscriber priyaBidder = new Bidder("Priya");
		BidderSubscriber amitBidder = new Bidder("Amit");

		antiqueVase.registerSubscribers(rahulBidder);
		antiqueVase.registerSubscribers(priyaBidder);
		monetPainting.registerSubscribers(amitBidder);

		System.out.println("New bid for Antique Vase: $150.0");
		antiqueVase.setCurrentBidingPrice(150);

		System.out.println("\nNew bid for Monet Painting: $600.0");
		monetPainting.setCurrentBidingPrice(600);

		System.out.println("\nNew bid for Antique Vase: $200.0");
		antiqueVase.setCurrentBidingPrice(200);

		antiqueVase.deregisterSubscribers(priyaBidder);
		System.out.println("\nNew bid for Antique Vase: $400.0");
		antiqueVase.setCurrentBidingPrice(200);
	}
}
