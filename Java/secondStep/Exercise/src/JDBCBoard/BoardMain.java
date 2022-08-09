package JDBCBoard;

import java.util.Scanner;

import JDBCBoardService.BoardServiceImpl;
import JDBCBoardService.IBoardService;

public class BoardMain {
	
	private Scanner sc = new Scanner(System.in);
	private IBoardService boardService;
	
	public BoardMain() {
		boardService = BoardServiceImpl.getInstance();
	}
	
	
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 게시판 전체 목록");
		System.out.println("  2. 새 글 작성");
		System.out.println("  3. 작성 글 수정");
		System.out.println("  4. 작성 글 삭제");
		System.out.println("  5. 게시판 글 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
		
	}
	
	public void start() {
		
		int menuNum = sc.nextInt();
		
		switch(menuNum) {
			case 1 :
				displayBoardAll();
				break;
			case 2 : 
				insertWrite();
				break;
			case 3 : 
				updateWrite();
				break;
			case 4 : 
				deleteWrite();
				break;
			case 5 : 
				searchWrite();
				break;
			case 6 : 
				System.out.println("작업을 마칩니다.");
				break;
		}
		
		
		
		
	}


	private void searchWrite() {
		
		
	}


	private void deleteWrite() {
		
		
	}


	private void updateWrite() {
		
		
	}


	private void insertWrite() {
		
		
	}


	private void displayBoardAll() {
		
		
	}
	
	
	
}
