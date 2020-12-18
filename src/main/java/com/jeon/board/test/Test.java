package com.jeon.board.test;


import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jeon.board.config.ApplicationConfig;
import com.jeon.board.controller.BoardAPIController;
import com.jeon.board.dao.LoginDao;
import com.jeon.board.dto.BoardDto;
import com.jeon.board.dto.MemberDto;
import com.jeon.board.service.LoginService;

public class Test {

	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DataSource ds = ac.getBean(DataSource.class);
		Connection conn = ds.getConnection();
		
		System.out.println(conn);
		
		
		LoginDao loginDao = new LoginDao(ds);
		MemberDto memberDto = new MemberDto();
		
		memberDto.setMemberId("ADMIN");
		memberDto.setMemberPw("ADMIN");
		//List<MemberDto> al = loginDao.login(memberDto);
		MemberDto result = loginDao.login(memberDto);
		
//		System.out.println(al.get(0).getMemberId());
//		System.out.println(al.get(0).getMemberPw());
		
		System.out.println(result.getMemberId());
		System.out.println(result.getMemberPw());
		
		
		LoginService loginService = ac.getBean(LoginService.class);
		System.out.println(loginService);
		System.out.println(loginService.getLogindao());
		
		
		
		BoardDto boardDto = new BoardDto();
		System.out.println(boardDto.getBoardNo());
		
	}

}
