package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Model.MemberVO;
import Model.MusicVO;
import Model.Story;

public class hangman {
	static int score = 0;
	static int scorePlus = 0;
	static int count = 0;
	static long totalTime = 0;
	Story s = new Story();

	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String answerWord = null;
	DAO dao = new DAO();
	static int life = 3;

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
		MusicPlayer player = new MusicPlayer();
		getCon();
		int[] rt = new int[2];
		long resultTime = 0;
		long minus = 0;

		while (true) {
			ArrayList<String> Duplicate = new ArrayList();
			Duplicate.add("null");
			count = 0;
			int num1 = 1;
			int num2 = 1;
			ResultSet rs;
			MemberVO words;
		
			player.stop();
			MusicVO m = player.play(4);
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
					resultTime = System.currentTimeMillis();
					while (count < 5) {
						while (true) {
							String sql = "select * from( select * from game where type = 'animal' order by DBMS_RANDOM.RANDOM) where rownum < 2";
							psmt = conn.prepareStatement(sql);
							rs = psmt.executeQuery();
							if (rs.next()) {
								answerWord = rs.getString("word");
								words = new MemberVO(answerWord);
								scorePlus = 200;
							} else {
								words = null;
							}
							boolean Ducheck = DuCheck(Duplicate);

							if (Ducheck == false) {
								break;
							}
						}
						Duplicate.add(answerWord);
						playGame(answerWord);
						if (life == 0) {
							
							death();
							player.stop();
							System.out.println("게임실행 시간 : " + totalTime / 1000.0 + "초");
							life = 3;
							break;
						}
						long resultTimeend = System.currentTimeMillis();
						minus = (resultTimeend - resultTime);
						totalTime += minus;
					}

				} else if (num1 == 1 && num2 == 2) {
					resultTime = System.currentTimeMillis();
					while (count < 5) {
						while (true) {
							String sql = "select * from(" + " select * from game where type = 'country'"
									+ " order by DBMS_RANDOM.RANDOM" + ") where rownum < 2";
							psmt = conn.prepareStatement(sql);
							rs = psmt.executeQuery();
							if (rs.next()) {
								answerWord = rs.getString("word");
								words = new MemberVO(answerWord);
								scorePlus = 200;
							} else {
								words = null;
							}
							boolean Ducheck = DuCheck(Duplicate);

							if (Ducheck == false) {
								break;
							}
						}
						Duplicate.add(answerWord);
						playGame(answerWord);
						if (life == 0) {
							
							death();
							player.stop();
							System.out.println("게임실행 시간 : " + totalTime / 1000.0 + "초");
							life = 3;
							break;
						}
						long resultTimeend = System.currentTimeMillis();
						minus = (resultTimeend - resultTime);
						totalTime += minus;
					}
				}
				if (num1 == 2 && num2 == 1) {
					resultTime = System.currentTimeMillis();
					while (count < 5) {
						while (true) {
							String sql = "select * from(" + " select * from game where type = 'food'"
									+ " order by DBMS_RANDOM.RANDOM" + ") where rownum < 2";
							psmt = conn.prepareStatement(sql);
							rs = psmt.executeQuery();
							if (rs.next()) {
								answerWord = rs.getString("word");
								words = new MemberVO(answerWord);
								scorePlus = 250;
							} else {
								words = null;
							}
							boolean Ducheck = DuCheck(Duplicate);

							if (Ducheck == false) {
								break;
							}
						}
						Duplicate.add(answerWord);
						playGame(answerWord);
						if (life == 0) {
							
							death();
							player.stop();
							System.out.println("게임실행 시간 : " + totalTime / 1000.0 + "초");
							life = 3;
							break;
						}
						long resultTimeend = System.currentTimeMillis();
						minus = (resultTimeend - resultTime);
						totalTime += minus;
					}
				} else if (num1 == 2 && num2 == 2) {
					resultTime = System.currentTimeMillis();
					while (count < 5) {
						while (true) {
							String sql = "select * from(" + " select * from game where type = 'brand'"
									+ " order by DBMS_RANDOM.RANDOM" + ") where rownum < 2";
							psmt = conn.prepareStatement(sql);
							rs = psmt.executeQuery();
							if (rs.next()) {
								answerWord = rs.getString("word");
								words = new MemberVO(answerWord);
								scorePlus = 250;
							} else {
								words = null;
							}
							boolean Ducheck = DuCheck(Duplicate);

							if (Ducheck == false) {
								break;
							}
						}
						Duplicate.add(answerWord);
						playGame(answerWord);
						if (life == 0) {
							
							death();
							player.stop();
							System.out.println("게임실행 시간 : " + totalTime / 1000.0 + "초");
							life = 3;
							break;
						}
						long resultTimeend = System.currentTimeMillis();
						minus = (resultTimeend - resultTime);
						totalTime += minus;
					}
				}
				if (num1 == 3) {
					resultTime = System.currentTimeMillis();
					while (count < 5) {
						while (true) {
							String sql = "select * from(" + " select * from game where type = 'name'"
									+ " order by DBMS_RANDOM.RANDOM" + ") where rownum < 2";
							psmt = conn.prepareStatement(sql);
							rs = psmt.executeQuery();
							if (rs.next()) {
								answerWord = rs.getString("word");
								words = new MemberVO(answerWord);
								scorePlus = 300;
							} else {
								words = null;
							}
							boolean Ducheck = DuCheck(Duplicate);
							if (Ducheck == false) {
								break;
							}
						}
						Duplicate.add(answerWord);
						playGame(answerWord);
						Duplicate.add(answerWord);
						playGame(answerWord);
						if (life == 0) {
							
							death();
							player.stop();
							System.out.println("게임실행 시간 : " + totalTime / 1000.0 + "초");
							life = 3;
							break;
						}
						long resultTimeend = System.currentTimeMillis();
						minus = (resultTimeend - resultTime);
						totalTime += minus;
					}
				}
				while (true) {
					System.out.println("계속하시겠습니까(y/n)");
					String a = sc.next();
					String b = "n";
					String c = "y";
					if (a.equals(b)) {
						m = player.play(8);
						s.endding();
						dao.close();
						rt[0] = score;
						rt[1] = (int) totalTime;
						player.stop();
						return rt;

					} else if (a.equals(c)) {
						life = 3;
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
		}
	}

	public static int playGame(String answerWord) {
		Scanner sc = new Scanner(System.in);
		MusicPlayer player = new MusicPlayer();
		player.stop();
		MusicVO m;
		char[] problem = new char[answerWord.length()];
		char[] answer = new char[answerWord.length()];
		
		
		System.out.println(""
				+ "				            -@@@=             \r\n"
				+ "				           .@@@@@#            \r\n"
				+ "				           *@@@@@@            \r\n"
				+ "				            #@@@@;            \r\n"
				+ "				             :#=,             \r\n"
				+ "				           ,#@@@@!            \r\n"
				+ "				          !@@@@@@@@,          \r\n"
				+ "				        =@@@@@@@@@@@@,        \r\n"
				+ "				        @@@=@@@@@@:@@*        \r\n"
				+ "				       ;@@,=@@@@@@,=@@.       \r\n"
				+ "				       ;@@ $@@@@@@,;@@.       \r\n"
				+ "				        :- $@@@@@@- :-        \r\n"
				+ "				           #@@!!@@;           \r\n"
				+ "				           @@# ,@@!           \r\n"
				+ "				           @@# .@@*           \r\n"
				+ "				          .@@*  @@$           \r\n"
				+ "				          ~@@~  $@@           \r\n"
				+ "				          :@@-  =@@           \r\n"
				+ "				          ;@@,  =@@.          \r\n"
				+ "				          -@@   :@#         ");
		for (int i = 0; i < problem.length; i++) {
			problem[i] = answerWord.charAt(i);
			answer[i] = '_';
		}
		int chance = 5;
		while (true) {
			System.out.println("life :" + life + "\t" + "남은 찬스 횟수:" + chance);
			for (int i = 0; i < answer.length; i++) {
				System.out.print(answer[i] + " ");
			}
//			System.out.println();
//			for (int i = 0; i < answer.length; i++) {
//				System.out.print(problem[i] + " ");
//			}
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
			if (check == false && chance > 0) {
				chance--;
				if(chance==4) {
					m = player.subPlay(5);
					System.out.println(""
							+ "				            -@@@=             \r\n"
							+ "				           .@@@@@#            \r\n"
							+ "				           *@@@@@@            \r\n"
							+ "				            #@@@@;            \r\n"
							+ "				             :#=,             \r\n"
							+ "				           ,#@@@@!            \r\n"
							+ "				           @@@@@@@@,          \r\n"
							+ "				           @@@@@@@@@@,        \r\n"
							+ "				           =@@@@@@:@@*        \r\n"
							+ "				           =@@@@@@,=@@.       \r\n"
							+ "				           $@@@@@@,;@@.       \r\n"
							+ "				           $@@@@@@- :-        \r\n"
							+ "				           #@@!!@@;           \r\n"
							+ "				           @@# ,@@!           \r\n"
							+ "				           @@# .@@*           \r\n"
							+ "				          .@@*  @@$           \r\n"
							+ "				          ~@@~  $@@           \r\n"
							+ "				          :@@-  =@@           \r\n"
							+ "				          ;@@,  =@@.          \r\n"
							+ "				          -@@   :@#         ");
				}else if(chance==3) {
					m = player.subPlay(5);
					System.out.println(""
							+ "				            -@@@=             \r\n"
							+ "				           .@@@@@#            \r\n"
							+ "				           *@@@@@@            \r\n"
							+ "				            #@@@@;            \r\n"
							+ "				             :#=,             \r\n"
							+ "				           ,#@@@@!            \r\n"
							+ "				           @@@@@@@@,          \r\n"
							+ "				           @@@@@@@@           \r\n"
							+ "				           =@@@@@@:           \r\n"
							+ "				           =@@@@@@,           \r\n"
							+ "				           $@@@@@@,           \r\n"
							+ "				           $@@@@@@-           \r\n"
							+ "				           #@@!!@@;           \r\n"
							+ "				           @@# ,@@!           \r\n"
							+ "				           @@# .@@*           \r\n"
							+ "				          .@@*  @@$           \r\n"
							+ "				          ~@@~  $@@           \r\n"
							+ "				          :@@-  =@@           \r\n"
							+ "				          ;@@,  =@@.          \r\n"
							+ "				          -@@   :@#         ");
				}else if(chance==2) {
					m = player.subPlay(5);
					System.out.println(""
							+ "				            -@@@=             \r\n"
							+ "				           .@@@@@#            \r\n"
							+ "				           *@@@@@@            \r\n"
							+ "				            #@@@@;            \r\n"
							+ "				             :#=,             \r\n"
							+ "				           ,#@@@@!            \r\n"
							+ "				           @@@@@@@@,          \r\n"
							+ "				           @@@@@@@@           \r\n"
							+ "				           =@@@@@@:           \r\n"
							+ "				           =@@@@@@,           \r\n"
							+ "				           $@@@@@@,           \r\n"
							+ "				           $@@@@@@-           \r\n"
							+ "				              !!@@;           \r\n"
							+ "				               ,@@!           \r\n"
							+ "				               .@@*           \r\n"
							+ "				                @@$           \r\n"
							+ "				                $@@           \r\n"
							+ "				                =@@           \r\n"
							+ "				                =@@.          \r\n"
							+ "				                :@#         ");
				}else if(chance==1) {
					m = player.subPlay(5);
					System.out.println(""
							+ "				            -@@@=             \r\n"
							+ "				           .@@@@@#            \r\n"
							+ "				           *@@@@@@            \r\n"
							+ "				            #@@@@;            \r\n"
							+ "				             :#=,             \r\n"
							+ "				           ,#@@@@!            \r\n"
							+ "				           @@@@@@@@,          \r\n"
							+ "				           @@@@@@@@           \r\n"
							+ "				           =@@@@@@:           \r\n"
							+ "				           =@@@@@@,           \r\n"
							+ "				           $@@@@@@,           \r\n"
							+ "				           $@@@@@@-           \r\n"
							+ "\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
				}
			}
			if (checkreal == true) {
				System.out.println("성공");
				score = score + scorePlus;
				System.out.println("점수  : " + score);
				count++;
				break;
			}
			if (chance == 0 && check == false) {
				player.stop();
				m = player.subPlay(6);
				System.out.println("\r\n"
						+ "				            -@@@=             \r\n"
						+ "				           .@@@@@#            \r\n"
						+ "				           *@@@@@@            \r\n"
						+ "				            #@@@@;            \r\n"
						+ "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
				System.out.println("부활했습니다.");
				life--;
				break;

			}

			if (life == 0) {
				
				m = player.play(7);
				System.out.println("죽었습니다.");
				System.out.println("점수  : " + score);
				return score;
			}
		}
		return score;
	}

	public boolean DuCheck(ArrayList<String> Duplicate) {
		for (int i = 0; i < Duplicate.size(); i++) {
			if (answerWord.equals(Duplicate.get(i))) {
				return true;
			}
		}
		return false;
	}
	public void death() {
		MusicPlayer player = new MusicPlayer();
		MusicVO m = player.play(7);
		System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ\r\n"
				+ "ZZZZEEZZZZZZZZZZZZZEEZZZZZZZZZZZZZZEZZZZ\r\n" + "ZZZ9EZZZZZDwZZZZZZ9EZZZZZDwEZZZZZE9ZZZZZ\r\n"
				+ "ZZ9ZZZZZZZZZZZZZZ9ZZZZZZZZZZZZZZEZZZZZZE\r\n" + "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ\r\n"
				+ "ZZZZZZZZZZEZ8ZZZZZZZZZZZZZZ8ZEZZZZZZZZZZ\r\n" + "ZZZz9Z9Z9     zZZZB8ZZZZZZ     ZZjZZZZZZ\r\n"
				+ "ZZZZZZ     ZZw  ZZz9ZZZZ  wZZ     ZZZZZZ\r\n" + "ZZZZ ZZZ   BZw   ZZZZZZ   wZB   ZZZ zZZZ\r\n"
				+ "ZZZZ ZZZ   ZZ    ZZZZZZ    ZZ   ZZZ ZZZZ\r\n" + "ZZZ   ZZZ9       ZZEEZZ       8ZZZ   ZZZ\r\n"
				+ "ZZZ  Z,ZZZZEEZZZ ZZZZZZ ZEz9ZZZZZyZ  ZZZ\r\n" + "ZZZZ   ZDZZZZZZZZ      ZZZZZZZZEz   ZZZZ\r\n"
				+ "ZZZZZ     jZZZZZZZZ  9ZZZZZZZW     ZZZZZ\r\n" + "ZZZZZZ  y w   jzDZ    Z58j    w   ZZZZZZ\r\n"
				+ "ZZZ58ZZZ  y  Z Z ZZ  ZZ Z Z y   ZZZZZZZZ\r\n" + "ZZZ8ZZZZZD       B Z  y w 5   8ZZZZZZZZE\r\n"
				+ "ZZZZZZZZZZZZZ9,D   W B Wy,DZZZZZZZZZZZZZ\r\n" + "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ\r\n"
				+ "ZZZZ9EZZZZZEZZZZZZZEZZZZZZEZZZZZZZ9EZZZZ\r\n" + "ZZZ9ZZZZZZByZZZZZZ9ZZZZZZBjEZZZZZ9EZZZZZ\r\n"
				+ "ZZEZZZZZZZZZZZZZZEZZZZZZZZZZZZZZEZZZZZZZ\r\n" + "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
	}

}
