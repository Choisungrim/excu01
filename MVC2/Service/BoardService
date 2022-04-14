package service;

import java.util.List;
import util_DB.BoardDAO;
import vo.BoardVO;

public class BoardService {
	BoardDAO dao = new BoardDAO();
	
	public List<BoardVO> SelectList() {
		return dao.selectList();
	}
	public BoardVO SelectOne(BoardVO vo) {
		return dao.SelectOne(vo);
	}
	public int update(BoardVO vo) {
		return dao.update(vo);
	}
}
