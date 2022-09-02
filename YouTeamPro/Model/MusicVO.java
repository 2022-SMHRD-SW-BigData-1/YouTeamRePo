package Model;

public class MusicVO {
	private String title;
	private String musicPath;
	
	public MusicVO(String title, String musicPath) {
		super();
		this.title = title;
		this.musicPath = musicPath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMusicPath() {
		return musicPath;
	}

	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}
	
	
}
