package mySqlJDBC02;
import java.util.*;

// ** Service
// => 요청 클래스와 DAO 클래스 사이의 연결(완충지대) 역할
// => 요청 클래스와 DAO 클래스 사이에서 서로 변경사항이 생기더라도 영향을 받지않도록해주는 역할
// => 결합도는 낮추고 응집도는 높이는 방법.

public class MemberService {
	
	MemberDAO dao = new MemberDAO();
	
	public List<MemberVO> memberlist(){
		return dao.memberList();
	}
	
	public MemberVO memberDetail(MemberVO vo) {
		return dao.memberListDetail(vo);
	}
	
	public int insert(MemberVO vo) {
		return dao.insert(vo);
	}
	
	public int update(MemberVO vo) {
		return dao.update(vo);
	}
	
	public int delete(MemberVO vo) {
		return dao.delete(vo);
	}
}
