package receiver;

import java.util.HashMap;
import java.util.Map;

public class LightReceiver {

	private Map<String, Boolean> lightStates = new HashMap<>();

	public void lightOnAction(String location) {
		if (!lightStates.getOrDefault(location, false)) {
			System.out.println(location + " lights are switched-on now");
			lightStates.put(location, true);
			return;
		}
		System.out.println(location + " lights are already switched-on");
	}

	public void lightOffAction(String location) {
		if (lightStates.getOrDefault(location, false)) {
			System.out.println(location + " lights are switched-off now");
			lightStates.put(location, false);
			return;
		}
		System.out.println(location + " lights are already switched-off");
	}
}
