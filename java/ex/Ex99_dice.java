package excu01_java1;

import java.util.Scanner;

public class Ex99_dice {
	
	
	int diceFace;
	int userGuess;
	
	private void RollDice() {
		diceFace = (int)(Math.random()*6)+1;
		System.out.println("주사위 값 => "+diceFace);// 숫자 6범위 내 랜덤 숫자 생성
	}
	private int getUserInput(String prompt) {
		System.out.println(prompt);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt()	;
	}
	private void checkUserGuess() {
		if(diceFace == userGuess) System.out.println("맞았습니다.");
		else System.out.println("틀렸습니다.");
	}
	public void startPlaying() {
		userGuess = getUserInput("1~6 사이의 값을 입력하시오.");
		if(userGuess<1 || userGuess>6) {
			System.out.println("허용된 값이 아닙니다.");
			return;
		}
		RollDice();
		checkUserGuess();
	}
	public static void main(String[] args) {
		Ex99_dice game = new Ex99_dice();
		game.startPlaying();
		
	}
}
