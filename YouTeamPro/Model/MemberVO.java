package Model;

public class MemberVO {
	private String id;
	private int pw;
	private String nick;
	private int score;
	private String grade;
	private String time;
	
	public MemberVO(String id, int pw, String nick, int score, String grade, String time) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.score = score;
		this.grade = grade;
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	

}
