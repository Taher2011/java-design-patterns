package invoker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import command.LightCommand;
import lombok.NoArgsConstructor;

//Invoker 1: Remote control with queue and scheduling
@NoArgsConstructor
public class RemoteInvoker {

	private LightCommand lightCommand;

	private List<LightCommand> lightCommandsQueue = new ArrayList<>();

	private List<LightCommand> historyLightCommands = new ArrayList<>(); // For undo

	private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public RemoteInvoker(LightCommand lightCommand) {
		this.lightCommand = lightCommand;
	}

	public void setLightCommand(LightCommand lightCommand) {
		this.lightCommand = lightCommand;
	}

	/**
	 * Executes the current command and adds it to history.
	 */
	public void pressSwitch() {
		if (lightCommand != null) {
			lightCommand.execute();
			historyLightCommands.add(lightCommand);
		} else {
			System.out.println("No command set!");
		}
	}

	/**
	 * Undoes the last executed command.
	 */
	public void pressUndo() {
		if (!historyLightCommands.isEmpty()) {
			LightCommand lastCommand = historyLightCommands.remove(historyLightCommands.size() - 1);
			lastCommand.undo();
		} else {
			System.out.println("No commands to undo!");
		}
	}

	/**
	 * Adds a command to the queue.
	 */
	public void addCommand(LightCommand lightCommand) {
		lightCommandsQueue.add(lightCommand);
	}

	/**
	 * Executes all commands in the queue and adds them to history.
	 */
	public void executeAllCommands() {
		for (LightCommand command : lightCommandsQueue) {
			command.execute();
			historyLightCommands.add(command);// Save for undo
		}
		lightCommandsQueue.clear();// Clear queue after execution
	}

	public void undoLastCommand() {
		if (!historyLightCommands.isEmpty()) {
			LightCommand lightCommand = historyLightCommands.remove(historyLightCommands.size() - 1);
			lightCommand.undo();
		} else {
			System.out.println("Nothing to undo");
		}
	}

	public void scheduleCommand(LightCommand command, long delay, TimeUnit unit) {
		scheduler.schedule(() -> {
			command.execute();
			historyLightCommands.add(command);
			System.out.println("Scheduled command executed after " + delay + " " + unit);
		}, delay, unit);
	}

	public void shutdownScheduler() {
		scheduler.shutdown();
	}

}