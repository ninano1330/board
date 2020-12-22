package com.jeon.board.dao;

import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.jeon.board.dto.MemberDto;


@Repository
//@RunWith(JUnit4ClassRunner.class)
public class MemberDao {
	//바인드 변수가 아닌 namedParameter 방식을 사용
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	//table insert,update를 위한 객체
	private SimpleJdbcInsert simpleJdbcIntsert;
	
	//camel 표기법과 table column 자동 매핑
	RowMapper<MemberDto> rowMapper = BeanPropertyRowMapper.newInstance(MemberDto.class);
	
	public String insertMember(MemberDto memberDto) {
		//simpleJdbcIntsert.
		//
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
	
	//@Transactional
	 
}
