package observer;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
enum WeatherType {
	TEMPERATRUE("celsius"), HUMIDITY("percentage"), PRESSURE("hPa");

	private String unit;

	private WeatherType(String unit) {
		this.unit = unit;
	}
}

class Weather {

	private double value;

	private List<Observer> observers;

	private WeatherType weatherType;

	public Weather(double value, WeatherType weatherType) {
		this.value = value;
		this.weatherType = weatherType;
		observers = new ArrayList<>();
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
		notifyObservers();
	}

	public void registerObserver(Observer observer) {
		if (observer != null) {
			observers.add(observer);
		}
	}

	public void removeObserver(Observer observer) {
		if (observer != null) {
			observers.remove(observer);
		}
	}

	public void notifyObservers() {
		System.out.println();
		for (Observer observer : observers) {
			observer.update(this.weatherType, value);
		}
	}

}

interface Observer {
	void update(WeatherType weatherType, double value);
}

class WeatherObserver implements Observer {

	String observerType;

	public WeatherObserver(String observerType) {
		if (observerType == null) {
			throw new IllegalArgumentException("Observer type cannot be null");
		}
		this.observerType = observerType;
	}

	@Override
	public void update(WeatherType weatherType, double value) {
		display(weatherType, value);
	}

	private void display(WeatherType weatherType, double value) {
		System.out.println("update " + weatherType.name().toLowerCase() + " for " + this.observerType + " is " + value
				+ " " + weatherType.getUnit());
	}

}

public class WeatherNotification {

	public static void main(String[] args) {
		Weather tempWeather = new Weather(0, WeatherType.TEMPERATRUE);
		Weather pressureWeather = new Weather(0, WeatherType.PRESSURE);
		Weather humidityWeather = new Weather(0, WeatherType.HUMIDITY);

		Observer mediaObserver = new WeatherObserver("Media");
		Observer mobileObserver = new WeatherObserver("Mobile");
		Observer labObserver = new WeatherObserver("Lab");

		tempWeather.registerObserver(mediaObserver);
		tempWeather.registerObserver(mobileObserver);
		tempWeather.registerObserver(labObserver);

		tempWeather.setValue(42.0);

		pressureWeather.registerObserver(mediaObserver);
		pressureWeather.setValue(55.58);

		humidityWeather.registerObserver(mediaObserver);
		humidityWeather.registerObserver(labObserver);
		humidityWeather.setValue(65.7);
	}
}
