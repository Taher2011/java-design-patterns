package concrete_command;

import command.LightCommand;
import lombok.Getter;
import receiver.LightReceiver;

@Getter
public class LightOnCommand implements LightCommand {

	private LightReceiver lightReceiver;

	public LightOnCommand(LightReceiver lightReceiver) {
		this.lightReceiver = lightReceiver;
	}

	@Override
	public void execute() {
		lightReceiver.lightOnAction();
	}

	@Override
	public void undo() {
		lightReceiver.lightOffAction();
	}
}
