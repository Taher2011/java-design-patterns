package client;

import java.util.concurrent.TimeUnit;

import command.LightCommand;
import concrete_command.LightOffCommand;
import concrete_command.LightOnCommand;
import invoker.RemoteInvoker;
import invoker.SmartHomeControllerInvoker;
import receiver.LightReceiver;

public class CommandClient {

	public static void main(String[] args) throws InterruptedException {
		LightReceiver lightReceiver = new LightReceiver();
		LightCommand lightOnCommand = new LightOnCommand(lightReceiver);
		LightCommand lightOffCommand = new LightOffCommand(lightReceiver);

		RemoteInvoker remoteInvoker = new RemoteInvoker(lightOnCommand);
		remoteInvoker.pressSwitch();
		remoteInvoker.pressUndo();

		remoteInvoker = new RemoteInvoker(lightOffCommand);
		remoteInvoker.pressSwitch();

		remoteInvoker = new RemoteInvoker(lightOnCommand);
		remoteInvoker.pressSwitch();
		remoteInvoker = new RemoteInvoker(lightOffCommand);
		remoteInvoker.pressUndo();

		System.out.println("===========================================================");
		RemoteInvoker bulkRemoteInvoker = new RemoteInvoker();
		// Add commands to queue
		bulkRemoteInvoker.addCommand(lightOnCommand);
		bulkRemoteInvoker.addCommand(lightOffCommand);
		bulkRemoteInvoker.addCommand(lightOnCommand);

		// Execute all commands
		bulkRemoteInvoker.executeAllCommands();

		// Undo last command
		System.out.println("\nUndoing last command:");
		bulkRemoteInvoker.undoLastCommand();
		System.out.println("===========================================================");

		// Schedule commands
		System.out.println("\nScheduling commands:");
		remoteInvoker.scheduleCommand(lightOnCommand, 2, TimeUnit.SECONDS); // Turn on after 2 seconds
		remoteInvoker.scheduleCommand(lightOffCommand, 4, TimeUnit.SECONDS); // Turn off after 4 seconds

		// Wait for scheduled tasks to complete
		Thread.sleep(5000);

		// Shutdown scheduler
		remoteInvoker.shutdownScheduler();
		System.out.println("===========================================================");
		// Undo last command
		System.out.println("\nUndoing last command:");
		remoteInvoker.undoLastCommand();
		System.out.println("===========================================================");
		SmartHomeControllerInvoker smartHomeControllerInvoker = new SmartHomeControllerInvoker();
		smartHomeControllerInvoker.setLightCommand(lightOnCommand);
		smartHomeControllerInvoker.executeVoiceCommand("Turn on the light");
		smartHomeControllerInvoker.setLightCommand(lightOffCommand);
		smartHomeControllerInvoker.executeVoiceCommand("Turn off the light");
		smartHomeControllerInvoker.UndoVoiceCommand();
		smartHomeControllerInvoker.setLightCommand(lightOnCommand);
		smartHomeControllerInvoker.executeVoiceCommand("Turn on the light");
	}

}
