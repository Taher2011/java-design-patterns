package concrete_command;

import command.LightCommand;
import lombok.Getter;
import receiver.LightReceiver;

@Getter
public class LightOffCommand implements LightCommand {

	private LightReceiver lightReceiver;
	private String location;

	public LightOffCommand(LightReceiver lightReceiver, String location) {
		this.lightReceiver = lightReceiver;
		this.location = location;
	}

	@Override
	public void execute() {
		lightReceiver.lightOffAction(location);
	}

	@Override
	public void undo() {
		lightReceiver.lightOnAction(location);
	}
}
