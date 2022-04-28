package j10_genCollection;
import java.util.*;
import j08_APITest.Ex04_Person;

//ppt 12 ~ 17
//** List 인터페이스 (ppt 18, 23)
//=> List의 특징 : 순서가 있으며 중복된 원소를 가질 수 있다.
//=> 구현 클래스 : ArrayList, LinkedList

//** LinkedList<E>  
//=> ArrayList 및 배열의 단점을 보완하여 고안됨.   
//=> 장점 
// 1) 저장공간을 늘리는 과정이 간단.
// 2) 자료 입력 & 삭제 과정이 단순.
//=> 단점 : 순차처리의 access time 이 느리다.
//=> 빈번하게 삽입과 삭제가 일어나는 경우에 사용 

//** ArrayList<E> 
//=> 순서를 유지하며 중복을 허용하는 자료구조  
//=> 배열(Array)의 향상된 버전 또는 가변 크기의 배열이라고 생각하면 된다. 
//=> 장점 : 자료구조가 간단하며 사용이 쉽고 순차처리의 access time이 가장 빠르다.
//=> 단점
//1) 크기 변경시 새로운 배열을 생성해서 복사해야 하므로 비효율적
//2) 비순차적인 자료의 추가,수정,삭제시에 복사 및 이동 때문에 비효율적
//=> 크기가 일정하고 비순차적인 자료 수정이 발생하지 않는 경우 유리. 

//---------------------------------
//** source Code class header 참고
//public class LinkedList<E>
// extends AbstractSequentialList<E>
// implements List<E>, Deque<E>, Cloneable, java.io.Serializable
//{

//public class ArrayList<E> extends AbstractList<E>
// implements List<E>, RandomAccess, Cloneable, java.io.Serializable
//{
//---------------------------------


public class Ex04_LinkedList {
	public static void main(String[] args) {
		// 1) 정의
		LinkedList<String> list1 = new LinkedList<String>();
		System.out.println("** list1 Size1 => "+list1.size());
		// => 다형성 적용
		List<Double> list2 = new LinkedList<Double>();
		list2 = new ArrayList<Double>(); // 우측 클래스 교체가 가능하다.
		
		// 2) Add
		list1.add("Html");
		list1.add("Css");
		list1.add("Java");
		list1.add("Servlet");
		list1.add("JSP");
		System.out.println("** list1 Size2 => "+list1.size());
		// 3) 활용 : set, remove, add(끼워넣기)
		list1.remove(1);
		list1.set(0, "Html&Css");
		list1.add(2, "MySql");
		list1.add(3,"Java");
		System.out.println("** list1 Size3 => "+list1.size());
		
		// 4) 출력
		for(String s : list1) {
			System.out.print(" "+s);
		}
		System.out.println("");
		
		// 5) Ex04_Person 활용
		List<Ex04_Person> list3 = new LinkedList<Ex04_Person>();
		list3.add(new Ex04_Person("880907-1167716","홍삼식"));
		list3.add(new Ex04_Person("009002-3147716","홍길둥"));
		list3.add(new Ex04_Person("951117-2148731","홍시상"));
		
		for(Ex04_Person a : list3) {
			a.infoPrint();
		}
		System.out.println("");
		
		// 6) 배열 -> List 형태로
		String[] ss = {"커피","쵸코","케익","아이스크림","과일쥬스"} ;
		List<String> al = Arrays.asList(ss);
		
	}
}
