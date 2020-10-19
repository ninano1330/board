package com.jeon.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
	
	private RowMapper<BoardDto> BoardMemberRowMapper = new RowMapper<BoardDto>() {
		@Override
		public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardDto boardDto = new BoardDto();
			
			boardDto.setBoardNo(rs.getInt("BOARD_NO"));
			boardDto.setBoardTitle(rs.getString("BOARD_TITLE"));
			boardDto.setBoardContent(rs.getString("BOARD_CONTENT"));
			boardDto.setmemberNo(rs.getInt("MEMBER_NO"));
			boardDto.setBoardCreateDate(rs.getDate("BOARD_CREATE_DATE"));
			boardDto.setBoardUpdateDate(rs.getDate("BOARD_UPDATE_DATE"));
			//System.out.println("ROWMAPPER MEMBER_ID : " + rs.getString("MEMBER_ID"));
			boardDto.getMemberDto().setMemberId(rs.getString("MEMBER_ID"));
			//System.out.println(boardDto.getMemberDto().getMemberId());
			return boardDto;
		}
	};
	
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
	
	public int updateBoard(BoardDto boardDto) {
		String sql = "UPDATE BOARD SET BOARD_TITLE = :boardTitle, BOARD_CONTENT = :boardContent WHERE BOARD_NO = :boardNo";
		SqlParameterSource params = new BeanPropertySqlParameterSource(boardDto);
		
		return jdbc.update(sql, params);
	}
	
	public int deleteBoard(int boardNo) {
		String sql = "DELETE FROM BOARD WHERE BOARD_NO = :boardNo";
		
		//SqlParameterSource params = new BeanPropertySqlParameterSource(boardNo);
		Map<String,Object> params = Collections.singletonMap("boardNo", boardNo);
		
		return jdbc.update(sql, params);
	}
	
	
	public List<BoardDto> selectAllBoard() {
		String sql = "SELECT * FROM BOARD B, MEMBER M WHERE B.MEMBER_NO = M.MEMBER_NO";
		
		//return jdbc.query(sql, rowMapper);
		return jdbc.query(sql, BoardMemberRowMapper);
	}
	
	
	public BoardDto selectBoard(int boardNo) {
		String sql = "SELECT * "
				+ "FROM BOARD B, MEMBER M "
				+ "WHERE 1=1 "
				+ "AND B.MEMBER_NO = M.MEMBER_NO "
				+ "AND B.BOARD_NO = :boardNo ";
		
		//return jdbc.queryForObject(sql, Collections.singletonMap("boardNo", boardNo), rowMapper);
		return jdbc.queryForObject(sql, Collections.singletonMap("boardNo", boardNo), BoardMemberRowMapper);	
	}
	
}
