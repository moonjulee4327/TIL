package JDBCBoardService;

import java.util.List;

import JDBCBoardDao.BoardDAOImpl;
import JDBCBoardDao.IBoardDAO;
import JDBCBoardVO.BoardVO;

public class BoardServiceImpl implements IBoardService{
	
	private static IBoardService boardService;
	
	private IBoardDAO boardDao;
	
	private BoardServiceImpl() {
		boardDao = BoardDAOImpl.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}
	
	@Override
	public List<BoardVO> displayBoardAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertWrite() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateWrite() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteWrite() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> searchWrite() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
