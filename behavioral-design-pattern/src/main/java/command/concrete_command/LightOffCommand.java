package concrete_command;

import command.LightCommand;
import lombok.Getter;
import receiver.LightReceiver;

@Getter
public class LightOffCommand implements LightCommand {

	private LightReceiver lightReceiver;

	public LightOffCommand(LightReceiver lightReceiver) {
		this.lightReceiver = lightReceiver;
	}

	@Override
	public void execute() {
		lightReceiver.lightOffAction();
	}

	@Override
	public void undo() {
		lightReceiver.lightOnAction();
	}
}
