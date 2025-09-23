package command.invoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import command.command.Command;

//Invoker 2: SmartHomeController with voice command simulation
public class VoiceInvoker {

	private Command<Boolean> command;

	private Stack<Command<Boolean>> historyVoiceCommands;

	private List<Command<Boolean>> queueVoiceCommands;

	private ScheduledExecutorService scheduler;

	public VoiceInvoker() {
		historyVoiceCommands = new Stack<>();
		queueVoiceCommands = new ArrayList<>();
		scheduler = new ScheduledThreadPoolExecutor(2);
	}

	public void setCommand(Command<Boolean> command) {
		this.command = command;
	}

	public void executeVoiceCommand(String voiceInput) {
		System.out.println("Voice command received: \"" + voiceInput + "\"");
		Boolean isActionDone = command.execute();
		if (isActionDone.booleanValue()) {
			historyVoiceCommands.push(command);
		}
	}

	public void undo() {
		if (!historyVoiceCommands.isEmpty()) {
			Command<Boolean> poppedCommand = historyVoiceCommands.pop();
			System.out.print("Undo:");
			poppedCommand.undo();
			return;
		}
		System.out.println("No commands to undo!");
	}

	public void addVoiceCommand(Command<Boolean> command) {
		if (command != null) {
			queueVoiceCommands.add(command);
		}
	}

	public void executeAllVoiceCommands() {
		if (!queueVoiceCommands.isEmpty()) {
			for (Command<Boolean> command : queueVoiceCommands) {
				Boolean isActionDone = command.execute();
				if (isActionDone.booleanValue()) {
					historyVoiceCommands.push(command);
				}
			}
			queueVoiceCommands.clear();// Clear queue after execution
		}
	}

	public void scheduleVoiceCommand(Command<Boolean> command, int delay, TimeUnit timeUnit) {
		if (command != null) {
			scheduler.schedule(() -> {
				System.out.println("Scheduled voice command executed after " + delay + " " + timeUnit);
				Boolean isActionDone = command.execute();
				if (isActionDone.booleanValue()) {
					historyVoiceCommands.push(command);
				}
			}, delay, timeUnit);
		}
	}

	public void shutdownScheduler() {
		scheduler.shutdown();
	}
}
