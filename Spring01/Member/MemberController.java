package com.ncs.green;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.MemberService;
import vo.MemberVO;


@Controller
public class MemberController {
	@Autowired // 자동주입
	// => 조건 : 주입을 받으려는 구현 클래스가 반드시 있어야함.
	MemberService Service;
	MemberVO vo = new MemberVO();
	
	@RequestMapping(value = "/loginf", method = RequestMethod.GET)
	public ModelAndView loginForm(ModelAndView mv) {
		mv.setViewName("member/loginForm");
		return mv;
	} // loginf
	
	@RequestMapping(value = "/joinf", method = RequestMethod.GET)
	public ModelAndView joinForm(ModelAndView mv) {
		mv.setViewName("member/joinForm");
		return mv;
	}// joinf
	
	
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request,ModelAndView mv,MemberVO vo,RedirectAttributes attr) {
		
		String password = vo.getPassword();
		vo = Service.selectOne(vo);
		if(vo!=null) {
			// Password 확인
			if(vo.getPassword().equals(password)) {
				// Login 성공 -> Login정보(id,name) 보관 -> home
				HttpSession session = request.getSession();
				session.setAttribute("Login_id", vo.getId());
				session.setAttribute("Login_Name", vo.getName());
				attr.addFlashAttribute("message", "~~~Login 성공~~~");
				mv.setViewName("redirect:home");
				// 요청명 => "home"으로 Send Redirect 
				// => redirect의 경우 메시지 출력이 안된다. 해결하기위해 redirectattributes 
			}else {
				// password 오류 발생 -> 로그인 폼
				mv.addObject("message", "Password 오류입니다.");
				mv.setViewName("member/loginForm");
			}
		}else { 
			// id 오류 발생 -> 로그인 폼
			mv.addObject("message", "Id 오류입니다.");
			mv.setViewName("member/loginForm");
		}
		//결과처리
		return mv;
	}//login
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request,ModelAndView mv,RedirectAttributes attr) {
		
		request.getSession().invalidate();
		attr.addFlashAttribute("message", "로그아웃 되었습니다.");
		mv.setViewName("redirect:home");
		return mv;
	}// logout
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView join(ModelAndView mv,MemberVO vo) {
		if(Service.insert(vo)>0) {
			System.out.println(vo.getBirthd());
			mv.addObject("message", "회원가입 완료");
			mv.setViewName("member/loginForm");
		}else {
			mv.addObject("message", "회원가입 오류 다시하세요");
			mv.setViewName("member/joinForm");
		}
		return mv;
	}// logout
	
	@RequestMapping(value = "mList")
	public ModelAndView mList(ModelAndView mv) {
		mv.addObject("apple", Service.selectList());
		System.out.println(vo.getLev());
		mv.setViewName("member/memberList");
		
		return mv;
	}//mList
	
	@RequestMapping(value = "mDetail")
	public ModelAndView mDetail(HttpServletRequest request ,ModelAndView mv, MemberVO vo) {
		HttpSession session = request.getSession(false);
		request.setAttribute("apple", vo);
		if(session!=null&&session.getAttribute("Login_id")!=null) {
			vo.setId((String)session.getAttribute("Login_id"));
			vo = Service.selectOne(vo);
			if(vo!=null) {
				if(request.getParameter("jcode")!=null&&request.getParameter("jcode").equals("U")) {
					mv.addObject("apple",vo);
					mv.setViewName("member/updateForm");
				}else {
					System.out.println(vo.getLev());
					mv.addObject("apple",vo);
					mv.setViewName("member/memberDetail");
				}
			}else {
				mv.addObject("message","~~vo null 개인정보 읽어오기 실패");
				mv.setViewName("member/loginForm");
			}
		}else {
			mv.addObject("message","세션정보가 없습니다.");
			mv.setViewName("member/loginForm");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/mUpdate")
	public ModelAndView mupdate(HttpServletRequest request,ModelAndView mv,MemberVO vo) {
		mv.addObject("apple", vo);
		if(Service.update(vo)>0) {
			request.getSession().setAttribute("Login_Name",vo.getName());
			System.out.println(vo.getBirthd());
			mv.addObject("message", "수정성공");
			mv.setViewName("member/memberDetail");
		}else {
			mv.addObject("message", "수정실패");
			mv.setViewName("member/updateForm");
		}
		return mv;
	}// logout
	
	@RequestMapping(value = "/mDelete")
	public ModelAndView mDelete(HttpServletRequest request,ModelAndView mv,MemberVO vo, RedirectAttributes attr) {
		HttpSession session = request.getSession(false);
		if(session!=null&&session.getAttribute("Login_id")!=null) {
			vo.setId((String)session.getAttribute("Login_id"));
			if( Service.delete(vo)>0) {
				attr.addFlashAttribute("message","회원탈퇴 완료");
				session.invalidate();
			}else attr.addFlashAttribute("message","회원탈퇴 실패 잠시 후 다시하세요.");
		}else attr.addFlashAttribute("message","회원탈퇴 실패 잠시 후 다시하세요. 로그인정보없음");
		mv.setViewName("redirect:home");
		return mv;
	}
}//class
