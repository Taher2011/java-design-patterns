package targets;

public class MultiMediaPlayer implements Mp3Player {

	@Override
	public void playMp3() {
		System.out.println("Playing music on legacy multimedia player...");
	}

}
