package com.jeon.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeon.board.dao.LoginDao;
import com.jeon.board.dto.MemberDto;

@Service
public class LoginService {
	@Autowired
	private LoginDao logindao;

	public MemberDto login(MemberDto memberDto) {
		return logindao.login(memberDto);
	}
	
	public LoginDao getLogindao() {
		return logindao;
	}

	public void setLogindao(LoginDao logindao) {
		this.logindao = logindao;
	}
}
