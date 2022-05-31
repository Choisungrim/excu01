package iocDI03_jc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

//** Java bean configuration class를 이용한 DI
//=> Bean 컨테이너 : AnnotationConfigApplicationContext 사용
//   매개변수로  Java_config_class 를 사용 (JavaConfig01.class)           
//=> Test03 : 스피커 2개 중 선택
//** JC 와 @ , xml 병행 처리 Test
interface Speakeri{
	void volumeUp();
	void volumeDown();
}

class SpeakerA implements Speakeri{
	public SpeakerA() {System.out.println("생성자aaaa");	}
	public void volumeUp() {System.out.println("speaker volumeup11");}
	public void volumeDown() {System.out.println("speaker volumedown11");}
}
class SpeakerB implements Speakeri{
	public SpeakerB() {System.out.println("생성자bbbbb");	}
	public void volumeUp() {System.out.println("speaker volumeup11");}
	public void volumeDown() {System.out.println("speaker volumedown11");}
}
//** Speaker에 대한 의존성(Dependency) 해결
//1) 고전
class SsTVsi implements TV{
	private Speakeri speaker = new SpeakerA();
	public SsTVsi() {System.out.println("SsTVsi 생성자");}
	public void  powerOn() { System.out.println("~~ SsTVsi turnOn ~~"); }
	public void  powerOff() { System.out.println("~~ SsTVsi turnOff ~~"); }
	public void  volumeUp() { speaker.volumeUp(); }
	public void  volumeDown() { speaker.volumeDown();}
}

//2) 매개변수 존재
class LgTVsi implements TV{
	
	private Speakeri speaker;
	private int price;
	public LgTVsi() {System.out.println("LgTVs 생성자");}
	public LgTVsi(Speakeri speaker,int price) {
		this.speaker = speaker;
		this.price = price;
		System.out.println("Lg"+speaker+"+"+price);
	} // 생성자 이용한 setter => 생성한 이후에는 값을 set할수가 없다 .
	public void  powerOn() { System.out.println("~~ LgTV powerOn ~~"); }
	public void  powerOff() { System.out.println("~~ LgTV powerOff ~~"); }
	public void  volumeUp() { speaker.volumeUp(); }
	public void  volumeDown() { speaker.volumeDown(); }
}


//3) IOC/DI -> setter 주입
//=> TV, SpeakerB 는 JC 에서 생성하고
// @Autowired 로 주입 받음
class AiTVsi implements TV{
	@Autowired // 반드시 생성되어있어야 자동주입이 가능
	private Speakeri speaker;
	private int price;
	public AiTVsi() {System.out.println("AiTVs 생성자");}
	
	public void setSpeaker(Speakeri speaker) {this.speaker = speaker;}
	public void setPrice(int price) {this.price = price;}
	
	public void  powerOn() { System.out.println("~~ AiTVs powerOn ~~" +price+"+"+speaker); }
	public void  powerOff() { System.out.println("~~ AiTVs powerOff ~~"); }
	public void  volumeUp() { speaker.volumeUp(); }
	public void  volumeDown() { speaker.volumeDown(); }
}

public class TVUser10_JC03 {

	public static void main(String[] args) {
		//1. 콩 공장(BeanFactory) 생성
		//=> 스프링 container 구동(생성)
		AbstractApplicationContext sc = new 
				AnnotationConfigApplicationContext(JavaConfig03.class); //("작업지시서") = xml
		
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
}
	

