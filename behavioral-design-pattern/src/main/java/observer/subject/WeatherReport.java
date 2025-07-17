package subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.WeatherType;
import observer.Observer;

public class WeatherReport {

	private double temperature;
	private double humidity;
	private double pressure;
	private Map<WeatherType, List<Observer>> map = new HashMap<>();

	public WeatherReport() {
		map.put(WeatherType.TEMPERATURE, new ArrayList<>());
		map.put(WeatherType.HUMIDITY, new ArrayList<>());
		map.put(WeatherType.PRESSURE, new ArrayList<>());
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
		notifyObservers(WeatherType.HUMIDITY, humidity);
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
		notifyObservers(WeatherType.TEMPERATURE, temperature);
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
		notifyObservers(WeatherType.PRESSURE, pressure);
	}

	public void registerObserver(Observer observer, WeatherType weatherDataType) {
		map.get(weatherDataType).add(observer);
	}

	public void removeObserver(Observer observer, WeatherType weatherDataType) {
		map.get(weatherDataType).remove(observer);
	}

	private void notifyObservers(WeatherType weatherType, double value) {
		for (Observer observer : map.get(weatherType)) {
			observer.update(weatherType, value);
		}
	}
}
