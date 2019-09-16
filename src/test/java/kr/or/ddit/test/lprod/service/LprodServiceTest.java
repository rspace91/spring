package kr.or.ddit.test.lprod.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.lprod.service.ILprodService;

public class LprodServiceTest extends RootTestConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(LprodServiceTest.class);
	
	@Resource(name="lprodService")
	private ILprodService lprodService;
	
	
	@Test
	public void getLprodListTest() {
		/***Given***/
		/* ILprodDao lprodDao = new LprodDao(); */

		/***When***/
		List<Lprod> lprodList = lprodService.getLprodList();
		/***Then***/
		assertEquals(9, lprodList.size());
	}
	
	@Test
	public void getLprodPagingList() {
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(5);
		/***When***/
		//Map<String, Object> resultMap = lprodService.getLprodPagingList(page);
		List<Lprod> lprodList = lprodService.getLprodPagingList( page);
		/***Then***/
		assertEquals(5, lprodList.size());
	}
	
	@Test
	public void getLprodTotalCnt() {
		/***Given***/
		/***When***/
		int totalCnt = lprodService.getLprodTotalCnt();
		/***Then***/
		assertEquals(9, totalCnt);
	}
}
