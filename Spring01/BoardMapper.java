package mapperInterface;

import java.util.List;

import vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> SelectList();

	BoardVO SelectOne(BoardVO vo);

	int countUp(BoardVO vo);

	int goodupdate(BoardVO vo);

	int badupdate(BoardVO vo);

	int delete(BoardVO vo);

	int insert(BoardVO vo);

	int boardupdate(BoardVO vo);
}
