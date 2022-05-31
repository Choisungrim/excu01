package lifeCycle01;
//** Bean(객체) 의 LifeCycle 
//=> 객체생성 -> 사용 -> 소멸
//=> 해당되는 특정시점에 자동실행 : xml, @, interface

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

//** Test2. Annotation, @
//=> @PostConstruct , @PreDestroy
//=> 실행 순서
//생성자 -> @PostConstruct (자동호출) -> 사용...  
//    -> 컨테이너 Close -> @PreDestroy (자동호출)
@Component("lca")
class LifeCycleTestA{
	public LifeCycleTestA() { System.out.println("~~ LifeCycleTest 생성자 ~~"); }
	@PostConstruct // 생성직전 자동호출
	public void begin() { System.out.println("~~ LifeCycleTest begin() ~~"); }
	@PreDestroy // 소멸직전 자동호출
	public void end() { System.out.println("~~ LifeCycleTest end() ~~"); }
	public void list() { System.out.println("~~ LifeCycleTest list() ~~"); }
	public void login() { System.out.println("~~ LifeCycleTest login() ~~"); }	
}


public class LC02_anno {
	public static void main(String[] args) {
		AbstractApplicationContext sc = new 
				GenericXmlApplicationContext("lifeCycle01/lc01.xml");
		
		LifeCycleTestA lc = (LifeCycleTestA)sc.getBean("lca");
		
		lc.login();
		lc.list();
		sc.close();
	}
}
