package com.jeon.board.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.jeon.board.dto.MemberDto;

@Repository
public class LoginDao {
	//바인드 변수가 아닌 namedParameter 방식을 사용
	private NamedParameterJdbcTemplate jdbc;
	
	//table insert,update를 위한 객체
	private SimpleJdbcInsert insertAction;
	
	//camel 표기법과 table column 자동 매핑
	private RowMapper<MemberDto> rowMapper = BeanPropertyRowMapper.newInstance(MemberDto.class);
	
	private JdbcTemplate jdbcTemplate;
	
	public LoginDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public MemberDto login(MemberDto memberDto) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = :memberId AND MEMBER_PW = :memberPw";
		SqlParameterSource param = new BeanPropertySqlParameterSource(memberDto);
		
		try {
			return jdbc.queryForObject(sql, param, rowMapper);
		}catch(Exception e) {
			return null;
		}
		
		//return jdbc.query(sql, param, rowMapper);
		
	}
}
