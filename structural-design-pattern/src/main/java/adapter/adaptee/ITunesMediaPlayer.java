package adapter.adaptee;

public class ITunesMediaPlayer implements ModernMediaPlayer {
	@Override
	public void playMedia() {
		System.out.println("Playing music on iTunes Media Player...");
	}
}
