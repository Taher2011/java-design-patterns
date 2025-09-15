package command.client;

import java.util.concurrent.TimeUnit;

import command.command.LightCommand;
import command.concrete_command.LightOffCommand;
import command.concrete_command.LightOnCommand;
import command.invoker.RemoteInvoker;
import command.invoker.SmartHomeControllerInvoker;
import command.receiver.LightReceiver;

public class CommandClient {

	public static void main(String[] args) throws InterruptedException {
		LightReceiver lightReceiver = new LightReceiver();
		LightCommand lightOnCommandBedRoom = new LightOnCommand(lightReceiver, "Bedroom");
		LightCommand lightOffCommandBedRoom = new LightOffCommand(lightReceiver, "Bedroom");
		LightCommand lightOnCommandLivingRoom = new LightOnCommand(lightReceiver, "LivingRoom");

		RemoteInvoker remoteInvoker = new RemoteInvoker(lightOnCommandBedRoom);
		remoteInvoker.pressSwitch();
		remoteInvoker.pressUndo();

		remoteInvoker = new RemoteInvoker(lightOffCommandBedRoom);
		remoteInvoker.pressSwitch();

		remoteInvoker = new RemoteInvoker(lightOnCommandBedRoom);
		remoteInvoker.pressSwitch();

		remoteInvoker = new RemoteInvoker(lightOffCommandBedRoom);
		remoteInvoker.pressUndo();

		remoteInvoker = new RemoteInvoker(lightOnCommandLivingRoom);
		remoteInvoker.pressSwitch();

		System.out.println("===========================================================");

		RemoteInvoker bulkRemoteInvoker = new RemoteInvoker();
		// Add commands to queue
		bulkRemoteInvoker.addCommand(lightOnCommandBedRoom);
		bulkRemoteInvoker.addCommand(lightOffCommandBedRoom);
		bulkRemoteInvoker.addCommand(lightOnCommandBedRoom);
		bulkRemoteInvoker.addCommand(lightOnCommandLivingRoom);

		// Execute all commands
		bulkRemoteInvoker.executeAllCommands();

		// Undo last command
		System.out.println("\nUndoing last command:");
		bulkRemoteInvoker.undoLastCommand();

		System.out.println("===========================================================");

		// Schedule commands
		System.out.println("\nScheduling commands:");
		remoteInvoker.scheduleCommand(lightOnCommandBedRoom, 2, TimeUnit.SECONDS); // Turn on after 2 seconds
		remoteInvoker.scheduleCommand(lightOffCommandBedRoom, 4, TimeUnit.SECONDS); // Turn off after 4 seconds

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

		smartHomeControllerInvoker.setLightCommand(lightOnCommandLivingRoom);
		smartHomeControllerInvoker.executeVoiceCommand("Turn on the Livingroom light");

		System.out.println();

		smartHomeControllerInvoker.setLightCommand(lightOnCommandBedRoom);
		smartHomeControllerInvoker.executeVoiceCommand("Turn on the Bedroom light");

		System.out.println();

		smartHomeControllerInvoker.setLightCommand(lightOffCommandBedRoom);
		smartHomeControllerInvoker.executeVoiceCommand("Turn off the Bedroom light");

		System.out.println();

		smartHomeControllerInvoker.UndoVoiceCommand();
		System.out.println();

		smartHomeControllerInvoker.setLightCommand(lightOnCommandBedRoom);
		smartHomeControllerInvoker.executeVoiceCommand("Turn on the Bedroom ight");
	}

}
