package mvcTest;

import java.util.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/MVC1_mList")
//@WebServlet(urlPatterns = {"/MVC1_mList","/mList","/99"})// 등등 한글 혹은 숫자 영어 다중사용이가능하다. // "/"경로가없거나, 혹은 중복사용될지 오류발생.
//** url 매핑 네임
//=> url 배열 형태로 복수 선언가능
//=> 그러나 중복되면 안됨 : server Start 안됨. 
//=> 한글 사용시 오류는 없으나 비추
//=> xml 로 설정가능 (web.xml 설정화일)
public class MVC1_mList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MVC1_mList() {
        super();
    }

	// ** HttpServletRequest 계층도
	// => ServletRequest (I) -> HttpServletRequest (I)     
	    
	// ** Get : request 의 header 영역의 url에 쿼리스트링으로 전달,
//	          일반적으로 256 byte 이내로 크기제한이 있는 것으로 알려져 있으나,
//	          이 용량은 브라우져 또는 장비에 따라 다를수 있음
//	          결론은 이미지 등 무거운 자료의 전송은 대부분 불가능 하므로 이때는 post로 해야함.  
	// ** Post: request 의 body 영역에 담겨져 전달 (크기제한 없음, 보안성)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 한글처리
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter(); // outStream 전달 (Print 객체)
		
		// 요청 분석 & 서비스 처리
		MemberService service = new MemberService();
		List<MemberVO> list = service.memberlist();
		
		// 결과 출력
		out.print("<html><body>");
		out.print("<h1> ** Member List **</h1> ");
		MemberVO vo = new MemberVO();
		System.out.println("");
		
		// Exception 과 if 문을 통한 데이터 셋업
		try {
			if(list != null) {
				for(MemberVO m:list) {
					out.print(m+"<hr>");
					System.out.println("");
				}
				vo.setId("banana");
				out.print(service.memberDetail(service.memberDetail(vo)));
				
			}else {
				out.print("<h2> => 출력할 자료가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
