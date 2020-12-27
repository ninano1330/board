package com.jeon.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeon.board.dto.MemberDto;
import com.jeon.board.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberSerive;
	
	@Autowired
	JoinValidator joinValidator;
	
	
	@InitBinder
	public void memberBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(joinValidator);
		
	}

	// GET /members/joinForm
	@GetMapping(value="/members/join")
	public String memberJoinForm() {
		return "member/joinForm";
	}
	
	// Create
	//  POST /members
	@PostMapping(value="/members/join")
	@ResponseBody
	public String memberJoin(@Valid MemberDto memberDto, Errors errors, String emailDomain) {
		if(errors.hasErrors()) {
			/*
			 * org.springframework.validation.BeanPropertyBindingResult: 1 errors
				Error in object 'memberDto': codes [existMemberId.memberDto,existMemberId]; arguments []; default message [null]
			*/
			
			List<FieldError> fieldErrorArr = errors.getFieldErrors();
			for(FieldError fieldError : fieldErrorArr) {
				
			}
			
			ObjectMapper mapper = new ObjectMapper();
			
			System.out.println(errors.getObjectName());
			System.out.println("test : " + errors.getFieldValue("memberId"));
			System.out.println("test2 : " + errors.getFieldError("memberId"));
			System.out.println(errors.getFieldType("memberId"));

//			System.out.println(errors.getFieldError());
//			System.out.println(errors.getFieldError("codes"));
//			System.out.println(errors.getErrorCount());
//			System.out.println(errors.getFieldErrorCount());
//			System.out.println(errors.hashCode());
//			System.out.println(errors.getFieldValue("codes"));

			return errors.toString();
		}
		//System.out.println(memberDto);
		//System.out.println(emailDomain);
		
		int insertMemberCode = memberSerive.insertMember(memberDto);
		if(insertMemberCode > 0) {
			return "redirect:/main";
		}else if(insertMemberCode ==0){
			
		}else {
			//에러페이지
		}
		
		return "";
	}
	
	
	// Update
	// POST /members/me
	@PostMapping(value="/members/me")
	public String memberUpdate() {
		return "main";
	}
}
