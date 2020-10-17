package com.jeon.board.test;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jeon.board.config.ApplicationConfig;
import com.jeon.board.dao.BoardDao;
import com.jeon.board.dto.BoardDto;

public class BoardTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DataSource ds = ac.getBean(DataSource.class);
		BoardDao boardDao = new BoardDao(ds);
		
		
		
		int boardNo = 1;
		BoardDto boardDto = boardDao.selectBoard(boardNo);
		System.out.println(boardDto.getBoardTitle());
		System.out.println(boardDto.getBoardContent());
		System.out.println(boardDto.getBoardWriter());
		System.out.println(boardDto.getMemberDto().getMemberId());
	}

}
