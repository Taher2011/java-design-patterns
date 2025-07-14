package client;

import component.Folder;
import composite.FolderGroup;
import leaf.File;

public class CompositePattern {

	public static void main(String[] args) {

		FolderGroup root = new FolderGroup("root");
		FolderGroup home = new FolderGroup("home");
		FolderGroup user = new FolderGroup("user");
		FolderGroup music = new FolderGroup("music");
		FolderGroup photos = new FolderGroup("photos");
		FolderGroup document = new FolderGroup("document");

		Folder textFile = new File("git_commands.text");

		FolderGroup resume = new FolderGroup("resume");

		Folder taherResume = new File("taherResume.pdf");

		FolderGroup engagementPhotos = new FolderGroup("engagement");
		FolderGroup tripPhotos = new FolderGroup("trip");

		Folder ringPic = new File("ring.jpeg");
		Folder trackingPic = new File("tracking.jpeg");

		FolderGroup retro = new FolderGroup("retro");
		FolderGroup latest = new FolderGroup("new");

		Folder kishorDa = new File("aanewla_pal.mp3");
		Folder sapphire = new File("sapphire.mp3");

		root.addComponent(home);
		home.addComponent(user);
		user.addComponent(music);
		user.addComponent(photos);
		user.addComponent(document);

		document.addComponent(textFile);
		document.addComponent(resume);

		resume.addComponent(taherResume);

		photos.addComponent(engagementPhotos);
		photos.addComponent(tripPhotos);

		engagementPhotos.addComponent(ringPic);
		tripPhotos.addComponent(trackingPic);

		music.addComponent(retro);
		music.addComponent(latest);

		retro.addComponent(kishorDa);
		latest.addComponent(sapphire);

		root.display(0);

	}

}
