package command.concrete_command;

import command.command.Command;
import command.receiver.LightReceiver;
import lombok.Getter;

@Getter
public class LightOffCommand implements Command<Boolean> {

	private LightReceiver lightReceiver;

	public LightOffCommand(LightReceiver lightReceiver) {
		this.lightReceiver = lightReceiver;
	}

	@Override
	public Boolean execute() {
		return lightReceiver.turnOffLights();
	}

	@Override
	public void undo() {
		lightReceiver.turnOnLights();
	}
}
