package com.jeon.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import com.jeon.board.dto.MemberDto;
import com.jeon.board.service.MemberService;

@Component
public class JoinValidator implements Validator{
	
	@Autowired MemberService memberService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return MemberDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		
		MemberDto memberDto = (MemberDto) target;
		
		if(memberService.chkDupMemberId(memberDto.getMemberId())) {
			//errors.reject("existMemberId");
			//field, errorcode, message
			errors.rejectValue("memberId", "existMemberId","이미 존재하는 멤버아이디입니다.");
			
		}
		
	}

}
