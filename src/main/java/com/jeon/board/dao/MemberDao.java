package com.jeon.board.dao;

import java.util.Collections;

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
		simpleJdbcIntsert = new SimpleJdbcInsert(dataSource)
				.withTableName("MEMBER")   // 테이블 명
				.usingGeneratedKeyColumns("MEMBER_NO"); // 자동증가값
	}
	
	public int insertMember(MemberDto memberDto) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(memberDto);
		
		try {
			return simpleJdbcIntsert.executeAndReturnKey(params).intValue();
		}catch( org.springframework.dao.DuplicateKeyException e){
			return 0;
		}catch (Exception e) {
			return -1;
		}
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
	
	public int selectMemberbyId(String memberId) {
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = :memberId";
		return namedParameterJdbcTemplate.queryForObject(sql, Collections.singletonMap("memberId", memberId), Integer.class);
	}
	
	//@Transactional
	 
}
