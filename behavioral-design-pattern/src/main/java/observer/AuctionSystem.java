
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;

// Enum to define update types (specific to items)
@Getter
enum ItemType {
	VASE("Antique Vase"), PAINTING("Monet Painting");

	private String itemName;

	private ItemType(String itemName) {
		this.itemName = itemName;
	}
}

// Subject Class
class AuctionItem {

	private double currentBidPrice;
	private ItemType itemType;
	private Map<ItemType, List<Observer1>> observers = new HashMap<>();

	public AuctionItem(double initialBidPrice, ItemType itemType) {
		this.currentBidPrice = initialBidPrice;
		this.itemType = itemType;
		observers.put(itemType, new ArrayList<>()); // Initialize list for this item type
	}

	public double getCurrentBidPrice() {
		return currentBidPrice;
	}

	public ItemType getItemType() {
		return itemType;
	}

	// Register a bidder for this item
	public void registerObserver(ItemType itemType, Observer1 observer) {
		observers.get(itemType).add(observer);
	}

	// Remove a bidder
	public void removeObserver(Observer1 observer) {
		observers.get(itemType).remove(observer);
	}

	// Update bid price and notify relevant bidders
	public void setBidPrice(double newBidPrice) {
		this.currentBidPrice = newBidPrice;
		notifyObservers();
	}

	// Notify only bidders registered for this item type
	private void notifyObservers() {
		for (Observer1 observer : observers.get(this.itemType)) {
			observer.update(this.itemType.getItemName(), this.currentBidPrice);
		}
	}
}

// Observer Interface
interface Observer1 {
	void update(String itemName, double value);
}

// Concrete Observer: Bidder
class Bidder implements Observer1 {
	private String bidderName;
	private double currentBidPrice;

	public Bidder(String bidderName) {
		this.bidderName = bidderName;
	}

	@Override
	public void update(String itemName, double value) {
		this.currentBidPrice = value; // Sync state
		display(itemName, currentBidPrice);
	}

	private void display(String itemName, double value) {
		System.out.println(bidderName + " received update: Current bid for " + itemName + " is $" + currentBidPrice);
	}
}

// Main Class
public class AuctionSystem {
	public static void main(String[] args) {
		// Create auction items (subjects)
		AuctionItem vase = new AuctionItem(100.0, ItemType.VASE);
		AuctionItem painting = new AuctionItem(500.0, ItemType.PAINTING);

		// Create bidders (observers)
		Bidder rahul = new Bidder("Rahul");
		Bidder priya = new Bidder("Priya");
		Bidder amit = new Bidder("Amit");

		// Register bidders to items
		vase.registerObserver(ItemType.VASE, rahul);
		vase.registerObserver(ItemType.VASE, priya);
		painting.registerObserver(ItemType.PAINTING, amit);

		// Initial display
//		System.out.println("Initial bids:");
//		rahul.display();
//		priya.display();
//		amit.display();

		// Update bid price for vase
		System.out.println("\nNew bid for Antique Vase: $150.0");
		vase.setBidPrice(150.0);

		// Update bid price for painting
		System.out.println("\nNew bid for Monet Painting: $600.0");
		painting.setBidPrice(600.0);

		// Another update for vase
		System.out.println("\nNew bid for Antique Vase: $200.0");
		vase.setBidPrice(200.0);

	}
}
