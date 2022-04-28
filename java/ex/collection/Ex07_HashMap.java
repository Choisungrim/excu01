package j10_genCollection;
import java.util.*;
//*** 해싱과 해시함수 => 정석 651p
//해싱 => 해시 함수를 이용해서 데이터를 해시 테이블에 저장하고
//     검색하는 기법

//*** Map ( Key, Value )
//=> HashMap (Key 값의 중복을 허용하지 않고, 순서 유지를 보장받지 못한다.) 
//=> TreeMap (Key 값의 중복을 허용하지 않고, 키값으로 오름차순 정렬이 된다.)
//=> LinkedHashMap (Key 값의 중복을 허용하지 않고, 입력순서 유지를 보장받는다.)

//*** HashMap : Key, Value 정보 지정
//=> key 는 유일, Value 는 중복 허용 
//=> null 값 허용 map.put(null, null) 또는 map.get(null) 가능
public class Ex07_HashMap {

	public static void main(String[] args) {
		// 1. Hash Map 정의
		Map<Integer, String> hm = new HashMap<>();
		// 타입(메소드) 들은 Map 의 내용이 , 결과 출력문은 HashMap 의 내용이 출력된다
		
		// 2. Put
		// => Key = 중복불가능, NULL 허용
		// => Value = 중복가능, NULL 허용
		hm.put(1, "HTML5");
		hm.put(10, "1111");
		hm.put(2, "CSS");
		hm.put(20, "JQuery");
		hm.put(3, "Java");
		hm.put(30, "Servlet");
		hm.put(5, "MySql");
		hm.put(4, "Java");
		hm.put(3, "JavaScript");
		// => key는 중복되었지만 컴파일 오류는 없고, Value 만 변경 
		// => 나중에 정의된 값이 저장된다.
		// 3. 출력
		System.out.println("** HashMap1 => "+hm);
		
		// 4. 활용(Key로 접근 => get, remove, size)
		System.out.println("** HashMap => "+hm.size());
		System.out.println("** HashMap Get(3)_before => "+hm.get(3));
		System.out.println("** HashMap Remove(3) => "+hm.remove(3));
		System.out.println("** HashMap Get(3)_after => "+hm.get(3));
		System.out.println("** HashMap2 => "+hm);
		
		// 5. Map 구현클래스 비교
	    //=> TreeMap (Key 값의 중복을 허용하지 않고, 키값으로 오름차순 정렬이 된다.)
	    //=> LinkedHashMap (Key 값의 중복을 허용하지 않고, 입력순서 유지를 보장받는다.)
		//=> NULL 값 허용하지않음
		System.out.println("");
		Map<Integer, String> tm = new TreeMap<Integer, String>(hm);
		System.out.println("** TreeMap => "+tm);
		Map<Integer, String> fhm = new LinkedHashMap<Integer, String>(hm);
		System.out.println("** LinkedHashMap from hm=> "+fhm);
		// hm 으로 생성한 경우와 tm 으로 생성한 경우 비교
		Map<Integer, String> ftm = new LinkedHashMap<Integer, String>(tm);
		System.out.println("** LinkedHashMap from tm=> "+ftm);
		
	} //main
} //class
