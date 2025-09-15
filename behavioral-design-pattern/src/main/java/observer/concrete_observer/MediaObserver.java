package observer.concrete_observer;

import observer.enums.WeatherType;
import observer.observer.Observer;
import observer.subject.WeatherReport;

public class MediaObserver implements Observer {

	private WeatherReport report;

	public MediaObserver(WeatherReport report) {
		this.report = report;
	}

	@Override
	public void update(WeatherType weatherDataType, double value) {
		display(weatherDataType, value);
	}

	private void display(WeatherType weatherDataType, double value) {
		if (weatherDataType == WeatherType.TEMPERATURE) {
			System.out.println("news channel reports: Temp = " + value + "°C");
		} else if (weatherDataType == WeatherType.HUMIDITY) {
			System.out.println("news channel reports: Humidity = " + value + "%");
		} else if (weatherDataType == WeatherType.PRESSURE) {
			System.out.println("news channel reports: Pressure = " + value + "%");
		}
	}
}
