package adapter.client;

import adapter.adaptee.ITunesMediaPlayer;
import adapter.adaptee.VLCMediaPlayer;
import adapter.adapter.MediaAdapter;
import adapter.target.Mp3Player;
import adapter.target.MultiMediaPlayer;

//Enum for supported media player types
enum MediaPlayerType {
	VLC, ITUNES
}

//Client class to play music using different players
class MusicPlayer {
	public void play(MediaPlayerType playerType) {
		Mp3Player player;
		switch (playerType) {
		case VLC:
			player = new MediaAdapter(new VLCMediaPlayer());
			break;
		case ITUNES:
			player = new MediaAdapter(new ITunesMediaPlayer());
			break;
		default:
			player = new MultiMediaPlayer(); // Fallback to legacy player
		}
		player.playMp3();
	}
}

public class AdapterClient {

	public static void main(String[] args) {
		MusicPlayer musicPlayer = new MusicPlayer();
		System.out.println("Testing modern media players with adapter:");
		musicPlayer.play(MediaPlayerType.ITUNES);
		musicPlayer.play(MediaPlayerType.VLC);

		System.out.println("\nTesting legacy player directly:");
		Mp3Player legacyPlayer = new MultiMediaPlayer();
		legacyPlayer.playMp3();
	}

}
