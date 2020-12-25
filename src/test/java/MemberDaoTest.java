import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jeon.board.config.ApplicationConfig;
import com.jeon.board.dto.MemberDto;

@Repository
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:config/springbeans.xml")
@ContextConfiguration(classes ={ApplicationConfig.class})
public class MemberDaoTest {
	@Autowired
	private DataSource dataSource;
	
	//바인드 변수가 아닌 namedParameter 방식을 사용
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	//table insert,update를 위한 객체
	private SimpleJdbcInsert simpleJdbcIntsert;
	
	//camel 표기법과 table column 자동 매핑
	RowMapper<MemberDto> rowMapper = BeanPropertyRowMapper.newInstance(MemberDto.class);
	
//	public MemberDaoTest(DataSource dataSource) {
//		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//		simpleJdbcIntsert = new SimpleJdbcInsert(dataSource);
//	}
	
	@Before
	public void setBeans() throws Exception{
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		simpleJdbcIntsert = new SimpleJdbcInsert(dataSource)
							.withTableName("MEMBER")   // 테이블 명
							.usingGeneratedKeyColumns("MEMBER_NO"); // 자동증가값
	}
	
	@Test
	public void insertMember() {
		MemberDto memberDto = new MemberDto();
		memberDto.setMemberId("ADMIN");
		memberDto.setMemberPw("ADMIN");
		memberDto.setMemberName("전민규");
		
		SqlParameterSource params = new BeanPropertySqlParameterSource(memberDto);
		System.out.println(simpleJdbcIntsert.executeAndReturnKey(params).intValue());
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
