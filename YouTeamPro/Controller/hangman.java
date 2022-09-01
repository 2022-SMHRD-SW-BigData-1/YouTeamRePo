package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import Model1.MemberVO1;

public class hangman {

	Random rd = new Random();
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String a = null;

	public void getCon() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_h_0830_2";
			String db_pw = "smhrd2";

			conn = DriverManager.getConnection(url, db_id, db_pw);

			if (conn != null) {
				System.out.println("접속 성공");
			} else {
				System.out.println("접속 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("자원반납 시 오류");
		}
	}

	public String getword(String word) {
		int num1 = 0;
		int num2 = 0;
		ResultSet cnt = null;
		MemberVO1 words = null;

		try {
			getCon();

			if (num1 == 1 && num2 == 1) {
				String sql = "select * from(" + " select * from word" + " order by DBMS_RANDOM.RANDOM"
						+ ") where rownum < 2";
				psmt = conn.prepareStatement(sql);
				cnt = psmt.executeQuery();
				if (cnt.next()) {
					a = cnt.getString("word");
					words = new MemberVO1(a);
					a = words.getwords();
				} else {
					words = null;
				}
			} else if (num1 == 1 && num2 == 2) {
				String sql = "select * from(" + " select * from word" + " order by DBMS_RANDOM.RANDOM"
						+ ") where rownum < 2";
				psmt = conn.prepareStatement(sql);
				cnt = psmt.executeQuery();
				if (cnt.next()) {
					a = cnt.getString("word");
					words = new MemberVO1(a);
					a = words.getwords();
				} else {
					words = null;
				}
			}
			if (num1 == 2 && num2 == 1) {
				String sql = "select * from(" + " select * from word" + " order by DBMS_RANDOM.RANDOM"
						+ ") where rownum < 2";
				psmt = conn.prepareStatement(sql);
				cnt = psmt.executeQuery();
				if (cnt.next()) {
					a = cnt.getString("word");
					words = new MemberVO1(a);
					a = words.getwords();
				} else {
					words = null;
				}
			} else if (num2 == 1 && num2 == 2) {
				String sql = "select * from(" + " select * from word" + " order by DBMS_RANDOM.RANDOM"
						+ ") where rownum < 2";
				psmt = conn.prepareStatement(sql);
				cnt = psmt.executeQuery();
				if (cnt.next()) {
					a = cnt.getString("word");
					words = new MemberVO1(a);
					a = words.getwords();
				} else {
					words = null;
				}
			}
			if (num1 == 3) {
				String sql = "select * from(" + " select * from word" + " order by DBMS_RANDOM.RANDOM"
						+ ") where rownum < 2";
				psmt = conn.prepareStatement(sql);
				cnt = psmt.executeQuery();
				if (cnt.next()) {
					a = cnt.getString("word");
					words = new MemberVO1(a);
					a = words.getwords();
				} else {
					words = null;
				}
			}
			char[] q = new char[a.length()];
			char[] p = new char[a.length()];

			for (int i = 0; i < q.length; i++) {
				q[i] = a.charAt(i);
				p[i] = '_';
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return a;
	}
}
