package javaTest;

public class Ex90_Person {
	// 내부에서만 접근가능한 멤버변수 
	private String no;
	private String name;
	
	//default (상속을위함)
	Ex90_Person(){
		
	}
	//두개의 변수를 초기화하는 생성자
	Ex90_Person(String no, String name){
		this.no = no;
		this.name = name;
	}
	// 볼수는 있지만 수정은 불가능하다.
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	// 모든클래스에서 사용할 수 있도록 
	public void infoPrint() {
		System.out.printf("번호 : %s \n",this.no);
		System.out.printf("이름 : %s \n",this.name);
	}
	
}
