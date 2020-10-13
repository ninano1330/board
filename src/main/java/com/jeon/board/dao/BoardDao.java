package com.jeon.board.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.jeon.board.dto.BoardDto;

@Repository
public class BoardDao {
	//바인드 변수가 아닌 namedParameter 방식을 사용
	private NamedParameterJdbcTemplate jdbc;
	
	//table insert,update를 위한 객체
	private SimpleJdbcInsert insertAction;
	
	//camel 표기법과 table column 자동 매핑
	private RowMapper<BoardDto> rowMapper = BeanPropertyRowMapper.newInstance(BoardDto.class);
	
	public BoardDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("BOARD")
				.usingGeneratedKeyColumns("BOARD_NO");
	}
	
	public int insertBoard(BoardDto boardDto) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(boardDto);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	
}
