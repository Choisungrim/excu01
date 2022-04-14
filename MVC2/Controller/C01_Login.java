package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.MemberVO;

@WebServlet("/C01_Login")
public class C01_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C01_Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService Service = new MemberService();
		MemberVO vo = new MemberVO();
		String url = "";
		vo.setId(request.getParameter("id")); 
		vo = Service.memberDetail(vo);
		// id 확인
		if(vo!=null) {
			// Password 확인
			if(vo.getPassword().equals(request.getParameter("password"))) {
				HttpSession session = request.getSession();
				session.setAttribute("Login_id",request.getParameter("id"));
				session.setAttribute("Login_Name", vo.getName());
				session.setAttribute("Login_id", vo.getId());
				session.setAttribute("Login_Name", vo.getName());
				request.setAttribute("message", "~~~Login 성공~~~");
				url = "index.jsp"; 
			}else {
				// password 오류 발생 -> 로그인 폼
				request.setAttribute("message", "password 오류입니다.");
				url = "member/loginForm.jsp"; 
			}
		}else { 
			// id 오류 발생 -> 로그인 폼
			request.setAttribute("message", "id 오류입니다.");
			url = "member/loginForm.jsp"; 
		}
		System.out.println("** Dispatcher 실행 **");
		request.getRequestDispatcher(url).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
