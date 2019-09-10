package kr.or.ddit.test.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/ioc/application-context-ioc-test.xml")
public class SpringIocTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringIocTest.class);
	
	@Resource(name="dbProperty")
	private DbProperty dbProperty;
	
	@Resource(name="dbPropertySetter")
	private DbProperty dbPropertySetter;
	
	/**
	 * Method : propertyPlaceHolderTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : <context:property-placeholder>테스트
	 */
	@Test
	public void propertyPlaceholderTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
		assertNotNull(dbProperty);
		assertEquals("RRR", dbProperty.getUser());
		assertEquals("java", dbProperty.getPass());
		assertEquals("oracle.jdbc.driver.OracleDriver", dbProperty.getDriver());
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", dbProperty.getUrl());
		
		assertNotNull(dbPropertySetter);
		assertEquals("RRR", dbPropertySetter.getUser());
		assertEquals("java", dbPropertySetter.getPass());
		assertEquals("oracle.jdbc.driver.OracleDriver", dbPropertySetter.getDriver());
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", dbPropertySetter.getUrl());
		
	}

}
