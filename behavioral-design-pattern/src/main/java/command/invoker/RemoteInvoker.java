package command.invoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import command.command.Command;

//Invoker 1: Remote control with queue and scheduling
public class RemoteInvoker {

	private Command command;

	private Stack<Command> historyCommands;

	private List<Command> queueCommands;

	private ScheduledExecutorService scheduler;

	public RemoteInvoker() {
		queueCommands = new ArrayList<>();
		historyCommands = new Stack<>();
		scheduler = new ScheduledThreadPoolExecutor(2);
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void pressSwitch() {
		if (command == null) {
			System.out.println("No command set!");
			return;
		}
		boolean isActionDone = command.execute();
		if (isActionDone) {
			historyCommands.push(command);
		}
	}

	public void undo() {
		if (!historyCommands.isEmpty()) {
			Command poppedCommand = historyCommands.pop();
			System.out.print("Undo:");
			poppedCommand.undo();
			return;
		}
		System.out.println("No commands to undo!");
	}

	public void addCommand(Command command) {
		if (command != null) {
			queueCommands.add(command);
		}
	}

	public void executeAllCommands() {
		if (!queueCommands.isEmpty()) {
			for (Command command : queueCommands) {
				boolean isActionDone = command.execute();
				if (isActionDone) {
					historyCommands.push(command);
				}
			}
			queueCommands.clear();// Clear queue after execution
		}
	}

	public void scheduleCommand(Command command, int delay, TimeUnit timeUnit) {
		if (command != null) {
			scheduler.schedule(() -> {
				System.out.println("Scheduled command executed after " + delay + " " + timeUnit);
				boolean isActionDone = command.execute();
				if (isActionDone) {
					historyCommands.push(command);
				}
			}, delay, timeUnit);
		}
	}

	public void shutdownScheduler() {
		scheduler.shutdown();
	}
}