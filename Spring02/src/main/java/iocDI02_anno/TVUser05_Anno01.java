package iocDI02_anno;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;


//** Annotation, @, 애노테이션
//=> 컴파일러에게 알려줌

//** @ Annotation 어노테이션 활용방법 *********************

//1. xml에 context 네임스페이스 추가  [NameSpaces] 이용
//=> Component-scan 설정  : 
// <context:component-scan base-package="d0714.iocEx05" />
//  
//2. 소스코드 
//=> import 확인  : org.springframework.context.support.*;
//=> 생성을 원하는 TV 클래스 위에 @Component("tv") 설정

//=> @Component("tv") 
// <bean ....> </bean> -> xml
// new 생성자() -> Java Code

//3.Test : 오류 메시지 확인 하기
//=> @ Test1 생성 -> <bean ... />
//=> @ Test2 id명 미 지정(둘다 beanname 없이) 
//=> ...NoSuchBeanDefinitionException: 
//  No bean named 'tv' is defined ....
//=> @ Test3 id명 중복되는 경우 (둘다 beanname  ("tv") 지정 )  
//=> ...annotation.ConflictingBeanDefinitionException: ....
//  ...non-compatible bean definition of same name and class ...

//** xml (설정화일)
interface TV {
	public void powerOn();
	public void powerOff();
	public void  volumeUp();
	public void  volumeDown();
}//TV
/*
 * @Component("tv") 동일한 id 주어지면 오류남 -> BeanDefinitionException
 * class SsTVi implements TV { public SsTVi() {
 * System.out.println("~~ SsTVi 생성자 ~~"); } public void powerOn() {
 * System.out.println("~~ SsTVi powerOn ~~"); } public void powerOff() {
 * System.out.println("~~ SsTVi powerOff ~~"); } public void volumeUp() {
 * System.out.println("~~ SsTVi volumeUp ~~"); } public void volumeDown() {
 * System.out.println("~~ SsTVi volumeDown ~~"); } 
 * }//SsTVi
 */
//@Component("tv")
class LgTVi implements TV {
	public LgTVi() { System.out.println("~~ LgTVi 생성자 ~~"); } 
   public void  powerOn() { System.out.println("~~ LgTVi powerOn ~~"); }
   public void  powerOff() { System.out.println("~~ LgTVi powerOff ~~"); }
   public void  volumeUp() { System.out.println("~~ LgTVi volumeUp ~~"); }
   public void  volumeDown() { System.out.println("~~ LgTVi volumeDown ~~"); }
	
}//LgTVi

public class TVUser05_Anno01 {
	public static void main(String[] args) {
		//1. 콩 공장(BeanFactory) 생성
		//=> 스프링 container 구동(생성)
		AbstractApplicationContext sc = new 
				GenericXmlApplicationContext("iocDI02_anno/app05.xml"); //("작업지시서") = xml
		
		// 2. 필요한 객체를 전달받고 서비스 실행 
	    TV tv = (TV)sc.getBean("tv");
	    	tv.powerOn();
			tv.volumeUp();
			tv.volumeDown();
			tv.powerOff();
			
			sc.close();
	    
	    
	}//main
}//class
