package J05_classMethod;
//** Car 의 사용자 클래스 (User Class)

public class Ex01_CarUser {
	public static void main(String[] args) {
		// ** 객체 생명주기
	    // => 생성 -> 사용 -> 소멸
	    // => 생성: 인스턴스화 한다 또는 인스턴스를 생성한다 라고함
	Ex01_Car myCar = new Ex01_Car();  // 객체의 인스턴스화
	Ex01_Car yourCar = new Ex01_Car();  // 객체의 인스턴스화
	
	myCar.speed = 130;
	myCar.mileage = 100;
	myCar.color ="violet";
	myCar.speedUp();
	myCar.speedDown();
	System.out.println("** myCar => "+myCar.toString());

	yourCar.speed = 10;
	yourCar.mileage = 120;
	yourCar.color = "while";
	
	yourCar.speedDown();
	System.out.println("** yourCar => "+yourCar.toString());
	}
	
}
