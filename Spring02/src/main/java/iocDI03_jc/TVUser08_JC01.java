package iocDI03_jc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

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
	
	public class TVUser08_JC01 {
		//** Java bean configuration class를 이용한 DI
		//=> Bean 컨테이너 : AnnotationConfigApplicationContext 사용
		//   매개변수로  Java_config_class 를 사용 (JavaConfig01.class)           
		//=> Test01 : 스피커 없는 TV
		public static void main(String[] args) {
			//1. 콩 공장(BeanFactory) 생성
			//=> 스프링 container 구동(생성)
			AbstractApplicationContext sc = new 
					AnnotationConfigApplicationContext(JavaConfig01.class); //("작업지시서") = xml
			
			// 2. 필요한 객체를 전달받고 서비스 실행 
		    TV tv = (TV)sc.getBean("green");
		    
		    // TV 는 타입명 , ("tv")는 메소드 명
		    	tv.powerOn();
				tv.volumeUp();
				tv.volumeDown();
				tv.powerOff();
				
				sc.close();
		    
		    
		}//main

	}


