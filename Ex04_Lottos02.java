package j04_array;
import java.util.*;
public class Ex04_Lottos02 {
	public static void main(String[] args) {
		// 1) 배열 생성 : lotto
	      int[] lotto = new int[6];
	      
	      // 2) Random으로 배열 초기화
	      Random rn = new Random();
	      
	      for (int i=0; i<lotto.length; i++) {
	         // random number추출 & 배열에 담기
	         lotto[i]=rn.nextInt(45)+1;  // 정수/45 -> 나머지값의 범위 0 ~ 44
	         System.out.println(""+lotto[i]);
	         // 3) 중복값 확인하기
	         for (int j=0; j<i; j++) {
	            if (lotto[i]==lotto[j]) {
	               --i; break;
	            } //if
	         } //for_j
	      } //for
	      // 4) 출력
	      System.out.println("** Lotto => "+Arrays.toString(lotto));
	      
	      // 5) 오름차순 정렬 -> 최솟값 정렬 // 내립차순 정렬 -> 최댓값 정렬
	      // => 순차정렬 (Sequence Sort)
	      // => 정렬 알고리즘에서 가장 간단하고 기본이되는 알고리즘으로
	      //    배열의 처음과 끝을 탐색하면서 차순대로 정렬하는 가장 기초적인 정렬 알고리즘
	      // ** 정렬 알고리즘 : 삽입(insert)정렬, 합병(Merge)정렬, 퀵(Quick)정렬...
	      // => https://blog.naver.com/tepet/221690306235
	      int temp=0;
	      for(int i=0;i<lotto.length;i++) {
	    	  for(int j=i+1;j<lotto.length;j++) {
	    		  //if(lotto[i]>lotto[j] // ** 내림차순 => i보다 큰 j가 있으면 서로 맞바꾼다.
	    		  if(lotto[i]>lotto[j]) { // **오름차순 => i보다 작은 j가있으면 서로 맞바꾼다.
		    		  temp = lotto[i];
		    		  lotto[i] = lotto[j];
		    		  lotto[j] = temp;
	    	  	}//if
	    	  }//for j
	      }//for i
	      System.out.println("** Lotto2 => "+Arrays.toString(lotto));
	      
	      // 6) WrapperClass : Arrays
	      // => toString(), sort(), equals( , )// equals 안에 데이터값이 같은지를 비교
	      int[] myLotto = {13,7,5,2,19,34};
	      Arrays.sort(myLotto);
	      System.out.println("** my Lotto => "+Arrays.toString(myLotto));
	      
	      if(Arrays.equals(lotto, myLotto))System.out.println("당첨!!!");
	      else System.out.println("다음기회에 ....");
	}//main
}//class
