package iocDI03_jc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


//** Java bean configuration class를 이용한 DI
//=> Test02 : 스피커 1개 사용 TV 
//=> 생성자 를 이용한 주입 & JC에서 xml 병행사용

//** JC 에서 xml 병행 사용하기 
//=> @ImportResource("iocDI03_jc/applicationContext02.xml")
//=> AiTVs 생성은 xml 로 

@ImportResource("iocDI03_jc/ac02.xml")
@Configuration
public class JavaConfig02 {
	@Bean
	public TV tvs() {
		return new SsTVs();
	}
	
	@Bean
	public TV tvl() {
		return new LgTVs(sp(),5566000);
	}
	
	// => Speaker 생성
	public Speaker sp() {
		return new Speaker();
	}
	
	//3) IOC/DI -> setter 주입
	//=> AiTVs는 xml로 Test(ac02.xml)
	//=> 아래처럼 생성은 가능하지만 setter 를 통한 Speaker전달은 불가능
	//@beab
//	public TV tva() {
//		return new AiTVs()
//	}
		
}
