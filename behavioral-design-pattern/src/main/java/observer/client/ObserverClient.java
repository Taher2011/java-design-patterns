package client;

import concrete_observer.MediaObserver;
import concrete_observer.MobileObserver;
import enums.WeatherType;
import observer.Observer;
import subject.WeatherReport;

public class ObserverClient {

	public static void main(String[] args) {
		WeatherReport report = new WeatherReport();
		Observer mediaObserver = new MediaObserver(report);
		Observer mobileObserver = new MobileObserver(report);

		// register observer
		report.registerObserver(mediaObserver, WeatherType.TEMPERATURE);
		report.registerObserver(mediaObserver, WeatherType.HUMIDITY);
		report.registerObserver(mediaObserver, WeatherType.PRESSURE);
		report.registerObserver(mobileObserver, WeatherType.TEMPERATURE);

		// Update temperature
		System.out.println("\nChanging temperature...");
		report.setTemperature(32.0);

		// Update humidity
		System.out.println("\nChanging humidity...");
		report.setHumidity(36.0);

		// Update pressure
		System.out.println("\nChanging pressure...");
		report.setPressure(1010.0);

		// Update pressure again
		System.out.println("\nChanging pressure again...");
		report.setPressure(1008.0);
	}
}
