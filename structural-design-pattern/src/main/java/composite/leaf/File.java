package leaf;

import component.Folder;

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
