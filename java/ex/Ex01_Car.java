package J05_classMethod;
//** 클래스에 포함 가능한것 (맴버)
//=> 속성(변수), 기능or동작(메서드)
//=> 맴버변수(전역변수), 맴버메서드 

//** 클래스명
//=> 대문자로 시작, 예약어 사용불가 , API 라이브러리의 클래스명 비추
//=> 클래스는 객체의 설계도

//** 객체의 주기
//=> 생성 -> 사용 -> 소멸  (in Memory)
//=> 클래스(in HDD) -> 생성(in Memory) -> 객체화 (인스턴스 생성)
// -> 사용 -> 소멸(Memory 반납)

//객체 - > 선언 // 인스턴스 - > 생성자 
//modifier   class  identifier
public class Ex01_Car {
	//**멤버변수, 필드(field) :속성
	// => 클래스의 전역변수
	//    클래스 내에서는 모든 메소드에서 사용가능.
	public int speed;   // 속도     // 객체생성
	public int mileage; // 주행거리  // 객체생성
	public String color; //색상    // 객체생성
	
	//**멤버 메소드(function, procedure)
	// => 동작 또는 기능을 구현
	public void speedUp() { 
		speed += 30;
	}
	public void speedDown() {
		speed -= 10;
	}
	
	// String (return Type) :  문자열을 반환(return) -> 메서드 처리 결과로 문자열을 제공
	// toString(메서드 명) : 객체의 속성값을 문자열로 제공하는 역할에 주로 사용됨.
	public String toString() { 
		return "[속도: " + speed + " 주행거리: " + mileage + " 색상 : " +color+"]";
	}
}// class
