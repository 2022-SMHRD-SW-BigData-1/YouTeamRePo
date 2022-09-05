package View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.DAO;
import Controller.MusicPlayer;
import Controller.hangman;
import Model.MemberVO;
import Model.MusicVO;
import Model.Story;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		hangman play = new hangman();
		int menu = 0;
		String id = null;
		int[] rt = new int[2];
		
		Story s = new Story();
		s.title();
		s.opening1();
		s.opening2
		();
		
		while (true) {
			System.out.print("[1]회원가입 [2]로그인 [3]전체랭킹확인 [4]회원탈퇴 [5]게임종료>> ");
			MusicPlayer player = new MusicPlayer();
			MusicVO m = player.play(3);
			menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("==========등록==========");
				System.out.print("아이디 >> ");
				id = sc.next();
				System.out.print("비밀번호 >> ");
				String pw = sc.next();
				System.out.print("닉네임 >> ");
				String nick = sc.next();
				dao.getCon();
				int cnt = dao.join(id, pw, nick);
				if (cnt > 0) {
					System.out.println("회원가입 되었습니다.");
				} else {
					System.out.println("다른 회원이 있습니다.");
				}
			} else if (menu == 2) {
				System.out.print("아이디 : ");
				id = sc.next();
				System.out.print("비밀번호 : ");
				String pw = sc.next();
				boolean res = dao.login(id, pw);
				if (res == true) {
					player.stop();
					System.out.println("로그인 SUCCESS!");
					rt = play.getword();
					int score = rt[0];
					int time = rt[1];
					String grade = "";
					dao.lastScoreTime(id, time, score, grade);
				} else {
					System.out.println("로그인 Fail..");
				}
			} else if (menu == 3) {
				ArrayList<MemberVO> list = dao.select();
				System.out.println("ID\t닉네임\t점수\t티어\t플레이타임");
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i).getId() + "\t");
					System.out.print(list.get(i).getNick() + "\t");
					System.out.print(list.get(i).getScore() + "\t");
					System.out.print(list.get(i).getGrade() + "\t");
					System.out.println(list.get(i).getTimes() / 1000.0 + "초\t");
				}
			} else if (menu == 4) {
				System.out.print("아이디 >> ");
				id = sc.next();
				System.out.print("비밀번호 >> ");
				String pw = sc.next();
				int cnt = dao.delete(id);
				if (cnt > 0) {
					System.out.println("탈퇴가 완료되었습니다!");
				} else {
					System.out.println("탈퇴에 실패하였습니다.");
				}
			} else if (menu == 5) {
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
	}
}
