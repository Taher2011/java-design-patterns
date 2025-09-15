package adapter.adaptee;

public class VLCMediaPlayer implements ModernMediaPlayer {
	@Override
	public void playMedia() {
		System.out.println("Playing music on VLC Media Player...");
	}
}
