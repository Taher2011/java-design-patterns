package observer;

import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import lombok.Getter;

enum StockAttribute {
	PRICE("price"), VOLUME("volume"), PERCENT_CHANGE("percentChange"), DIVIDEND_ANNOUNCEMENT("dividendAnnouncement");

	private String stockAttribute;

	private StockAttribute(String stockType) {
		this.stockAttribute = stockType;
	}

	public String getStockAttribute() {
		return stockAttribute;
	}
}

@Getter
class Stock {

	double price;
	int volume;
	double percentChange;
	double dividendAnnouncement;

	Map<StockAttribute, Set<StockSubscriber>> map = new EnumMap<>(StockAttribute.class);

	public Stock() {
		map.put(StockAttribute.PRICE, new LinkedHashSet<>());
		map.put(StockAttribute.VOLUME, new LinkedHashSet<>());
		map.put(StockAttribute.PERCENT_CHANGE, new LinkedHashSet<>());
		map.put(StockAttribute.DIVIDEND_ANNOUNCEMENT, new LinkedHashSet<>());
	}

	public void setPrice(double price) {
		this.price = price;
		updateAndNotifySubscribers(StockAttribute.PRICE, price);
	}

	public void setVolume(int volume) {
		this.volume = volume;
		updateAndNotifySubscribers(StockAttribute.VOLUME, volume);
	}

	public void setPercentChange(double percentChange) {
		this.percentChange = percentChange;
		updateAndNotifySubscribers(StockAttribute.PERCENT_CHANGE, percentChange);
	}

	public void setDividendAnnouncement(double dividendAnnouncement) {
		this.dividendAnnouncement = dividendAnnouncement;
		updateAndNotifySubscribers(StockAttribute.DIVIDEND_ANNOUNCEMENT, dividendAnnouncement);
	}

	public void registerAsSubscriber(StockSubscriber stockSubscriber, StockAttribute... stockAttributes) {
		if (stockAttributes.length != 0) {
			registerSpecificStockAttributeToSubscriber(stockSubscriber, stockAttributes); // register specific
																							// attributes to subscriber
		} else {
			registerSpecificStockAttributeToSubscriber(stockSubscriber, StockAttribute.values()); // register all
																									// attributes to
																									// subscriber
		}
	}

	private void registerSpecificStockAttributeToSubscriber(StockSubscriber stockSubscriber,
			StockAttribute... stockAttributes) {
		for (StockAttribute stockAttribute : stockAttributes) {
			Set<StockSubscriber> stockSubscribers = map.get(stockAttribute);
			stockSubscribers.add(stockSubscriber);
			map.put(stockAttribute, stockSubscribers);
		}
	}

	public void deregisterFromSubscriber(StockSubscriber stockSubscriber, StockAttribute... stockAttributes) {
		if (stockAttributes.length != 0) {
			deregisterSpecificStockAttributeToSubscriber(stockSubscriber, stockAttributes);
		} else {
			deregisterSpecificStockAttributeToSubscriber(stockSubscriber, StockAttribute.values());
		}
	}

	private void deregisterSpecificStockAttributeToSubscriber(StockSubscriber stockSubscriber,
			StockAttribute... stockAttributes) {
		for (StockAttribute stockAttribute : stockAttributes) {
			Set<StockSubscriber> stockSubscribers = map.get(stockAttribute);
			stockSubscribers.remove(stockSubscriber);
			map.put(stockAttribute, stockSubscribers);
		}
	}

	public <T> void updateAndNotifySubscribers(StockAttribute stockAttribute, T stockData) {
		Set<StockSubscriber> stockSubscribers = map.get(stockAttribute);
		if (stockSubscribers != null && !stockSubscribers.isEmpty()) {
			for (StockSubscriber stockSubscriber : stockSubscribers) {
				stockSubscriber.update(stockAttribute, stockData);
			}
		}
	}

}

interface StockSubscriber {

	<T> void update(StockAttribute stockAttribute, T stockData);
}

class InvestorDisplay implements StockSubscriber {

	@Override
	public <T> void update(StockAttribute stockAttribute, T stockData) {
		System.out
				.println("InvestorDisplay -> Stock " + stockAttribute.getStockAttribute() + " updated to " + stockData);
	}
}

class TradingBot implements StockSubscriber {

	@Override
	public <T> void update(StockAttribute stockAttribute, T stockData) {
		System.out.println("TradingBot -> reacting to " + stockAttribute.getStockAttribute() + " change: " + stockData);

	}
}

class NewsAgency implements StockSubscriber {

	@Override
	public <T> void update(StockAttribute stockAttribute, T stockData) {
		System.out.println("NewsAgency -> publishing news: Stock " + stockAttribute.getStockAttribute() + " changed to "
				+ stockData);

	}
}

class PortfolioManager implements StockSubscriber {

	@Override
	public <T> void update(StockAttribute stockAttribute, T stockData) {
		System.out.println("PortfolioManager -> recalculating portfolio due to " + stockAttribute.getStockAttribute()
				+ " = " + stockData);

	}
}

public class StockClient {

	public static void main(String[] args) {

		Stock stock = new Stock();

		StockSubscriber investorStockSubscriber = new InvestorDisplay();
		StockSubscriber tradingBotStockSubscriber = new TradingBot();
		StockSubscriber newsAgencyStockSubscriber = new NewsAgency();
		StockSubscriber portfolioManagerStockSubscriber = new PortfolioManager();

		stock.registerAsSubscriber(investorStockSubscriber, StockAttribute.PRICE);
		stock.registerAsSubscriber(tradingBotStockSubscriber, StockAttribute.PRICE, StockAttribute.VOLUME);
		stock.registerAsSubscriber(newsAgencyStockSubscriber, StockAttribute.DIVIDEND_ANNOUNCEMENT,
				StockAttribute.PERCENT_CHANGE);
		stock.registerAsSubscriber(portfolioManagerStockSubscriber, StockAttribute.PRICE);

		System.out.println("Changing price...");
		stock.setPrice(100.0);

		System.out.println("\nChanging volume...");
		stock.setVolume(120);

		System.out.println("\nChanging dividend announcement...");
		stock.setDividendAnnouncement(250.0);

		System.out.println("\nChanging price...");
		stock.setPrice(200.0);

		System.out.println("\nChanging percent change...");
		stock.setPercentChange(10.2);

		stock.deregisterFromSubscriber(newsAgencyStockSubscriber, StockAttribute.PERCENT_CHANGE);

		System.out.println("\nChanging percent change...");
		stock.setPercentChange(10.2);

		stock.registerAsSubscriber(investorStockSubscriber, StockAttribute.PERCENT_CHANGE);
		stock.setPercentChange(10.2);

		stock.registerAsSubscriber(investorStockSubscriber);

		System.out.println("Changing price...");
		stock.setPrice(100.0);

		System.out.println("\nChanging volume...");
		stock.setVolume(120);

		System.out.println("\nChanging dividend announcement...");
		stock.setDividendAnnouncement(250.0);

		System.out.println("\nChanging percent change...");
		stock.setPercentChange(10.2);
	}
}
