/**
* ID 중복확인
*/

@RequestMapping(value = "/idDupCheck", method = RequestMethod.GET)
	public ModelAndView idDupCheck(ModelAndView mv,MemberVO vo) {
		mv.addObject("newId",vo.getId());
		vo = Service.selectOne(vo);
		if(vo!=null) {
			// 사용 불가능 id 존재
			mv.addObject("idUse","F");
		}else {
			// 사용 가능 id 존재
			mv.addObject("idUse","T");
		}
		mv.setViewName("member/idDupCheck");
		return mv;
	} // idDupCheck
