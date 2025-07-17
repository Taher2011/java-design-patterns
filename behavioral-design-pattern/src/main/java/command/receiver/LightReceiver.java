package receiver;

public class LightReceiver {

	private boolean isOn = false;

	public void lightOnAction() {
		if (isOn) {
			System.out.println("lights are already switched on");
			return;
		}
		isOn = true;
		System.out.println("please switch on the lights");
	}

	public void lightOffAction() {
		if (!isOn) {
			System.out.println("lights are already switched off");
			return;
		}
		isOn = false;
		System.out.println("please switch off the lights");
	}

	public boolean isOn() {
		return isOn;
	}

}
