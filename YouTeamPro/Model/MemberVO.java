package Model;

public class MemberVO {
	private String id;
	private int pw;
	private String nick;
	private int score;
	private String grade;
	private int times;
	
	public MemberVO(String id, int pw, String nick, int score, String grade, int times) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.score = score;
		this.grade = grade;
		this.times = times;
	}
	public MemberVO(String id,String nick, int score, String grade, int times) {
		super();
		this.id = id;
		this.nick = nick;
		this.score = score;
		this.grade = grade;
		this.times = times;
	}
	public MemberVO(String id, String nick) {
		super();
		this.id = id;
		this.nick = nick;
//		this.score = score;
//		this.grade = grade;
//		this.time = time;
	}

	public MemberVO(String a) {
		
	}
	
	public String getwords() {
		return null;
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

	public int getTimes() {
		return times;
	}

	public void setTime(int times) {
		this.times = times;
	}
	
	
	

}
