package javaTest;

import java.util.Arrays;

public class Ex90_Student extends Ex90_Person {
	// 같은 패키지에서 접근가능한 변수 3개정의
	public int java, html, sum;
	
	// 서브클래스의 변수2개와 수퍼클래스의 변수의 값 모두 초기화.
	Ex90_Student(int java, int html, String no1, String name1){
		super(no1,name1);
		this.java = java;
		this.html = html;
		sum = java + html;
	}
	
	// Overriding하여 수퍼클래스의 내용과 서브클래스의 내용 저장
	@Override
	public void infoPrint() {
		super.infoPrint();
		System.out.printf("Java : %d \n",java);
		System.out.printf("Html : %d \n",html);
		System.out.printf("합계 : %d",sum);	
	}
	
	// student타입 배열 제일높은거부터 낮은순으로 정렬
	// 모든클래스에서 호출하기위해 static 사용
	// sum을 기준으로 성적순 정렬
	// return
	public static String studentSort(Ex90_Student[] student) {
		for(int i=0;i<student.length;i++) {
			for(int j= i+1; j<student.length;j++) {
				if(student[i].sum < student[j].sum) {
				Ex90_Student temp = student[i];
				student[i] = student[j];
				student[j] = temp;
				}
			}
		}
		return Arrays.toString(student);
	}
}
