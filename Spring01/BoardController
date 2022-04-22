package com.ncs.green;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.BoardService;
import vo.BoardVO;


@Controller
public class BoardController {
	@Autowired
	BoardService Service;
	BoardVO vo = new BoardVO();
	
	// boardList
	@RequestMapping(value = "/boardf", method = RequestMethod.GET)
	public ModelAndView boardForm(HttpServletRequest request,ModelAndView mv) {
		
		mv.addObject("apple", Service.SelectList());
		mv.setViewName("board/boardList");
		return mv;
	} // loginf
	
	@RequestMapping(value = "/boardDetail")
	public ModelAndView bdetail(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes rttr, ModelAndView mv, BoardVO vo) {
			// 1. 요청분석 & Service
			// => 조회수 증가 
			// => Cookie 를 이용해서 24시간 동안 동일한 글은 1회만 증가 가능 하도록 한다.
			//    단, 로그인 여부는 무관하게 상세글 보기가 가능 하므로 urser의 id 는 따지지 않는다.
			// => 크롬의 개발자 모드에서 Cookie 값 확인하면서 Test
			
			// 1.1) 쿠기 생성
			Cookie viewCookie = null;
			Cookie[] cookies = request.getCookies();

			// 1.2) 현재글의 조회수 증가 반영 확인
			// => 없을때만 증가
			if ( cookies!=null ) {
				for ( Cookie c:cookies ) {
					if (c.getName().equals("|"+vo.getSeq()+"|")) {   //  쿠키의 보관 값 -> (seq)
			// 일치하는 글번호 존재 -> 조회수 증가 X 
							viewCookie = c;
							break;
							}
					} //for
				} //if

			// => 그러므로 viewCookie 가 null 인경우에만  
			//    Cookie 보관, 조회수 증가 처리
			if ( viewCookie==null ) {
			// 조회수증가 처리 성공후 Cookie 처리
				if ( Service.countUp(vo) > 0 ) {
					Cookie newCookie = new Cookie("|"+vo.getSeq()+"|","view") ;
					newCookie.setMaxAge(24*60*60);  // MaxAge 24시간 지정 -> 단위 초
					response.addCookie(newCookie);
					}else {
					System.out.println("** 조회수 증가가 정상적으로 처리되지 않음 **");
					mv.addObject("message", "~~ 조회수 증가가 정상적으로 처리되지 않음 ~~");
					}
			} // if
			vo = Service.SelectOne(vo);
			if (vo != null) {
			// Detail 출력
				mv.addObject("apple", vo);
				System.out.println(vo.getId());
				System.out.println(vo.getTitle());
				mv.setViewName("board/boardDetail");
			}else {
			// 다시 List 로 -> bList 서블릿 으로
				rttr.addFlashAttribute("message", "~~ 글번호에 해당하는 글이 없습니다 ~~");
				mv.setViewName("redirect:boardf");
			}

				// 2. 결과 : view 처리
				return mv;
	} //bdetail
	
	@RequestMapping(value="/boardInsertf")
	public ModelAndView insertForm(HttpServletRequest request,ModelAndView mv) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("Login_id")!=null) {
			String id = (String)session.getAttribute("Login_id");
			if(id != null) {
				mv.setViewName("board/boardInsert");
			}else {
				mv.addObject("message", "로그인 해주세요!");
				mv.setViewName("member/loginForm");
			}
		}else {
				mv.addObject("message", "로그인 해주세요!");
				mv.setViewName("member/loginForm");
			}
		return mv;
	}
	
	
	@RequestMapping(value="/boardInsert")
	public ModelAndView insert(HttpServletRequest request, ModelAndView mv,RedirectAttributes attr) {
			vo.setId(request.getParameter("id"));
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			if(Service.insert(vo)>0) {
				// 입력 성공
				attr.addFlashAttribute("message", "글 등록 성공");
				mv.setViewName("redirect:boardf");
			}else {
				// 입력 실패
				attr.addFlashAttribute("message", "글 등록 실패 다시하세요. ");
				mv.setViewName("redirect:boardf");;
			}
		return mv;
	}
	
	@RequestMapping(value = "/boardDelete")
	public ModelAndView delete(HttpServletRequest request,ModelAndView mv,RedirectAttributes attr) {
    HttpSession session = request.getSession(false);// 세션값 정확
    try {
    	if(session != null && session.getAttribute("Login_id")!=null) {
    		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
	    	String id = (String)session.getAttribute("Login_id");
	    	vo = Service.SelectOne(vo);
    		if(id.equals(vo.getId())) { 
    			// 삭제 성공
	    		if(Service.delete(vo)>0){
    			attr.addFlashAttribute("message", "글이 삭제 되었습니다.");
	    		mv.setViewName("redirect:boardf");
	    		}
	    	}else {
	    		//삭제 실패
    		attr.addFlashAttribute("message", " 글 삭제 실패 ");
    		mv.setViewName("redirect:boardf");
	    	} 
    	}else {
    		attr.addFlashAttribute("message", " 글 삭제 실패 ");
    		mv.setViewName("redirect:boardf");
    	} 		
	} catch (Exception e) {
		e.printStackTrace();
		return mv;
	}
    return mv;
	}
	
	@RequestMapping(value = "/updatef")
	public ModelAndView Updatef(HttpServletRequest request,ModelAndView mv, BoardVO vo, RedirectAttributes rttr) {
		// 1. 요청분석 & Service
		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		vo = Service.SelectOne(vo);
		if ( vo != null ) {
			// 출력 -> updateForm.jsp
			mv.addObject("apple", vo);
			mv.setViewName("board/boardupdate");
		} else  {
			// 메시지 보관, boardList.jsp 출력 (서블릿으로)
			rttr.addFlashAttribute("message", "~~ 글번호의 자료를 읽어오는데 실패 했습니다 ~~");
			mv.setViewName("redirect:boardf");
		}
		// 2. 결과 : view 처리
		return mv;
	} //bupdatef
	
	
	@RequestMapping(value = "/boardUpdate")
	public ModelAndView update(HttpServletRequest request,ModelAndView mv,RedirectAttributes attr) {
	    vo.setSeq(Integer.parseInt(request.getParameter("seq")));// seq값을 파라미터로 받고 int 형으로 변환후 vo에 담는다.
	    vo.setTitle(request.getParameter("title"));
	    vo.setContent(request.getParameter("content"));
	    // 2. Service 처리
	    if(Service.boardupdate(vo)>0){
       	 	// 수정 성공
	    	attr.addFlashAttribute("message","글 수정 성공!");
			mv.setViewName("redirect:boardf");
        }else {
        	// 수정 실패
        	attr.addFlashAttribute("message", "수정 실패하였습니다.");
			mv.setViewName("redirect:updatef?seq="+vo.getSeq()); 
        }
		return mv;
	}
}
