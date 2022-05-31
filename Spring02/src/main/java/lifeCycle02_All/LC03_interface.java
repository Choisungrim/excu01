package lifeCycle02_All;
//** Bean(객체) 의 LifeCycle 
//=> 객체생성 -> 사용 -> 소멸
//=> 해당되는 특정시점에 자동실행 : xml, @, interface

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

//** Test3. interface
//=> 각 시점별로 자동호출되는 메서드를 구현해놓은 interface 를 활용
//-> InitializingBean : afterPropertiesSet()
//-> DisposableBean : destroy()
//=> 실행 순서
// 생성자 -> afterPropertiesSet() (자동호출) -> 사용...  
//      -> 컨테이너 Close -> destroy() (자동호출)
@Component("lci")
class LifeCycleTestA implements InitializingBean,DisposableBean{
	public LifeCycleTestA() { System.out.println("~~ LifeCycleTestI 생성자 ~~"); }
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet ");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy() ");
	}
	@PostConstruct
	public void beginAnno() { System.out.println("~~ beginAnno");}
	
	@PreDestroy
	public void endAnno() { System.out.println("~~endAnno");}
	// anno
	
	public void list() { System.out.println("~~ LifeCycleTestI list() ~~"); }
	public void login() { System.out.println("~~ LifeCycleTestI login() ~~"); }	
}


public class LC03_interface {
	public static void main(String[] args) {
		AbstractApplicationContext sc = new 
				GenericXmlApplicationContext("lifeCycle02_all/lc_All.xml");
		
		LifeCycleTestA lc = (LifeCycleTestA)sc.getBean("lci");
		
		lc.login();
		lc.list();
		sc.close();
	}
}
