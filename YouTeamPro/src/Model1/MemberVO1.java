package Model1;

import java.sql.SQLException;

public class MemberVO {

	
	private String id;
	private String pw;
	private String nick;
	
	public MemberVO(String id, String pw, String nick, int score) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick = nick;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}


}
