package command.command;

public interface Command<T> {

	T execute();

	void undo();
}
