package iocDI02_anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

// TV의 의존성 처리
//=> TV needs speaker 
//=> 생성자 주입, setter 주입 -> @ 방식

//** @Autowired
//=> 맴버변수에 직접 생성된 주소값을 전달
// 그러므로 Speaker 는 반드시 이미 생성되어 있어야 함.
//=> 자동주입: 있으면 주입 , 없으면 Exception 발생
//=> 적용순위
//1) 주로 멤버변수 위에 선언하며,
//   스프링 컨테이너는 해당변수의 타입을 체크하고,
//   그 타입의 객체가 메모리에 존재하는지 확인하여
//   해당 변수에 대입 해준다.
//2) 동일타입의 객체가 둘이상이면  @Qualifier 에 명시된 객체 주입
//3) 동일타입의 객체가 둘이상이고  @Qualifier 없으면 
// id가 같은 객체 찾아 있으면 주입, 없으면 오류

//** Test : Speaker 생성 안되어있는 경우 오류메시지 확인
//    => ...Injection of autowired dependencies failed;.....

//** required 속성
// => true : 해당 타입의 등록된 빈이 없을때 주입시 익셉션이 발생
// => false: 해당 타입의 등록된 빈이 없을때 익셉션이 발생하지 않음 
//       ( 있으면주입 , 없으면 null )    
// 
//1) @Autowired(required=true) : default 
//    => BeanCreationException <- NoSuchBeanDefinitionException: .... as autowire...  
//2) @Autowired(required=false) 
//    => 실행문에서 접근시 NullPointerException 발생
//@Component
class Speaker {
	public Speaker() {
		System.out.println("Speaker constructor Check Check");
	}
	public void  volumeUp() { System.out.println("~~ Speaker volumeUp ~~"); }
	public void  volumeDown() { System.out.println("~~ Speaker volumeDown ~~"); }
}

// 1) 고전적인 방법 (직접 new)
//@Component("tvs")
class SsTVs implements TV {
	private Speaker speaker = new Speaker();
	
	public SsTVs() { System.out.println("~~ SsTVi basic constructor ~~"); } 
	public void  powerOn() { System.out.println("~~ SsTVi powerOn ~~"); }
	public void  powerOff() { System.out.println("~~ SsTVi powerOff ~~"); }
	
	public void  volumeUp() { speaker.volumeUp();}
	public void  volumeDown() { speaker.volumeDown();}
}//SsTvs

// 2) IOC/DI -> 생성자 주입
//@Component("tvl")
class LgTVs implements TV {
	//@Autowired
	// 자동 주입 (@Autowired)
	//=> Speaker 가 생성되어 있어야 쓸 수 있다.
	//=> Speaker speaker = new Speaker(); 구문의 '=' 역할
	//=> 메모리에서 타입이 일치하는 객체를 찾아, 있으면 재공
	//없으면 오류 : UnsatisfiedDependencyException
	//=> required = false 주면 null return( NullPointException 발생)
	//여기 구문은 오류X but 밑에 실행 중에 오류남
	//=> volumeUp, volumeDown 에서 NullPointException 발생
	private Speaker speaker;
	private int price;
	private String color;
	public LgTVs() { System.out.println("~~ LgTVi basic constructor ~~"); } 
	
	//맴버변수를 초기화 하는 생성자
	public LgTVs(Speaker speaker, int price, String color) {
		this.speaker=speaker;
		this.price=price;
		this.color=color;
		System.out.println("~~ LgTVi reset constructor ~~"+price+color); 
	} 
   public void  powerOn() { System.out.println("~~ LgTVi powerOn ~~"); }
   public void  powerOff() { System.out.println("~~ LgTVi powerOff ~~"); }
   public void  volumeUp() { speaker.volumeUp(); }
   public void  volumeDown() { speaker.volumeDown(); }
}//LgTvs

// 3) IOC/DI -> setter 주입
//@Component("tva")
class AiTVs implements TV {
	
	//@Autowired(required = false)
	private Speaker speaker;
	private int price;
	private String color;
	
	
	public AiTVs() { System.out.println("~~ AiTVi basic constructor ~~"); } 
	
	public void setSpeaker(Speaker speaker) { this.speaker=speaker; }
	public void setPrice(int price) { this.price = price; }
	public void setColor(String color) { this.color = color; }
	
	
   public void  powerOn() { System.out.println("~~ AiTVi powerOn : price , color"+price+color); }
   public void  powerOff() { System.out.println("~~ AiTVi powerOff ~~"); }
   public void  volumeUp() { speaker.volumeUp(); }
   public void  volumeDown() { speaker.volumeDown(); }
}//AiTVs


public class TVUser06_Anno02 {
	public static void main(String[] args) {
		// 1. 스프링 컨테이너 구동(생성) 
	      AbstractApplicationContext sc = new 
	            GenericXmlApplicationContext("iocDI02_anno/app05.xml");
	      
	      // 2. 필요한 객체를 전달받고 서비스 실행 
	      System.out.println("**  Test1) 고전적방법 : 직접 new  **");
	      TV tvs = (TV)sc.getBean("tvs");
	      tvs.powerOn();
	      tvs.volumeUp();
	      tvs.volumeDown();
	      tvs.powerOff();
	      
	      System.out.println("**  Test2) IOC/DI : 생성자 주입  **");
	      TV tvl = (TV)sc.getBean("tvl");
	      tvl.powerOn();
	      tvl.volumeUp();
	      tvl.volumeDown();
	      tvl.powerOff();
	      
	      System.out.println("**  Test3) IOC/DI : Setter 주입  **");
	      TV tva = (TV)sc.getBean("tva");
	      tva.powerOn();
	      tva.volumeUp();
	      tva.volumeDown();
	      tva.powerOff();
		
	      sc.close();
	}//main
}//class
