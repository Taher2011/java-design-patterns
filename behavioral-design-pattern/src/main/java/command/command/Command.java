package command.command;

public interface Command {

	boolean execute();

	void undo();
}
