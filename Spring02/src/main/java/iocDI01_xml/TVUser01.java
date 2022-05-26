package iocDI01_xml;
/** Test 1. 절차치향
 * */

class SsTV{
	public void  turnOn() { System.out.println("~~ SsTV turnOn ~~"); }
	public void  turnOff() { System.out.println("~~ SsTV turnOff ~~"); }
	public void  soundUp() { System.out.println("~~ SsTV soundUp ~~"); }
	public void  soundDown() { System.out.println("~~ SsTV soundDown ~~");}
}

class LgTV{
	public void  powerOn() { System.out.println("~~ LgTV powerOn ~~"); }
	public void  powerOff() { System.out.println("~~ LgTV powerOff ~~"); }
	public void  volumeUp() { System.out.println("~~ LgTV volumeUp ~~"); }
	public void  volumeDown() { System.out.println("~~ LgTV volumeDown ~~"); }
}

//** Test2. 객체지향 : 다형성적용 => interface 사용
interface TV{
	void powerOn();
	void powerOff();
	void volumeUp();
	void volumeDown();
}// interface TV

class SsTVi implements TV{
	public SsTVi() { System.out.println("~~ SsTVi 생성자 ~~"); } 
	public void  powerOn() { System.out.println("~~ SsTVi powerOn ~~"); }
	public void  powerOff() { System.out.println("~~ SsTVi powerOff ~~"); }
	public void  volumeUp() { System.out.println("~~ SsTVi volumeUp ~~"); }
	public void  volumeDown() { System.out.println("~~ SsTVi volumeDown ~~"); }
}
class LgTVi implements TV{
	public LgTVi() { System.out.println("~~ LgTVi 생성자 ~~"); } 
	public void  powerOn() { System.out.println("~~ LgTVi powerOn ~~"); }
	public void  powerOff() { System.out.println("~~ LgTVi powerOff ~~"); }
	public void  volumeUp() { System.out.println("~~ LgTVi volumeUp ~~"); }
	public void  volumeDown() { System.out.println("~~ LgTVi volumeDown ~~"); }
}


// Test 3. Factory 패턴 적용(IOC/DI) in java
class BeanFactory{
	public TV getBean(String req) {
		// TV 라는 인터페이스를 리턴해야하기떄문에 TV 타입으로 선언
		if(req.equals("ss")) return new SsTVi();
		else return new LgTVi();
	}
} //BeanFactory




public class TVUser01 {
	public static void main(String[] args) {
		
		
		System.out.println("** Test 1  절차지향");
//		SsTV tv = new SsTV();
//		tv.turnOn();
//		tv.soundDown();
//		tv.soundUp();
//		tv.turnOff();
		//만일 tv교체 필요한 상황 : 완전 재작성을 해야한다.
		
		LgTV tv = new LgTV();
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
	    // ** Test2. 객체지향 : 다형성적용
	    // => 관련성이 없는 두객체를 하나의 인터페이스로 묶어줌 
	    // => tv 교체가 필요
	    //    우측의 클래스만 교체 
	    // => 단, 소스코드의 수정이 필요함
		
		System.out.println("** Test2. 객체지향 : 다형성 적용");
		TV tvi = new SsTVi(); // 만일 TV교체가 필요한 상황이라면 우측의 클래스만 교체한다. ex) new LgTVi();
		tvi.powerOn();
		tvi.volumeUp();
		tvi.volumeDown();
		tvi.powerOff();
		
	      // ** Test3. Factory 패턴적용 (IOC/DI 입문)
	      // => 실행시에 코드 수정없이 클래스(TV) 교체
	      // => user 의 요구사항(필요한 클래스) Factory에 전달하는 방법 => xml, @(annotation), JavaCode(JavaConfig)
	      System.out.println("\n** Test3. Factory 패턴적용 (IOC/DI 입문) **"); 
	      BeanFactory bf = new BeanFactory();
	      TV tvf = bf.getBean(args[0]); // 실시간으로 소스코드 수정없이 요청전달. -> Main의 매개변수 사용.
	      if(tvf != null) {
	      tvf.powerOn();
	      tvf.volumeUp();
	      tvf.volumeDown();
	      tvf.powerOff();
	      }else System.out.println("실 패 입 니 다.");
	      
	}
}
