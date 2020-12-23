package com.jeon.board.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.jeon.board.dto.MemberDto;


@Repository
public class MemberDao {
	@Autowired
	private DataSource dataSource;
	
	//바인드 변수가 아닌 namedParameter 방식을 사용
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	//table insert,update를 위한 객체
	private SimpleJdbcInsert simpleJdbcIntsert;
	
	//camel 표기법과 table column 자동 매핑
	RowMapper<MemberDto> rowMapper = BeanPropertyRowMapper.newInstance(MemberDto.class);
	
	public MemberDao(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		simpleJdbcIntsert = new SimpleJdbcInsert(dataSource);
	}
	
	public String insertMember(MemberDto memberDto) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(memberDto);
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
