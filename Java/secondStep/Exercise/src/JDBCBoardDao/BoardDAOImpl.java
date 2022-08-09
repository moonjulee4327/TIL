package JDBCBoardDao;

import java.util.List;

import JDBCBoardVO.BoardVO;

public class BoardDAOImpl implements IBoardDAO{
	
	private static IBoardDAO boardDao;
	
	private BoardDAOImpl() {
		
	}
	
	public static IBoardDAO getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDAOImpl();
		}
		return boardDao;
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
