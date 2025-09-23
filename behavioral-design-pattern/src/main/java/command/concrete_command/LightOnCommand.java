package command.concrete_command;

import command.command.Command;
import command.receiver.LightReceiver;
import lombok.Getter;

@Getter
public class LightOnCommand implements Command {

	private LightReceiver lightReceiver;

	public LightOnCommand(LightReceiver lightReceiver) {
		this.lightReceiver = lightReceiver;
	}

	@Override
	public boolean execute() {
		return lightReceiver.turnOnLights();
	}

	@Override
	public void undo() {
		lightReceiver.turnOffLights();
	}
}
