package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.SessionIdGenerator;

import service.BoardService;
import vo.BoardVO;

@WebServlet("/boardDetail")
public class B02_bDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public B02_bDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BoardService service = new BoardService(); // 서비스
	String url = ""; // 이동주소
	BoardVO vo = new BoardVO(); // vo객체 생성
	HttpSession session = request.getSession(false); // 세션값 정확
	
	vo.setSeq(Integer.parseInt(request.getParameter("seq"))); // seq값을 파라미터로 받고 int 형으로 변환후 vo에 담는다.
	vo = service.SelectOne(vo); // Detail 실행
	if(session != null && session.getAttribute("Login_id")!=null) { // 만약 session 의 값이 널 값이거나, session으로 받은 아이디의 값이 널인지 확인
		String id = (String)session.getAttribute("Login_id"); // id 변수를 생성하여 세션값 저장
		System.out.println(vo.getId()); // vo객체에 존재하는 id 값 출력(확인용도)
		if(id.equals(vo.getId())) { // id(세션의 id) 와 vo객체에 존재하는 id가 같은지 확인
			try {
				if(vo != null) { // id가 같고 vo가 널 값이 아니라면 detail 출력
					// detail 출력
					request.setAttribute("apple",vo);//실행된 쿼리를 request 에 담아 보냄
					url = "Board/boardDetail.jsp"; 
					} else {
					// detail 출력 실패 -> List
					request.setAttribute("message", "해당하는 글 번호가 없습니다.");
					url ="B01_bList";
					}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}else {	service.update(vo); // id가 같지않다면 조회수 증가 
			try {
				if(vo != null) {
					// detail 출력
					request.setAttribute("apple",vo);
					url = "Board/boardDetail.jsp";
					} else {
					// detail 출력 실패 -> List
					request.setAttribute("message", "해당하는 글 번호가 없습니다.");
					url ="B01_bList";
					}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}	
	}
	request.getRequestDispatcher(url).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
