package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Controller.DAO;
import Controller.hangman;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		
		while (true) {
			System.out.println("[1]회원가입 [2]로그인 [3]전체랭킹확인 [4]회원탈퇴 [5]게임종료");
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("==========등록==========");
				System.out.print("ID : ");
				String id = sc.next();
				System.out.print("PW : ");
				String pw = sc.next();
				System.out.print("nick : ");
				String nick = sc.next();
				dao.getCon();
				
				
				
				int cnt = dao.join(id, pw, nick);
				if (cnt > 0) {
					System.out.println("등록 성공");
				} else {
					System.out.println("등록 실패");
				}
			} else if (menu == 2) {

				System.out.print("ID : ");
				String id = sc.next();
				System.out.print("PW : ");
				String pw = sc.next();
				boolean res = dao.login(id, pw);
				if (res == true) {
					System.out.println("로그인 성공");
				} else {
					System.out.println("로그인 실패");
				}

			} else if (menu == 3) {
				// 수민팀장님
			} else if (menu == 4) {
				System.out.println("ID : ");
				String id = sc.next();
				System.out.println("PW : ");
				int pw = sc.nextInt();
				dao.delete(id);
			} else if (menu == 5) {
				System.out.println("게임 종료");
				break;
			}

		}
	}
}
