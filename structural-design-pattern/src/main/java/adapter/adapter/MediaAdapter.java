package adapter.adapter;

import adapter.adaptee.ModernMediaPlayer;
import adapter.target.Mp3Player;

public class MediaAdapter implements Mp3Player {

	private final ModernMediaPlayer modernMediaPlayer;

	public MediaAdapter(ModernMediaPlayer modernMediaPlayer) {
		if (modernMediaPlayer == null) {
			throw new IllegalArgumentException("ModernMediaPlayer cannot be null");
		}
		this.modernMediaPlayer = modernMediaPlayer;
	}

	@Override
	public void playMp3() {
		modernMediaPlayer.playMedia();
	}

}
