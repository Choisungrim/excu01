package mvcTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mlogin")
public class MVC2_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MVC2_Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 분석
		
		// 2. Service
		// => SQL문 에서 둘다 동시비교 : Service, Dao 의 수정
		//		 "select * from member where id = ? and password = ?";
		// => id 를 먼저 확인 하고 성공일 경우 password 비교 (이점)
		// 		 MemberDetail 메소드 사용, id 오류 인지 password 오류 인지 확인이 가능하다. 
		
		MemberService Service = new MemberService(); // 모델에 넘겨주기위한 서비스 객체 선언
		MemberVO vo = new MemberVO(); // 모델의 정보를 받기위한 vo객체 선언
		String url = "";
		vo.setId(request.getParameter("id")); 
		vo = Service.memberDetail(vo);
		if(vo!=null) {
			// id 비교 성공시 비밀번호 확인.		
			// String 문자열이기 때문에 기존 저장값과 입력값을 비교하기 위해 equals 사용
			if(vo.getPassword().equals(request.getParameter("password"))) {
				// Login 성공 -> 로그인 정보를 보관(id, Name) -> Login Success 
				HttpSession session = request.getSession();
				session.setAttribute("Login_id",request.getParameter("id"));
				session.setAttribute("Login_Name", vo.getName());
				request.setAttrubure("message",vo.getName()+"님이 접속하셨습니다");
				url = "index.jsp"; 
			}else {
				// password 오류 발생 -> 로그인 폼
				request.setAttribute("message", "password 오류입니다.");
				url = "servletTestForm/form05_Login.jsp"; 
			}
		}else { 
			// id 오류 발생 -> 로그인 폼
			request.setAttribute("message", "id 오류입니다.");
			url = "servletTestForm/form05_Login.jsp"; 
		}
		
		// 3. 결과
		// => view 로 전송
		// => 서버내 이동 
		// 		 Servlet -> Servlet
		//       Servlet -> Jsp
		// 		 Jsp -> Jsp, Jsp->Servlet
		// => 이동 방법
		//		 forward
		//		 Redirect
		// 3.1) Forward
		System.out.println("** Dispatcher 실행 **");
		request.getRequestDispatcher(url).forward(request, response);
		// Dispatcher => 이동할 대상("ㄴㅇㄴㅁㅇ") . forward(경,로)
		// 3.2) Redirect
		//response.sendRedirect("servletTestForm/form05_LoginSuccess.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
