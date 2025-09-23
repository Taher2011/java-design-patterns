package command.client;

import java.util.concurrent.TimeUnit;

import command.command.Command;
import command.concrete_command.LightOffCommand;
import command.concrete_command.LightOnCommand;
import command.invoker.RemoteInvoker;
import command.invoker.VoiceInvoker;
import command.receiver.LightReceiver;

public class CommandClient {

	public static void main(String[] args) throws InterruptedException {

		// Setup
		LightReceiver bedRoomLightReceiver = new LightReceiver("Bedroom");
		LightReceiver livingRoomLightReceiver = new LightReceiver("LivingRoom");

		Command<Boolean> bedroomLightOnCommand = new LightOnCommand(bedRoomLightReceiver);
		Command<Boolean> bedroomLightOffCommand = new LightOffCommand(bedRoomLightReceiver);
		Command<Boolean> livingroomLightOnCommand = new LightOnCommand(livingRoomLightReceiver);
		Command<Boolean> livingroomLightOffCommand = new LightOffCommand(livingRoomLightReceiver);

		// Test 1: Single Commands
		System.out.println("=== Testing Single Commands ===");
		RemoteInvoker remoteInvoker = new RemoteInvoker();
		remoteInvoker.setCommand(bedroomLightOnCommand);
		remoteInvoker.pressSwitch(); // bedroom On
		remoteInvoker.pressSwitch(); // bedroom Already on
		remoteInvoker.undo(); // bedroom Off
		remoteInvoker.undo(); // No commands

		// Test 2: Bulk Commands
		System.out.println("\n=== Testing Bulk Commands ===");
		RemoteInvoker bulkRemoteInvoker = new RemoteInvoker();
		bulkRemoteInvoker.addCommand(bedroomLightOnCommand); // bedroom On
		bulkRemoteInvoker.addCommand(bedroomLightOnCommand); // bedroom Already on
		bulkRemoteInvoker.addCommand(livingroomLightOnCommand); // livingroom On
		bulkRemoteInvoker.addCommand(livingroomLightOffCommand); // livingroom Off
		bulkRemoteInvoker.executeAllCommands();
		bulkRemoteInvoker.undo(); // livingroom On
		bulkRemoteInvoker.undo(); // livingroom Off
		bulkRemoteInvoker.undo(); // bedroom Off
		bulkRemoteInvoker.undo();// No commands

		// Test 3: Scheduled Commands
		System.out.println("\n=== Testing Scheduled Commands ===");
		RemoteInvoker bulkRemotecheduler = new RemoteInvoker();
		bulkRemotecheduler.scheduleCommand(bedroomLightOnCommand, 2, TimeUnit.SECONDS); // bedroom On
		bulkRemotecheduler.scheduleCommand(bedroomLightOffCommand, 4, TimeUnit.SECONDS); // bedroom Off
		Thread.sleep(5000); // Wait for tasks
		bulkRemotecheduler.shutdownScheduler(); // Graceful shutdown
		bulkRemotecheduler.undo(); // bedroom On
		bulkRemotecheduler.undo(); // bedroom Off

		// Test 4: Voice Commands
		System.out.println("\n=== Testing Voice Commands ===");
		VoiceInvoker voiceInvoker = new VoiceInvoker();

		voiceInvoker.setCommand(livingroomLightOnCommand);
		voiceInvoker.executeVoiceCommand("Turn on LivingRoom light"); // livingroom On

		voiceInvoker.setCommand(bedroomLightOffCommand);
		voiceInvoker.executeVoiceCommand("Turn off BedRoom light"); // bedroom Already of

		voiceInvoker.undo();
		voiceInvoker.shutdownScheduler();

	}

}
