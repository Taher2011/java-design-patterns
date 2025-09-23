package command.receiver;

public class LightReceiver {

	private String room;

	private boolean isOn;

	public LightReceiver(String room) {
		this.room = room;
	}

	public boolean turnOnLights() {
		if (!isOn) {
			System.out.println(room + " are switched-on now");
			isOn = true;
			return true;
		}
		System.out.println(room + " are already switched-on");
		return false;
	}

	public boolean turnOffLights() {
		if (isOn) {
			System.out.println(room + " are switched-off now");
			isOn = false;
			return true;
		}
		System.out.println(room + " are already switched-off");
		return false;
	}
}
