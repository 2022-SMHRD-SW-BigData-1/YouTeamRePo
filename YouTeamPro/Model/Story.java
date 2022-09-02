package Model;

import java.io.IOException;
import java.util.Scanner;

public class Story {
	// 글자 멈춤 메소드
	
		private static void pause() {
			try { System.in.read();} catch(IOException e) {}
		}
		
		// 글자 천천히 출력 메소드

		public static void slowPrint(String message, long millisPerChar) {
			try {
				for (int i = 0; i < message.length(); i++) {
					System.out.print(message.charAt(i));
					Thread.sleep(millisPerChar);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 메인 타이틀
		
		public static void title() {
			slowPrint("⠀⠀도트삽입⠀⠀",10); // 옆에 숫자는 출력되는 글자들 빠르기 조절
			System.out.println();
		}
		// 오프닝 멘트
		
			public static void opening(){
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter 키를 누르시면 스토리가 진행됩니다.");
				pause();pause();
				String[] openingText1 = {"잊혀진 고대왕국의 주인인 사막황제의 무덤이 발견되었다는 소식이 왕국전체에 퍼졌다","\t","왕국최고의 트레져헌터팀인 우리는 소식이 퍼지기 전에 미리 무덤입구 앞에 도달했다","\t","입구에는 고대속 괴수인 스핑크스가 그려져 있었다","\t"
						+"겨우겨우 숨겨진 입구를 찾아왔건만 스핑크스가 지키는 무덤일 줄은 상상도 못했다","\t","하지만 우리가 누군가 왕국 최고의 트레져헌터팀인데 스핑크스가 무서워서 도굴을 포기 할 순 없지 않나?","\t","고민하던 우리는 결국 무덤안으로 몸을 날렸다"};
				for(int i = 0; i<openingText1.length; i++) {
					slowPrint(openingText1[i]+"\n", 20);
				}
				String[] openingText2 = {"우리는 무덤안에 들어가지 말았어야 했.. 다..."};
				for(int i = 0; i<openingText2.length; i++) {
					slowPrint(openingText2[i]+"\n", 50);
				}
				String[] openingText3 = {"생각보다 별거 없는데 얼른 보물방 찾아서 도굴하고 돌아가ㅈㅏ...","\t","콰아아아!!! 누구누구야 살려줘!!! 누가 다리를 붙잡고있어!","\t","돌아가라고 친절하게 그림까지 그려 놨건만 내가 없는줄 알고 들어왔지?","\t"
						+"내가 내는 문제를 맞추지 못하면 니 친구는 내 뱃속으로 다이빙이다","\t","나 스핑크스가 내는 문제를 맞춰서 친구를 살려봐라!!!!"};
				for(int i = 0; i<openingText3.length; i++) {
					slowPrint(openingText3[i]+"\n", 20);
				}
				String[] openingText4 = {"규칙을 설명하겠다!","\t","내가 무작위로 내는 영어 단어를 찍어서 맞추는 게임이다","\t","알파벳이 틀릴때마다 친구 팔 다리 하나씩 내가 먹겠다 팔2개 다리2개 마지막은 머리다!","\t","머리가 먹혀도 내가 2번은 부활시킬 수 있다 걱정말고 도전해라!!"};
				for(int i = 0; i<openingText4.length; i++) {
					slowPrint(openingText4[i]+"\n", 20);
				}
				String[] openingText5 = {"어자피 도둑놈의 인생 이렇게 될 줄 알고있었다 버리고 도망갈까? (Y/N)"};
				for(int i = 0; i<openingText5.length; i++) {
					slowPrint(openingText5[i]+"\n", 20);
				}
				while(true) {
				System.out.print("입력해주세요 : ");
				String click = sc.next();
				if (click.equals("Y")) {
					System.out.println();
					slowPrint("의리도 없는 놈 같으니라고 너부터 먹어야 겠다",10);
					System.out.println();
					System.out.println();
					break;
				}else if(click.equals("N")){
					slowPrint("맞춰봐라! 틀릴때마다 니 친구의 팔 다리는 내가 맛보겠다!",10);
					System.out.println();
					System.out.println();
					break;
				}else {
					slowPrint("잘못 입력하셨습니다.",10);
					System.out.println();
				}
			}
			}
			}