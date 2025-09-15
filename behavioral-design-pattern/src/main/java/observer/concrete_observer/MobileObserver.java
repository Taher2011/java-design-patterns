package observer.concrete_observer;

import observer.enums.WeatherType;
import observer.observer.Observer;
import observer.subject.WeatherReport;

public class MobileObserver implements Observer {

	private WeatherReport report;

	public MobileObserver(WeatherReport report) {
		this.report = report;
	}

	@Override
	public void update(WeatherType weatherType, double value) {
		display(weatherType, value);
	}

	private void display(WeatherType weatherDataType, double value) {
		System.out.println("mobile app shows: Temp = " + value + "°C");
	}
}
