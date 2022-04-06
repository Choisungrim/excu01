package mvcTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet("/mDetail")
public class MVC2_mDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MVC2_mDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 분석
		// ID 확인 (세션을 통해 저장된 정보를 불러옴 (Session 에서 get))
		// Session 객체 정의, getAttribute 
		HttpSession session = request.getSession(false);
		String url = "";
		String message = "";
		// (), (true) 동일 = 세션이 존재하면 존재하는 세션 리턴, 없으면 생성 후 리턴 => null값이 될 수 없음.
		// (false) session이 존재하면 존재하는 세션 리턴, 없으면 NULL값 리턴
		// => 내정보 수정, 삭제 등 반드시 로그인한 user인지 확인해야 하는 경우
		// -> session 이 null인지 확인하는 구문이 필요함.
		
		if(session != null && session.getAttribute("Login_id") != null) {
			// 세션이 널값이 아니고 , login_id 값이 널이 아닌경우 실행{
			// detail 처리
			String id = (String)session.getAttribute("Login_id");
			System.out.println("****"+id);
			MemberService Service = new MemberService(); // 모델에 넘겨주기위한 서비스 객체 선언
			MemberVO vo = new MemberVO(); // 모델의 정보를 받기위한 vo객체 선언
			vo.setId(id); // setter 를 이용하여 요청하는 파라미터 값을 저장함.
			vo = Service.memberDetail(vo); // service에 존재하는 detail객체를 불러옴.
			System.out.println("*****"+vo);
			if(vo!=null) {
				// 내 정보 출력 -> setAttribute, View 를 지정
				request.setAttribute("apple", vo);
				url = "mvcJsp/mvc2_mDetail.jsp";
			}else {
				message = "해당하는 정보가 없습니다.";
				url = "index.jsp";
			}
		}else {
			// message 출력 후 index.jsp로 이동
			message = "로그인 정보가 없습니다.";
			url = "servletTestForm/form05_Login.jsp";
		}
		
		// 3. 결과
		if(message != null && message.length()>0) request.setAttribute("message", session);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
