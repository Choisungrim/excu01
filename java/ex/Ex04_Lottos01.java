package j04_array;
import java.util.*;
public class Ex04_Lottos01 {

	public static void main(String[] args) {
		//1. 배열 생성 ㅣ lotto
			int lotto[] = new int[6];
		//2. Random 으로 배열 초기화
			Random rn = new Random();
			// ** 주의
		    // for (int i=0; i<=lotto.length; i++) {
		    // => java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
			for(int i=0;i<lotto.length;i++) {
				
				//3. Random 
				// Random 함수는 나머지 연산과 연관
				lotto[i] = rn.nextInt(45)+1; // 정수/45 -> 나머지 값의 범위 0~44
				System.out.println(""+lotto[i]);
				
				//4. ** 중복값 확인하기.
				//동일한 값이 존재하는지 확인(동일 자료 찾아보기 : search)
				for(int j=0;j<i;j++) { // int j = 0; j <= i-1; j++
					if(lotto[i]==lotto[j]) {
						--i; 
						break;
					}// if
				}// for j
			}//for i
			
		//3. 출력
			System.out.println("** 로또 당첨 번호 => \n"+Arrays.toString(lotto));
			
			//5. 최대값 & 최소값 출력
			int max =lotto[0], min=lotto[0];
			for(int i =1; i<lotto.length; i++) {
				if(max<lotto[i]) 
					max = lotto[i];
				if(min>lotto[i])
					min = lotto[i];
				}
			System.out.println(max);
			System.out.println(min);
			//6. 오름차순 정렬
			
	}//main

}//class
