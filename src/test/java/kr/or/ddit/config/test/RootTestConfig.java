package kr.or.ddit.config.test;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.user.service.UserServiceTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:kr/or/ddit/config/spring/context-root.xml",
		"classpath:kr/or/ddit/config/spring/context-datasource-test.xml",
		"classpath:kr/or/ddit/config/spring/context-transaction.xml"})
public class RootTestConfig {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

	
	@Resource(name="datasource")
	private BasicDataSource  datasource;

	
	
	@Before
	public void setup() {
		logger.debug("before");
		
		
		//init.sql에 있는 모든 sql 문장을  테스트 메소드 실행전에 실행
		//init.sql에는 table 데이터 삭제, 데이터 입력 sql 문장이 있다.
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("/kr/or/ddit/db/init.sql"));
		populator.setContinueOnError(false);      //init.sql을 실행하다 에러가 발생할 경우 중지
		DatabasePopulatorUtils.execute(populator, datasource);
	}
	
	
	@Ignore//테스트코드를 실행하지 말고 건너띄어라
	@Test
	public void dummy() {
		
	}

}
