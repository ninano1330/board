//package com.jeon.board.dao;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.sql.DataSource;
//
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.stereotype.Repository;
//
//import kr.or.connect.reservation.dto.PromotionDto;
//import kr.or.connect.reservation.dto.ReservationInfoPriceDto;
//import static kr.or.connect.reservation.dao.sql.PromotionDaoSql.*;
//
//
//@Repository
//public class SampleDao {
//	private NamedParameterJdbcTemplate jdbc;
//	private SimpleJdbcInsert insertAction;
//	private RowMapper<PromotionDto> rowMapper = BeanPropertyRowMapper.newInstance(PromotionDto.class);
//
//	public SampleDao(DataSource dataSource) {
//		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
//		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("").usingGeneratedKeyColumns("");
//	}
//	
//	public List<PromotionDto> selectAll(Integer start, Integer limit) {
//			Map<String, Integer> params = new HashMap<>();
//			params.put("start", start);
//			params.put("limit", limit);
//		return jdbc.query(SELECT_PAGING, params, rowMapper);
//	}
//	
//	public Long insert(ReservationInfoPriceDto reservationInfoPriceDto) {
//		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfoPriceDto);
//		return insertAction.executeAndReturnKey(params).longValue();
//	}
//	
//	public int deleteById(Long id) {
//		Map<String, ?> params = Collections.singletonMap("id", id);
//		return jdbc.update(DELETE_BY_ID, params);
//	}
//	
//	public int selectCount() {
//		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
//	}
//	
//	
//}
