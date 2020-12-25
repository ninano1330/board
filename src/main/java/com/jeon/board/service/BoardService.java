package com.jeon.board.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeon.board.dao.BoardDao;
import com.jeon.board.dto.BoardDto;
import com.jeon.board.dto.MemberDto;

@Service
public class BoardService {
	@Autowired
	BoardDao boardDao;
	
	public int write(BoardDto boardDto, int memberNo) {
		boardDto.setmemberNo(memberNo);
		boardDto.setBoardCreateDate(new Date());
		
		return boardDao.insertBoard(boardDto);
	}
	
	public List<BoardDto> allList(){
		return boardDao.selectAllBoard();
	}
	
	public BoardDto getByBoardNo(int boardNo) {
		return boardDao.selectBoard(boardNo);
	}
	
	public int update(BoardDto boardDto) {
		boardDto.setBoardUpdateDate(new Date());
		return boardDao.updateBoard(boardDto);
	}
	
	public int delete(int boardNo) {
		return boardDao.deleteBoard(boardNo);
	}
}
