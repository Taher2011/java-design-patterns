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

	private Command command;

	private Stack<Command> historyVoiceCommands;

	private List<Command> queueVoiceCommands;

	private ScheduledExecutorService scheduler;

	public VoiceInvoker() {
		historyVoiceCommands = new Stack<>();
		queueVoiceCommands = new ArrayList<>();
		scheduler = new ScheduledThreadPoolExecutor(2);
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void executeVoiceCommand(String voiceInput) {
		System.out.println("Voice command received: \"" + voiceInput + "\"");
		boolean isActionDone = command.execute();
		if (isActionDone) {
			historyVoiceCommands.push(command);
		}
	}

	public void undo() {
		if (!historyVoiceCommands.isEmpty()) {
			Command poppedCommand = historyVoiceCommands.pop();
			System.out.print("Undo:");
			poppedCommand.undo();
			return;
		}
		System.out.println("No commands to undo!");
	}

	public void addVoiceCommand(Command command) {
		if (command != null) {
			queueVoiceCommands.add(command);
		}
	}

	public void executeAllVoiceCommanda() {
		if (!queueVoiceCommands.isEmpty()) {
			for (Command command : queueVoiceCommands) {
				boolean isActionDone = command.execute();
				if (isActionDone) {
					historyVoiceCommands.push(command);
				}
			}
			queueVoiceCommands.clear();// Clear queue after execution
		}
	}

	public void scheduleVoiceCommand(Command command, int delay, TimeUnit timeUnit) {
		if (command != null) {
			scheduler.schedule(() -> {
				System.out.println("Scheduled voice command executed after " + delay + " " + timeUnit);
				boolean isActionDone = command.execute();
				if (isActionDone) {
					historyVoiceCommands.push(command);
				}
			}, delay, timeUnit);
		}
	}

	public void shutdownScheduler() {
		scheduler.shutdown();
	}
}
