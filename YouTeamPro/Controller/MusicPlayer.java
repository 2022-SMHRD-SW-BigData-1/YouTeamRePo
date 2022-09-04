package Controller;

import java.util.ArrayList;

import Model.MusicVO;
import javazoom.jl.player.MP3Player;

public class MusicPlayer {

	MP3Player mp3 = new MP3Player();
	ArrayList<MusicVO> musiclist = new ArrayList<MusicVO>();

	public MusicPlayer() {
		musiclist.add(new MusicVO("0_프롤로그", "C://music/0_프롤로그.mp3"));
		musiclist.add(new MusicVO("1_스토리진행", "C://music/1_스토리진행.mp3"));
		musiclist.add(new MusicVO("2_스핑크스", "C://music/2_스핑크스.mp3"));
		musiclist.add(new MusicVO("3_회원정보", "C://music/3_회원정보.mp3"));
		musiclist.add(new MusicVO("test청하", "C://music/test청하.mp3"));
		musiclist.add(new MusicVO("5_개인정보", "C://music/5_개인정보.mp3"));
		musiclist.add(new MusicVO("0_프롤로그", "C://music/0_프롤로그"));
		musiclist.add(new MusicVO("0_프롤로그", "C://music/0_프롤로그"));
		musiclist.add(new MusicVO("0_프롤로그", "C://music/0_프롤로그"));
	
	}

	public MusicVO play(int a) {
		MusicVO m = musiclist.get(a);

		if (mp3.isPlaying()) {
			mp3.stop();
		}

		mp3.play(m.getMusicPath());

		return m;

	}

	public void stop() {
		if (mp3.isPlaying()) {
			mp3.stop();
		}
	}

}
