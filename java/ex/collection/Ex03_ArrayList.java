package j10_genCollection;

import java.util.*;

import j08_APITest.Ex04_Person;

//** ArrayList (ppt 18, 19 ~)

//** ArrayList<E> 의 저장용량  
// => 데이터가 증가하면 메서드 호출하지 않아도 필요시 저장용량은 자동증가 함
// => 필요시엔 미리 설정가능
// => 생성시에 할당 가능 : 생성자 매개변수로 지정
// => 메소드 이용가능.

//1) 생성자 
// => 초기값 지정 가능 :  new ArrayList<>(100) ;

//2) 메서드 이용
// => public void ensureCapacity(int minCapacity) : ArrayList 에 정의

public class Ex03_ArrayList {

	public static void main(String[] args) {
		// 1. 정의
	    // => 기본용량 확인하기
	    // ** 비교
		// size(사이즈)는 리스트의 요소의 수,
        // 용량은 리스트는 잠재적으로 그 내부구조를 재 할당없이 수용할 수있는 요소의 수
		ArrayList<Integer> aList1 = new ArrayList<Integer>();
		System.out.println("** aList1 Size = > "+aList1.size());
		// => 생성시 용량 할당
		ArrayList<Integer> aList2 = new ArrayList<Integer>(10);
		System.out.println("** aList2 Size = > "+aList2.size());
		// => 메소드로 용량 수정
		aList2.ensureCapacity(5);
		List<Integer> aList3 = new ArrayList<Integer>();
		//aList3.ensureCapacity (x) - 안됨 List의 정의된만큼만 접근가능.
		
		// 2. 추가 (Add)
		// => 용량 변경후 Test
		aList1.ensureCapacity(3);
		aList1.add(100);
		aList1.add(200);
		aList1.add(300);
		aList1.add(400);
		aList1.add(400);
		aList1.add(400);
		aList1.add(500);
		System.out.println("** After aList1 size = > "+aList1.size());
		
		// 3. 활용 (get) ,수정 (set), remove
		int sum = aList1.get(0)+aList1.get(1);
		System.out.println("sum => "+sum);
		// 3.2 set, add, remove
		aList1.set(0, sum); // 수정
		aList1.add(3, 555); // 중간인덱스에 끼워넣기도 가능하다.(추가)
		System.out.println(aList1.size());
		aList1.remove(4);
		System.out.println(aList1.size());

		// 4. 출력
		for (int i : aList1) {
			System.out.print(" \n"+i);
		}System.out.println("");
		
		// 5. Person (Ex04_Person) 적용
		List<Ex04_Person> list = new ArrayList<Ex04_Person>();
		list.add(new Ex04_Person("880907-1167716","홍삼식"));
		list.add(new Ex04_Person("009002-3147716","홍길둥"));
		list.add(new Ex04_Person("951117-2148731","홍시상"));
		
		for(Ex04_Person a : list) {
			a.infoPrint();
		}
		System.out.println("");
		
	}// main
}// class
