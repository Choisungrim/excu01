package javaTest;

public class Ex90_StudentTest {

	public static void main(String[] args) {
		//크기가 5인 배열 초기화 생성
		Ex90_Student student[] = new Ex90_Student[5];
		student[0]= new Ex90_Student(1020,50,"S001","홍길동1");
		student[1]= new Ex90_Student(800,630,"S002","홍길동2");
		student[2]=	new Ex90_Student(50,810,"S003","홍길동3");
		student[3]=	new Ex90_Student(1210,20,"S004","홍길동4");
		student[4]=	new Ex90_Student(120,150,"S005","홍길동5");
		
		System.out.println("** 석차순 출력 **");
		for(int i = 0; i<student.length; i++) {
			System.out.println("*-------------*");
			Ex90_Student.studentSort(student); // 성적순 정렬
			student[i].infoPrint(); // 성적순 출력
			System.out.println("");
		}
	}
}
