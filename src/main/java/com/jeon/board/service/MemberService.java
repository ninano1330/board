package com.jeon.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeon.board.dao.MemberDao;


@Service
public class MemberService {
	@Autowired
	MemberDao MemberDao;
	
	
}
