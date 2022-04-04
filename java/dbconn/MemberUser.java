package mySqlJDBC02;


// password 부분 암호화(md5 , crypt) 해시 / 복호화 


public class MemberUser {	
	public static void main(String[] args) {
		// 1. memberList
		// => 요청 & 출력
		MemberView view = new MemberView();
		MemberService Service = new MemberService();
		view.memberList(Service.memberlist());
		System.out.println("");
		
		// 2. MemberListDetail 출력
		MemberVO vo = new MemberVO();
		vo.setId("apple123");
		view.memberDetail(Service.memberDetail(vo));
		System.out.println("");
		
		// 3. MemberInsert 수행
		vo.setId("violet");
		vo.setPassword("12345");
		vo.setName("최성림");
		vo.setLev("B");
		vo.setBirthd("1996-01-06");
		vo.setPoint(30000);
		vo.setWeight(78.82);
		view.insert(Service.insert(vo));
		System.out.println("");
		view.memberList(Service.memberlist());
		System.out.println("");
		
		// 4. MemberUpdate 수행 
		// => name, point, weight 수정
		vo.setName("");
		vo.setPoint(16000);		
		vo.setWeight(63.25);
		vo.setId("violet");
		view.update(Service.update(vo));
		System.out.println("");
		view.memberDetail(Service.memberDetail(vo));
		System.out.println("");
		
		// 5. delete 수행
		// => 삭제대상 : id 로 선택
		vo.setId("violet");
		view.delete(Service.delete(vo));
		System.out.println("");
		view.memberList(Service.memberlist());
		
		
	}// main
}// class
