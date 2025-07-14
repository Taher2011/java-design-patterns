package composite;

import java.util.ArrayList;
import java.util.List;

import component.Folder;

public class FolderGroup implements Folder {

	private String folderName;

	private final List<Folder> components;

	public FolderGroup(String folderName) {
		this.folderName = folderName;
		components = new ArrayList<>();
	}

	@Override
	public void display(int depth) {
		System.out.println(" ".repeat(depth) + "+" + folderName);
		for (Folder component : components) {
			component.display(depth + 1);
		}
	}

	public void addComponent(Folder component) {
		components.add(component);
	}

}
