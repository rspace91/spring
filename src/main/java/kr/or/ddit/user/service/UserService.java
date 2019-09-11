package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

@Service
public class UserService implements IUserService{
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Resource(name="userDao")
	private IUserDao userDao;
	
	public  UserService() {
	}
	public  UserService(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	
	/**
	 * Method : getUserList
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<User> getUserList() {
		logger.debug("getUserList()");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return userDao.getUserList();
	}
	
	/**
	 * 
	 * Method : getUserListOnlyHalf 
	 * 작성자 : 
	 * PC-12 변경이력 :
	 * @return 
	 * Method 설명 : 사용자 반(50명)만 조회
	 */
	@Override
	public List<User> getUserListOnlyHalf() {
		List<User> userList = userDao.getUserListOnlyHalf();
		return userList;
	}

	/**
	 * 
	 * Method : getUserPagingList 작성자 : PC-12 변경이력 :
	 * 
	 * @param page
	 * @return Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Override
	public Map<String, Object> getUserPagingList(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();


		List<User> userList = userDao.getUserPagingList( page);
		int totalCnt = userDao.getUserTotalCnt();

		map.put("userList", userList);
		map.put("paginationSize", (int) Math.ceil((double) totalCnt / page.getPagesize()));

		return map;
	}

	/**
	 * Method : getUserTotalCnt 
	 * 작성자 : PC-12 
	 * 변경이력 :
	 * @param sqlSession
	 * @return Method 설명 : 전체 사용자 건수 조회
	 */
	@Override
	public int getUserTotalCnt() {
		int res = userDao.getUserTotalCnt();

		return res;
	}

	/**
	 * Method : insertUser 작성자 : 
	 * PC-12 변경이력 :
	 * @param sqlSession
	 * @param user
	 * @return Method 설명 : 사용자 등록
	 */
	@Override
	public int insertUser(User user) {
		// 선언적 트랜잭션
		// . 예외가 발생 했을 때 정상적으로 rollback이 되는지
		// . 예외가 발생하지 않고 정상적으로 코드가 실행되었을 때
		// 명시적인 commit 없는데 commit이 정상적으로 되는지
		int res = userDao.insertUser( user);
		return res;
	}

	/**
	 * Method : deleteUser 작성자 : PC-12 변경이력 :
	 * 
	 * @param sqlSession
	 * @param userId
	 * @return Method 설명 : 사용자 삭제
	 */
	@Override
	public int deleteUser(String userId) {
		int res = userDao.deleteUser( userId);
		return res;
	}

	@Override
	public int updateUser(User user) {
		int updateUser = userDao.updateUser( user);
		return updateUser;
	}
	@Override
	public User getUser(String userId) {
		User user = userDao.getUser( userId);
		return user;
	}
	
}
