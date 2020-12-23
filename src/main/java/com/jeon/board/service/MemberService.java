package com.jeon.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeon.board.dao.MemberDao;
import com.jeon.board.dto.MemberDto;


@Service
public class MemberService {
	@Autowired
	MemberDao MemberDao;
	
	public String insertMember(MemberDto memberDto) {
		MemberDao.insertMember(memberDto);
		return "";
	}
	
	public String updateMember(MemberDto memberDto) {
		return "";
	}
	
	public String deleteMember(MemberDto memberDto) {
		return "";
	}
	
	public String selectMember(MemberDto memberDto) {
		return "";
	}
	public boolean checkid(String memberid) {
		return true;
	}
}
