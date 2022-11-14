package com.MoonJu.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MoonJu.board.mapper.BoardMapper;
import com.MoonJu.board.service.BoardService;
import com.MoonJu.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public int insertBoard(BoardVO boardVO) {
		return this.boardMapper.insertBoard(boardVO);
	}

	@Override
	public List<BoardVO> selectList(){
		return this.boardMapper.selectList();
	}
	
	@Override
	public BoardVO detail(int writeNo) {
		return this.boardMapper.detail(writeNo);
	}
	
	@Override
	public int update(BoardVO boardVO) {
		return this.boardMapper.update(boardVO);
	}
	
}
