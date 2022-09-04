package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.MemberVO;

public class DAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_h_0830_2";
			String db_pw = "smhrd2";

			conn = DriverManager.getConnection(url, db_id, db_pw);

//			if (conn != null) {
//				System.out.println("접속 성공");
//			} else {
//				System.out.println("접속 실패");
//			}
		} catch (Exception e) {
			System.out.println("오류");
			e.printStackTrace();
		}
	}

	public void close() {
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

	// 회원가입
	public int join(String id, String pw, String nick) {
		int cnt = 0;
		try {
			getCon();
			String sql = "insert into user_info(id, pw, nick) values (?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, nick);
			System.out.println(conn);

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 로그인
	public boolean login(String id, String pw) {

		try {
			getCon();

			String sql = "select pw from user_Info where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).contentEquals(pw)) {
					return true; // 로그인 성공

				}

			}
			return false; // 비밀번호 불일치

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	// 3.전체 랭킹확인 -> 수민팀장님
	public ArrayList<MemberVO> select() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			getCon();
			String sql = "select * from user_info";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String nick = rs.getString("nick");
				int score = rs.getInt("score");
				String grade = rs.getString("grade");
				int times = rs.getInt("times");

				MemberVO vo = new MemberVO(id, nick, score, grade, times);
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("오류");
			e.printStackTrace();

		} finally {
			close();
		}
		return list;

	}

	// 4.탈퇴
	public int delete(String id) {
		int cnt = 0;
		try {
			getCon();
			String sql = "delete from user_Info where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public int lastScoreTime(String id, int time, int score, String grade) {
		int cnt = 0;
		try {
			getCon();
			String sql = "update user_Info set score = ? ,times = ?, grade = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, score);
			psmt.setInt(2, time);
			psmt.setString(3, grade);
			psmt.setString(4, id);
			cnt = psmt.executeUpdate();
			System.out.println("아이디 : " + id + "\t점수 : " + score + "\t 시간 : " + time/1000.0+"초\t"+"티어 : "+grade);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

}
