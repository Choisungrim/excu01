package mvcTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class MVC2_Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MVC2_Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 분석
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		String url = "index.jsp";
		
		// 3. 결과
		// 3.1) Forward
		request.setAttribute("message1", "Logout 되었습니다.");
		
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
