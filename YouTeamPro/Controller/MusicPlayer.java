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
		musiclist.add(new MusicVO("4_게임진행", "C://music/4_게임진행.mp3"));
		musiclist.add(new MusicVO("5_찬스소진", "C://music/5_찬스소진.mp3"));
		musiclist.add(new MusicVO("6_라이프깎임", "C://music/6_라이프깎임.mp3"));
		musiclist.add(new MusicVO("7_죽음", "C://music/7_죽음.mp3"));
		musiclist.add(new MusicVO("8_엔딩", "C://music/8_엔딩.mp3"));
	
	
	}

	public MusicVO play(int a) {
		MusicVO m = musiclist.get(a);

		if (mp3.isPlaying()) {
			mp3.stop();
		}

		mp3.play(m.getMusicPath());

		return m;

	}
	
	public MusicVO subPlay(int a) {
		MusicVO m = musiclist.get(a);
		mp3.play(m.getMusicPath());
		return m;

	}

	public void stop() {
		

		if (mp3.isPlaying()) {
			mp3.stop();
		}

			
		
	}

}
