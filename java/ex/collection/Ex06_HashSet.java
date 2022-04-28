package j10_genCollection;
import java.util.*;
public class Ex06_HashSet {

	public static void main(String[] args) {
		// 1. 정의
	    // 1.1) Object
	    // => 순서 없고, 중복 불가
	    // => 동일성 Test
	    //    제네릭을 적용하지 않거나, Object Type 인경우
	    //    값은 같지만 Type 이 다른 경우 Test (다른 데이터로 취급)
		Object[] oarr = {"가","나",new Integer(123), new String("가"),"나","디","123"};
		HashSet<Object> oset1 = new HashSet<>();
		for (Object o : oarr) {
			if(!oset1.add(o)) {
				System.out.println("** Add 오류(중복발생) => "+o);
			}// if
		}//for
		System.out.println("** Add 완료 => "+oset1); // 순서개념 없음
		// 1.2) String
		HashSet<String> set = new HashSet<String>();
		// 2) Add
		set.add("짜장면");
		set.add("짬뽕");
		set.add("냉면");
		set.add("칼국수");
		set.add("스파게티");
		set.add("칼국수");
		//set.add(123.456); -> Error - 제네릭 에러
		System.out.println("** Add 완료 set => "+set);
		System.out.println("** set 의 Size => "+set.size());
		
		// 3) 활용
		// => 수정대상, 삭제대상을 찾아야 가능
		// => 순차적으로 비교하면서 찾아야한다.
		
		// ** Iterator 를 이용한 순차처리
		// => hasNext(), next() 적용가능
		// => 순차적으로 비교하면서 원하는 값 찾기, 삭제하기
		// => 예) "국수" 가 포함된 자료는 제외하고 출력한다
		// => iset의 remove는 set에 반영됨.
		
		Iterator<String> iset = set.iterator();
		while(iset.hasNext()) {
			if(iset.next().contains("면")) { iset.remove(); }
		}// while
		System.out.println("** remove 완료 iset => "+iset);
		System.out.println("** remove 완료 set => "+set);
		
		// ** Iterator 인스턴스 재사용
	    // Iterator 는 한번 사용을 마치면 자료를 포인트하는 커서가  
	    // 끝에 가 있어 hasNext()가 false 를 return 하기 떄문에 
	    // 재할당해야 한다.
		iset = set.iterator();
		while(iset.hasNext()) {
			if(iset.next().contains("뽕"))System.out.println("** 메뉴추가 : 탕수육 **");
			
			//if(iset.next().contains("뽕")) { }//set.add("탕수육"); }
		//  => 반복문 내부에서 set 접근시 : java.util.ConcurrentModificationException
		}// while
		System.out.println("** 추가 Test 완료 iset => "+iset);
		System.out.println("** 추가 Test 완료 set => "+set);
	}//main
}//class
