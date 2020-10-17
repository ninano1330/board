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
	
	public int boardWrite(BoardDto boardDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDto boardSessionId = (MemberDto) session.getAttribute("boardSessionId");
		
		boardDto.setBoardWriter(boardSessionId.getMemberNo());
		boardDto.setBoardCreateDate(new Date());
		
		return boardDao.insertBoard(boardDto);
	}
	
	public List<BoardDto> boardAllList(){
		return boardDao.selectAllBoard();
	}
}
