package observer.observer;

import observer.enums.WeatherType;

public interface Observer {
	void update(WeatherType weatherType, double value);
}
