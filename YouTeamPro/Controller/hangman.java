package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import Model.MemberVO;

public class hangman {
	static int score = 0;
	static int scorePlus = 0;
	static int count = 0;

	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String answerWord = null;
	DAO dao = new DAO();

	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_h_0830_2";
			String db_pw = "smhrd2";

			conn = DriverManager.getConnection(url, db_id, db_pw);
		} catch (Exception e) {
			System.out.println("오류");
			e.printStackTrace();
		}
	}

	public int[] getword() {
		getCon();
		int life = 3;
		int[] rt = new int[2];
		int resultTime = 0;
		while (true) {
			count = 0;
			int num1 = 1;
			int num2 = 1;
			ResultSet rs;
			MemberVO words;
			System.out.print("난이도 선택 : \n[1]EASY [2]NORMAL [3]HARD    ");
			num1 = sc.nextInt();
			switch (num1) {
			case 1:
				System.out.print("카테고리선택 : \n[1]동물 [2]나라    ");
				num2 = sc.nextInt();
				break;
			case 2:
				System.out.print("카테고리선택 : \n[1]음식 [2]브랜드명    ");
				num2 = sc.nextInt();
				break;
			}

			try {

				if (num1 == 1 && num2 == 1) {
					while (count < 5) {

						String sql = "select * from( select * from game where type = 'animal' order by DBMS_RANDOM.RANDOM) where rownum < 2";
						psmt = conn.prepareStatement(sql);
						rs = psmt.executeQuery();
						if (rs.next()) {
							answerWord = rs.getString("word");
							System.out.println(answerWord);
							words = new MemberVO(answerWord);
							System.out.println(answerWord);
							scorePlus = 200;
							System.out.println("life : " + life);
							playGame(answerWord, life);
						} else {
							words = null;
						}
						if (life == 0) {
							break;
						}
					}
				} else if (num1 == 1 && num2 == 2) {
					while (count < 5) {
						String sql = "select * from(" + " select * from game where type = 'country'"
								+ " order by DBMS_RANDOM.RANDOM" + ") where rownum < 2";
						psmt = conn.prepareStatement(sql);
						rs = psmt.executeQuery();
						if (rs.next()) {
							answerWord = rs.getString("word");
							words = new MemberVO(answerWord);
							scorePlus = 200;
							playGame(answerWord, life);
						} else {
							words = null;
						}
					}
				}
				if (num1 == 2 && num2 == 1) {
					while (count < 5) {
						String sql = "select * from(" + " select * from game where type = 'food'"
								+ " order by DBMS_RANDOM.RANDOM" + ") where rownum < 2";
						psmt = conn.prepareStatement(sql);
						rs = psmt.executeQuery();
						if (rs.next()) {
							answerWord = rs.getString("word");
							words = new MemberVO(answerWord);
							scorePlus = 250;
							playGame(answerWord, life);
						} else {
							words = null;
						}
					}
				} else if (num2 == 2 && num2 == 2) {
					while (count < 5) {

						String sql = "select * from(" + " select * from game where type = 'brand'"
								+ " order by DBMS_RANDOM.RANDOM" + ") where rownum < 2";
						psmt = conn.prepareStatement(sql);
						rs = psmt.executeQuery();
						if (rs.next()) {
							answerWord = rs.getString("word");
							words = new MemberVO(answerWord);
							scorePlus = 250;
							playGame(answerWord, life);
						} else {
							words = null;
						}
					}
				}
				if (num1 == 3) {
					while (count < 5) {

						String sql = "select * from(" + " select * from game where type = 'name'"
								+ " order by DBMS_RANDOM.RANDOM" + ") where rownum < 2";
						psmt = conn.prepareStatement(sql);
						rs = psmt.executeQuery();
						if (rs.next()) {
							answerWord = rs.getString("word");
							words = new MemberVO(answerWord);
							scorePlus = 300;
							playGame(answerWord, life);
						} else {
							words = null;
						}
					}
				}
				while (true) {
					System.out.println("계속하시겠습니까(y/n)");
					String a = sc.next();
					String b = "n";
					String c = "y";
					if (a.equals(b)) {
						System.out.println("게임 종료");
						dao.close();
						System.out.println(score);
						rt[0] = score;
						rt[1] = resultTime;
						return rt;

					} else if (a.equals(c)) {
						break;

					} else {
						System.out.println("다시입력해주세요");
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dao.close();
			}
			if (life < 0) {
				System.out.println("게임 종료");
				dao.close();
				System.out.println(score);
				rt[0] = score;
				rt[1] = resultTime;
				return rt;
			}
		}

	}

	public static int playGame(String answerWord, int life) {
		Scanner sc = new Scanner(System.in);
		char[] problem = new char[answerWord.length()];
		char[] answer = new char[answerWord.length()];

		for (int i = 0; i < problem.length; i++) {
			problem[i] = answerWord.charAt(i);
			answer[i] = '_';
		}
		int chance = 1;
		while (true) {

			for (int i = 0; i < answer.length; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			for (int i = 0; i < answer.length; i++) {
				System.out.print(problem[i] + " ");
			}
			System.out.println();
			boolean check = false;
			boolean checkreal = false;
			System.out.print("영어단어를 입력하세요. : ");
			char input = sc.next().charAt(0);
			for (int i = 0; i < answer.length; i++) {
				if (input == problem[i]) {
					answer[i] = input;
					check = true;
				}
			}
			for (int i = 0; i < answer.length; i++) {
				if (answer[i] != problem[i]) {
					checkreal = false;
					break;
				}
				checkreal = true;
			}
			if (check == false) {
				chance--;
			}
			if (checkreal == true) {
				System.out.println("성공");
				score = score + scorePlus;
				System.out.println("점수  : " + score);
				count++;
				break;
			}
			if (chance == 0) {
				life--;
				System.out.println("life : " + life);
				System.out.println("실패");
				return life;
			}
			if(life == 0) {
				return life;
			}
		}
	}
}
