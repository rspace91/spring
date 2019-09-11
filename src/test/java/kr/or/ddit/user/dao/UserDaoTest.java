package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:kr/or/ddit/config/spring/context-root.xml",
		"classpath:kr/or/ddit/config/spring/context-datasource.xml",
		"classpath:kr/or/ddit/config/spring/context-transaction.xml"})

public class UserDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	@Resource(name="userDao")
	private IUserDao userDao;
	
	private String  userId = "brownTest";
	
	@Before
	public void setup() {
		logger.debug("before");
		userDao.deleteUser( userId);
		
	}
	
	//테스트에 공통적으로 사용한 자원을 해제
	@After
	public void tearDown() {
		logger.debug("after");
	}
	
	@Test
	public void getUserListTest() {
		/***Given***/
		

		/***When***/
		List<User> userList = userDao.getUserList();
		logger.debug("userList  : {}", userList);
		
		/***Then***/
		assertTrue(userList.size()>100);
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
		User userVo = userDao.getUser(userId);

		/***Then***/
		assertEquals("브라운",userVo.getUserNm());
		assertEquals("brown1234",userVo.getPass());
	}
	/**
	 * 
	 * Method : getUserListOnlyHalfTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 사용자 반만 조회 테스트
	 */
	@Test
	public void getUserListOnlyHalfTest() {
		/***Given***/

		/***When***/
		List<User> userList = userDao.getUserListOnlyHalf();
		
		/***Then***/
		assertEquals(50, userList.size());
	}
	
	/**
	 * 
	 * Method : getUserPagingListTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void getUserPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(3);
		page.setPagesize(10);

		/***When***/
		List<User> userList = userDao.getUserPagingList( page);
		
		
		/***Then***/
		assertEquals(10, userList.size());
		assertEquals("xuserid22", userList.get(0).getUserId());
		
	}
	/**
	 * Method : getUserTotalCntTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 전체 사용자 건수 조회
	 */
	@Test
	public void getUserTotalCntTest() {
		/***Given***/
		

		/***When***/
		int totalCnt = userDao.getUserTotalCnt();
		/***Then***/
		assertEquals(105, totalCnt);
	}
	/**
	 * 
	 * Method : insertUserTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 사용자 등록 테스트
	 * @throws ParseException 
	 */
	@Test
	public void insertUserTest() throws ParseException {
		/***Given***/
		User user = new User();
		
		user.setUserId(userId);
		user.setUserNm("브라운테스트");
		user.setPass("brownTest12345");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAlias("곰테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");
		
	

		/***When***/
		int insertCnt = userDao.insertUser( user);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateUserTest() throws ParseException{
		/***Given***/
		

		/***When***/

		/***Then***/
	}
	
	

}
