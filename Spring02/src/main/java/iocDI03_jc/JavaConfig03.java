package iocDI03_jc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//** Java bean configuration class를 이용한 DI
//=> Test03 : 스피커 2개중 선택 
//=> 생성자 를 이용한 주입..

//*** JC , @, xml 병행사용
//=> JC 내에서 xml 로 생성된 객체를 직접 사용하는것은 허용 되지 않음.
//=> 반대의 경우도 동일함.
// 단, User 클래스에서는 사용가능

//** 실습
//=> SsTVsi , Speaker 는 xml 로 생성
//=> LgTVsi, AiTVsi 는 JC 의 @Bean 으로 생성
//=> LgTVsi (Speaker 생성자주입) 
// AiTVsi (Speaker @Autowired)

@ImportResource("iocDI03_jc/ac03.xml")
@Configuration
public class JavaConfig03 {	
	@Autowired
	Speakeri spb;
	
	
	// => 생성된 인스턴스를 User클래스 에게 전달
	// LgTVsi (Speaker 생성자 주입)
	@Bean
	public TV tvl() {
		return new LgTVsi(spa(),150000);
	}
	@Bean
	public TV tva() {
		return new AiTVsi(spb,300000);
	}
	
	public Speakeri spa() {
		return new SpeakerA();
	}
	public Speakeri spb() {
		return new SpeakerB();
	}
	
	
}
