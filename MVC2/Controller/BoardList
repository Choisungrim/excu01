package controller;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
//import vo.BoardVO;

@WebServlet("/B01_bList")
public class B01_bList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public B01_bList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");
		// 요청 분석 & 서비스 처리
		BoardService service = new BoardService();
		String url = "";
		//List<BoardVO> list = new ArrayList<BoardVO>();
		
		// Service 처리
		//list = service.SelectList();
		request.setAttribute("apple", service.SelectList());
		url = "Board/boardList.jsp";
    
		// view 
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
