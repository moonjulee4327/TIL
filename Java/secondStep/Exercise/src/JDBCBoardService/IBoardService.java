package JDBCBoardService;

import java.util.List;

import JDBCBoardVO.BoardVO;

public interface IBoardService {
	
	public List<BoardVO> displayBoardAll();
	
	public int insertWrite();
	
	public int updateWrite();
	
	public int deleteWrite();
	
	public List<BoardVO> searchWrite();

}
