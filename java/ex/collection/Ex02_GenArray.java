package j10_genCollection;

import j08_APITest.Ex04_Person;

//** 과제
//=> 배열을 출력해주는 클래스 만들기
// 배열정의, setter/getter, arrayPrint()
//=> 실행시에 원하는 타입을 결정 & 출력
//=> 배열 타입 Generic
class GenArray<T>{
	private T[] arr;
	public void setArr(T[] arr) {this.arr = arr;}
	public T[] getArr() {
		return this.arr;
	}
	public void arrPrint() {
		for(T a : arr) {
			System.out.print(""+a);
		}//for
		System.out.println("\n");
	}//arrPrint
	// ** 마지막 자료 1개 리턴하기(출력하기)
	public T getLastData() {
		return arr[arr.length-1];
	}
}// GenArray<T>
public class Ex02_GenArray {

	public static void main(String[] args) {
		// 1) String
		GenArray<String> ga1 = new GenArray<String>();
		String[] ss = {"커피","초코","케익","아이스크림","과일"};
		ga1.setArr(ss);
		ga1.arrPrint();
		System.out.println("마지막 자료 1개 리턴 => "+ga1.getLastData());
		// 2) Double
		GenArray<Double> ga2 = new GenArray<Double>();
		Double[] dd = {1.112,2.223,3.334,4.445,5.556};
		ga2.setArr(dd);
		ga2.arrPrint();
		System.out.println("마지막 자료 1개 리턴 => "+ga2.getLastData());
		// 3) Character
		GenArray<Character> ga3 = new GenArray<Character>();
		Character[] cc = {'A','B','C','D','E'};
		ga3.setArr(cc);
		ga3.arrPrint();
		System.out.println("마지막 자료 1개 리턴 => "+ga3.getLastData());
		// 4) Person : Ex04_Person
		GenArray<Ex04_Person> ga4 = new GenArray<Ex04_Person>();
		Ex04_Person[] persons = {
				new Ex04_Person("890908-212155","홍길순"),
				new Ex04_Person("000908-312155","홍길덩"),
				new Ex04_Person("960908-212155","홍길주")
				};
		ga4.setArr(persons);
		ga4.arrPrint();
		System.out.println("마지막 자료 1개 리턴 => "+ga4.getLastData());
	}

}
