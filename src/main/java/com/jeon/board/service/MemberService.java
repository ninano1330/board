package com.jeon.board.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeon.board.dao.MemberDao;
import com.jeon.board.dto.MemberDto;


@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	
	public int insertMember(MemberDto memberDto) {
		memberDto.setMemberGrade(1);
		memberDto.setMemberJoinDate(new Date());
		
		return memberDao.insertMember(memberDto);
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
	
	public boolean chkDupMemberId(String memberId) {
		if(memberDao.selectMemberbyId(memberId) == 1) {
			return true;
		}else {
			return false;
		}
	}
}
