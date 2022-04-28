package j10_genCollection;
import java.util.*;
//** Properties
//=> Properties는 HashMap의 구버전인 Hashtable을 상속받아 구현한 것으로, 
// Hashtable은 키와 값을 (Object, Object)의 형태로 저장하는데 비해 
// Properties는 (String, String)형태로 저장하는 보다 단순화된 컬렉션 클래스 이다. 

//=> Properties SourceCode header
// public class Properties extends Hashtable<Object,Object> {...

//=> 주로 애플리케이션의 환경설정과 관련된 속성을 저장하는데 사용되며 
// 데이터를 파일로부터 읽고 쓰는 편리한 기능을 제공한다. 
// 그래서 간단한 입출력은 Properties를 활용하면 몇 줄의 코드로 쉽게 해결할 수 있다.
public class Ex08_Properties {

	public static void main(String[] args) {
		// 1. 정의 & 입력
		// => 동일Key 는 허용되지않고, 입력 시 나중값이 적용됨
		Properties pp = new Properties();
		pp.setProperty("Join", "MemberInsert.java");
		pp.setProperty("Update", "MemberUpdate.java");
		pp.setProperty("Delete", "MemberDelete.java");
		pp.setProperty("List", "MemberList.java");
		pp.setProperty("Detail", "MemberDetail.java");
		
		//pp.setProperty("test", 2123); -> Error
		//pp.setProperty(100,"12312321"); -> Error
		
		// 2. 출력
		System.out.println("**pp => "+pp);
		System.out.println("**pp => "+pp.getProperty("Delete"));
		
		// 3. 순차처리
		// => Enumeration 이용
		// => Key 값 이용
		Enumeration<?> ep = pp.propertyNames(); //pp의 key값들을 ep에 담아줌
		while(ep.hasMoreElements()) {// Key 의 값이 boolean 형태로 반환
			String eKey = (String)ep.nextElement(); // key값을 String 형태로 인스턴스화
			System.out.printf("Key = %s, Value = %s, get = %s \n",eKey,pp.getProperty(eKey),pp.get(eKey));
		}
		System.out.println("");
		
		// => Value 값 이용
		Enumeration<?> ep2 = pp.elements(); //pp의 Value 들을 ep2에 담아줌
		while(ep2.hasMoreElements()) { // Value 의 값이 boolean 형태로 반환
			String element = (String)ep2.nextElement(); // Value값을 String 형태로 인스턴스화
			System.out.printf("element = %s ",element);
		}
			//pp.entrySet() : Set 에 담아줌
		
		
	}// main
}// class
