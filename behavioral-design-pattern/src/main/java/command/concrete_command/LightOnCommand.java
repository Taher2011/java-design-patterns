package concrete_command;

import command.LightCommand;
import lombok.Getter;
import receiver.LightReceiver;

@Getter
public class LightOnCommand implements LightCommand {

	private LightReceiver lightReceiver;
	private String location;

	public LightOnCommand(LightReceiver lightReceiver, String location) {
		this.lightReceiver = lightReceiver;
		this.location = location;
	}

	@Override
	public void execute() {
		lightReceiver.lightOnAction(location);
	}

	@Override
	public void undo() {
		lightReceiver.lightOffAction(location);
	}

}
