package j02_ifSwitch;
import java.time.LocalDate;
import java.util.*;
//** 실습 : 
//1. 월을 입력 받아서 
//2. 몇일까지 인지,  
// => 1,3,5,7,8,10,12월 => ?월은 31일 까지 입니다.
// => 4,6,9,11 월 => ?월은 30일 까지 입니다.
// => 2 월 => ?월은 29일 까지 입니다.
//3. 무슨 계절인지 출력 하기
//  => 3~5:봄 , 6~8:여름, 9~11:가을, 12~2:겨울
	public class Ex05_switchMonth_Rim {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in); // Scanner 생성자 생성
			LocalDate lodyear = LocalDate.now(); // LocalDate 생성자 생성
			int month;	
			int year = lodyear.getYear(); // 현재 년도를 받는 year 변수 선언
			int count=0;
			System.out.println(year); // 현재 년도 출력
			
			// 무한루프를 통해 입력을 지속적으로 받음
			while(true) {  
				
				// 3회 이상 입력 시 프로그램 종료
				while(count<3) { 
				System.out.println("월을 입력해 주세요 =>");
				month = sc.nextInt();
				count++;	
				
				//입력 값에 대해 유효성검사
				if(month<1 || month>12) {
					System.out.printf("%d 월은 없는 월입니다.",month);
				}
				if(count == 3) {
					System.out.println("3회 이상 틀리셨으므로 프로그램을 종료합니다.");	
				} 
			
				//만족하는 입력 값에 대해 case 출력
				
			if(month >= 1 && month <=12) {
				switch(month) {
					case 1:
						System.out.printf("%d 월은 31일 까지입니다.\n",month);
						System.out.printf("%d 월은 겨울 입니다..",month);
						break;
					case 2:
						// ** 윤년 적용하기
				         // =>  4로  나눠지면서 100으로는 나눠지지 않거나  400으로는 나눠지는 해 (year)
							if(year%4 == 0 || year%100!=0 || year%400==0) {
								System.out.println(year+ "년의" +month+ "월은 28일 까지입니다 \n");
							}else
						System.out.printf("%d 월은 29일 까지입니다.\n",month);
						System.out.printf("%d 월은 겨울 입니다..",month);
						break;
					case 3:
						System.out.printf("%d 월은 31일 까지입니다.\n",month);
						System.out.printf("%d 월은 봄 입니다..",month);
						break;
					case 4:
						System.out.printf("%d 월은 30일 까지입니다.\n",month);
						System.out.printf("%d 월은 봄 입니다..",month);
						break;
					case 5:
						System.out.printf("%d 월은 31일 까지입니다.\n",month);
						System.out.printf("%d 월은 봄 입니다..",month);
						break;
					case 6:
						System.out.printf("%d 월은 30일 까지입니다.\n",month);
						System.out.printf("%d 월은 여름 입니다..",month);
						break;
					case 7:
						System.out.printf("%d 월은 31일 까지입니다.\n",month);
						System.out.printf("%d 월은 여름 입니다..",month);
						break;
					case 8:
						System.out.printf("%d 월은 31일 까지입니다.\n",month);
						System.out.printf("%d 월은 여름 입니다..",month);
						break;
					case 9:
						System.out.printf("%d 월은 30일 까지입니다.\n",month);
						System.out.printf("%d 월은 가을 입니다..",month);
						break;
					case 10:
						System.out.printf("%d 월은 31일 까지입니다.\n",month);
						System.out.printf("%d 월은 가을 입니다..",month);
						break;
					case 11:
						System.out.printf("%d 월은 30일 까지입니다.\n",month);
						System.out.printf("%d 월은 가을 입니다..",month);
						break;
					case 12:
						System.out.printf("%d 월은 31일 까지입니다.\n",month);
						System.out.printf("%d 월은 겨울 입니다..",month);
						break;
					default : 
						System.out.println("없는 월입니다.");
						}//switch
				break;
					} // if
				} //while count
			break;
		}// while infinity
	
	}// main
}//class	
			


