package com.MoonJu.board.service;

import java.util.List;

import com.MoonJu.board.vo.BoardVO;

public interface BoardService {
	
	// 게시판 글 등록
	public int insertBoard(BoardVO boardVO);
	
	// 게시판 리스트 조회
	public List<BoardVO> selectList();

}
