package command.concrete_command;

import command.command.Command;
import command.receiver.LightReceiver;
import lombok.Getter;

@Getter
public class LightOnCommand implements Command<Boolean> {

	private LightReceiver lightReceiver;

	public LightOnCommand(LightReceiver lightReceiver) {
		this.lightReceiver = lightReceiver;
	}

	@Override
	public Boolean execute() {
		return lightReceiver.turnOnLights();
	}

	@Override
	public void undo() {
		lightReceiver.turnOffLights();
	}
}
