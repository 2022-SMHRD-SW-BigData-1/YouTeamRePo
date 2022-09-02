package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Model.MemberVO;

public class hangman {

	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String answerWord = null;
	DAO dao = new DAO();

	public void getword() {
		int life = 3;
		while (true) {
			int score = 0;
			int scorePlus = 0;
			int num1 = 1;
			int num2 = 1;
			ResultSet cnt = null;
			MemberVO words = null;

			try {
				dao.getCon();

				if (num1 == 1 && num2 == 1) {
					String sql = "select * from(" + " select * from game where type = 'animal'"
							+ " order by DBMS_RANDOM.RANDOM" + ") where rownum < 2";
					psmt = conn.prepareStatement(sql);
					cnt = psmt.executeQuery();
					if (cnt.next()) {
						answerWord = cnt.getString("word");
						words = new MemberVO(answerWord);
						answerWord = words.getwords();
						scorePlus = 200;
					} else {
						words = null;
					}
				} else if (num1 == 1 && num2 == 2) {
					String sql = "select * from(" + " select * from game where type = 'country'"
							+ " order by DBMS_RANDOM.RANDOM" + ") where rownum < 2";
					psmt = conn.prepareStatement(sql);
					cnt = psmt.executeQuery();
					if (cnt.next()) {
						answerWord = cnt.getString("word");
						words = new MemberVO(answerWord);
						answerWord = words.getwords();
						scorePlus = 200;
					} else {
						words = null;
					}
				}
				if (num1 == 2 && num2 == 1) {
					String sql = "select * from(" + " select * from game where type = 'food'"
							+ " order by DBMS_RANDOM.RANDOM" + ") where rownum < 2";
					psmt = conn.prepareStatement(sql);
					cnt = psmt.executeQuery();
					if (cnt.next()) {
						answerWord = cnt.getString("word");
						words = new MemberVO(answerWord);
						answerWord = words.getwords();
						scorePlus = 250;
					} else {
						words = null;
					}
				} else if (num2 == 1 && num2 == 2) {
					String sql = "select * from(" + " select * from game where type = 'brand'"
							+ " order by DBMS_RANDOM.RANDOM" + ") where rownum < 2";
					psmt = conn.prepareStatement(sql);
					cnt = psmt.executeQuery();
					if (cnt.next()) {
						answerWord = cnt.getString("word");
						words = new MemberVO(answerWord);
						answerWord = words.getwords();
						scorePlus = 250;
					} else {
						words = null;
					}
				}
				if (num1 == 3) {
					String sql = "select * from(" + " select * from game where type = 'name'"
							+ " order by DBMS_RANDOM.RANDOM" + ") where rownum < 2";
					psmt = conn.prepareStatement(sql);
					cnt = psmt.executeQuery();
					if (cnt.next()) {
						answerWord = cnt.getString("word");
						words = new MemberVO(answerWord);
						answerWord = words.getwords();
						scorePlus = 300;
					} else {
						words = null;
					}
				}
				char[] problem = new char[answerWord.length()];
				char[] answer = new char[answerWord.length()];

				for (int i = 0; i < problem.length; i++) {
					problem[i] = answerWord.charAt(i);
					answer[i] = '_';
				}
				Arrays.toString(answer);
				int chance = 6;
				while (true) {
					boolean check = false;
					System.out.print("영어단어를 입력하세요. : ");
					char input = sc.next().charAt(0);
					for (int i = 0; i < answer.length; i++) {
						if (input == problem[i]) {
							answer[i] = input;
							check = true;
						}
					}
					if (check == false) {
						chance--;
					}
					if (answer == problem) {
						score = score + scorePlus;
						break;
					}
					if (chance == 0) {
						life--;
						break;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dao.close();
			}
			if (life == 0) {
				System.out.println("게임 종료");
				break;
			}

		}

	}
}
