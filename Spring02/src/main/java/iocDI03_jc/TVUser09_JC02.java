package iocDI03_jc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.AbstractApplicationContext;
	
	class Speaker{
		public Speaker() {System.out.println("생성자");	}
		public void volumeUp() {System.out.println("speaker volumeup11");}
		public void volumeDown() {System.out.println("speaker volumedown11");}
	}//Speaker 
	
	//1) 고전
	class SsTVs implements TV{
		private Speaker speaker = new Speaker();
		public SsTVs() {System.out.println("SsTVs 생성자");}
		public void  powerOn() { System.out.println("~~ SsTV turnOn ~~"); }
		public void  powerOff() { System.out.println("~~ SsTV turnOff ~~"); }
		public void  volumeUp() { speaker.volumeUp(); }
		public void  volumeDown() { speaker.volumeDown();}
	}

	class LgTVs implements TV{
		private Speaker speaker;
		private int price;
		public LgTVs() {System.out.println("LgTVs 생성자");}
		public LgTVs(Speaker speaker,int price) {
			this.speaker = speaker;
			this.price = price;
			System.out.println("Lg"+speaker+"+"+price);
		} // 생성자 이용한 setter => 생성한 이후에는 값을 set할수가 없다 .
		public void  powerOn() { System.out.println("~~ LgTV powerOn ~~"); }
		public void  powerOff() { System.out.println("~~ LgTV powerOff ~~"); }
		public void  volumeUp() { speaker.volumeUp(); }
		public void  volumeDown() { speaker.volumeDown(); }
	}

	class AiTVs implements TV{
		private Speaker speaker;
		private int price;
		public AiTVs() {System.out.println("AiTVs 생성자");}
		
		public void setSpeaker(Speaker speaker) {this.speaker = speaker;}
		public void setPrice(int price) {this.price = price;}
		
		public void  powerOn() { System.out.println("~~ AiTVs powerOn ~~" +price+"+"+speaker); }
		public void  powerOff() { System.out.println("~~ AiTVs powerOff ~~"); }
		public void  volumeUp() { speaker.volumeUp(); }
		public void  volumeDown() { speaker.volumeDown(); }
	}
	public class TVUser09_JC02 {
		//** Java bean configuration class를 이용한 DI
		//=> Bean 컨테이너 : AnnotationConfigApplicationContext 사용
		//   매개변수로  Java_config_class 를 사용 (JavaConfig01.class)           
		//=> Test02 : 스피커 1개 사용 TV
		public static void main(String[] args) {
			//1. 콩 공장(BeanFactory) 생성
			//=> 스프링 container 구동(생성)
			AbstractApplicationContext sc = new 
					AnnotationConfigApplicationContext(JavaConfig02.class); //("작업지시서") = xml
			
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
	

