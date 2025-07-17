package observer;

import enums.WeatherType;

public interface Observer {
	void update(WeatherType weatherType, double value);
}
