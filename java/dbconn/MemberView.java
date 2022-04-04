package mySqlJDBC02;
import java.util.*;

// sql 구문의 실제 실행장소.

public class MemberView {
	public void memberList(List<MemberVO> list) {
		// list 에 Data 존재 여부 확인 후 출력
		System.out.println("** Member List **");
		if(list != null) {
			//출력
			for(MemberVO m : list) {
				System.out.println(m);
			}
		}else System.out.println("출력 가능한 데이터가 없습니다.");
	}//memberlist
	
	public void memberDetail(MemberVO vo) {
		System.out.println("** Member Detail **");
		if(vo != null) {
			System.out.println("ID =>     "+vo.getId()+"\t");
			System.out.println("PW =>     "+vo.getPassword()+"\t");
			System.out.println("Name =>   "+vo.getName()+"\t");
			System.out.println("LEV =>    "+vo.getLev()+"\t");
			System.out.println("Birth =>  "+vo.getBirthd()+"\t");
			System.out.println("Point =>  "+vo.getPoint()+"\t");
			System.out.println("Weight => "+vo.getWeight()+"\t");
		}else System.out.println("출력 가능한 데이터가 없습니다.");
	}//memberdetail
	
	public void insert(int vo) {
		System.out.println("** Member Insert **");
		if(vo != 0)
			System.out.println("** insert 성공 **");
		else 
			System.out.println("** insert 실패 **");
	}//insert
	
	public void update(int vo) {
		System.out.println("** Member Update **");
	if(vo > 0)
		System.out.println("** 수정 성공 **");
	else 
		System.out.println("** 수정 실패 **");
	}//update
	
	public void delete(int vo) {
		System.out.println("** Member Delete **");
	if(vo > 0)
		System.out.println("** 삭제 성공 **");
	else 
		System.out.println("** 삭제 실패 **");
	}//update
}
