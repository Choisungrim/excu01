package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapperInterface.MemberMapper;
import util_DB.MemberDAO;
import vo.MemberVO;

//** interface 자동완성 
//=> Alt + Shift + T  
//=> 또는 마우스우클릭 PopUp Menu 의  Refactor - Extract Interface...
@Service
public class MemberServiceImpl implements MemberService {
	// ** Mybatis interface 방식 적용
    // => MemberMapper 의 인스턴스를 스프링이 생성해주고 이를 주입받아 실행함
    //    단, 설정화일에 <mybatis-spring:scan base-package="mapperInterface"/> 반드시 추가해야함
    //    MemberDAO => mapperInterface 사용으로 MemberMapper 가 역할 대신함
	@Autowired
	MemberMapper mapper;
	//MemberDAO dao = new MemberDAO(); -> MyBatis 적용 전 
	
	@Override
	public List<MemberVO> selectList() {
		return mapper.selectList();
	}
	@Override
	public MemberVO selectOne(MemberVO vo) {
		return mapper.selectOne(vo);
	}
	@Override
	public int insert(MemberVO vo) {
		return mapper.insert(vo);
	}
	@Override
	public int update(MemberVO vo) {
		return mapper.update(vo);
	}
	@Override
	public int delete(MemberVO vo) {
		return mapper.delete(vo);
	}

} //class
