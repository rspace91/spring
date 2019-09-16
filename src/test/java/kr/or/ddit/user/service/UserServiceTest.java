package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;


public class UserServiceTest extends RootTestConfig{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

	
	private String userId = "brownTest";
	
	
	@Resource(name="userService")
	private IUserService userService;
	

	
	
	
	/**
	 * 
	 * Method : getUserListTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : getUserList 테스트
	 */
	@Test
	public void getUserListTest() {
		/***Given***/
		

		/***When***/
		List<User> userList = userService.getUserList();
		
		/***Then***/
		assertTrue(userList.size() >100);
	}
	/**
	 * 
	 * Method : getUserTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";

		/***When***/
		User userVo = userService.getUser(userId);

		/***Then***/
		assertEquals("브라운",userVo.getUserNm());
		assertEquals("brown1234",userVo.getPass());
	}
	/**
	 * 
	 * Method : getUserListOnlyHalf
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 사용자 반만 조회 테스트
	 */
	@Test
	public void getUserListOnlyHalf() {
		/***Given***/

		/***When***/
		List<User> userList = userService.getUserListOnlyHalf();
		
		/***Then***/
		assertEquals(50, userList.size());
	}
	
	/**
	 * 
	 * Method : getUserPagingList
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void getUserPagingList() {
		/***Given***/
		Page page = new Page();
		page.setPage(3);
		page.setPagesize(10);

		/***When***/
		Map<String, Object> resultMap = userService.getUserPagingList(page);
		List<User> userList = (List<User>)resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		/***Then***/
		assertEquals(10, userList.size());
		assertEquals("xuserid22", userList.get(0).getUserId());
		assertEquals(11, paginationSize );
		
	}
	
	
	@Test
	public void insertUserTest() throws ParseException{
		/***Given***/
		User user = new User();
		
		user.setUserId(userId);
		user.setUserNm("브라운테스트");
		user.setPass("brownTest1234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAlias("곰테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");

		/***When***/
		int insertCnt = userService.insertUser(user);
		
		/***Then***/
		assertEquals(1,insertCnt);
		
	}
	
	@Test
	public void ceilingTest() {
		/***Given***/
		int toatalCnt = 105;
		int pagesize = 10;

		/***When***/
		double paginationSize = Math.ceil((double)toatalCnt / pagesize);
		/***Then***/
		assertEquals(11, (int)paginationSize);
	}
	
	@Test
	public void updateUserTest() throws ParseException{
		/***Given***/
		

		/***When***/

		/***Then***/
	}
	

}
