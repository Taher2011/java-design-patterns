package composite._01_folder_hierarhy_leaf;

import composite._01_folder_hierarhy_component.Folder;

public class File implements Folder {

	private String fileName;

	public File(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display(int depth) {
		System.out.println(" ".repeat(depth) + fileName);
	}

}
