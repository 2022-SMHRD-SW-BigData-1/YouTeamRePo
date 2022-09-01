package Controller;

import java.util.Scanner;

public class InputAlphabet {
	int chance = 6;

	public char[] InputAlph(char input,char[] answer,char[] problem) {
		boolean check = false;
		while(chance > 0 && answer != problem)
		for (int i = 0; i < answer.length; i++) {
			if (input == problem[i]) {
				answer[i] = input;
				check = true;

			}
		}
		if(check == false) {
			chance --;
		}
		return answer;

	}

}
