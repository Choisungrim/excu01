package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapperInterface.BoardMapper;
import vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMapper mapper;
	
	@Override
	public List<BoardVO> SelectList() {
		return mapper.SelectList();
	}
	@Override
	public BoardVO SelectOne(BoardVO vo) {
		return mapper.SelectOne(vo);
	}
	@Override
	public int countUp(BoardVO vo) {
		return mapper.countUp(vo);
	}
	@Override
	public int goodupdate(BoardVO vo) {
		return mapper.goodupdate(vo);
	}
	@Override
	public int badupdate(BoardVO vo) {
		return mapper.badupdate(vo);
	}
	@Override
	public int delete(BoardVO vo) {
		return mapper.delete(vo);
	}
	@Override
	public int insert(BoardVO vo) {
		return mapper.insert(vo);
	}
	@Override
	public int boardupdate(BoardVO vo) {
		return mapper.boardupdate(vo);
	}
}
