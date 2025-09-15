package command.invoker;

import command.command.LightCommand;
import lombok.NoArgsConstructor;

//Invoker 2: SmartHomeController with voice command simulation
@NoArgsConstructor
public class SmartHomeControllerInvoker {

	private LightCommand lightCommand;

	public SmartHomeControllerInvoker(LightCommand lightCommand) {
		this.lightCommand = lightCommand;
	}

	public void setLightCommand(LightCommand lightCommand) {
		this.lightCommand = lightCommand;
	}

	public void executeVoiceCommand(String voiceInput) {
		System.out.println("Voice command received: \"" + voiceInput + "\"");
		lightCommand.execute();
	}

	public void UndoVoiceCommand() {
		System.out.println("Undo Voice command received");
		lightCommand.undo();
	}
}
