package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.lprod.model.Lprod;

public class LprodDaoTest extends RootTestConfig {
	private static final Logger logger = LoggerFactory.getLogger(LprodDaoTest.class);
	
	
	@Resource(name="lprodDao")
	private ILprodDao lprodDao;
	
	@After
	public void tearDown() {
		logger.debug("after");
	}

	@Test
	public void getLprodListTest() {
		/***Given***/
		

		/***When***/
		List<Lprod> lprodList = lprodDao.getLprodList();

		/***Then***/
		assertEquals(9, lprodList.size());
	}

}
