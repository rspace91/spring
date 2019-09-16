package kr.or.ddit.test.prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.model.Prod;

public class ProdDaoTest  extends RootTestConfig {

	private static final Logger logger = LoggerFactory.getLogger(ProdDaoTest.class);
	
	@Resource(name="prodDao")
	private IProdDao prodDao;
	
	
	@After
	public void tearDown() {
		logger.debug("after");
	}
	
	
	
	   @Test
	   public void getProdListTest() {

	      /***Given***/
	      String lprodGu = "P101";

	      /***When***/
	      List<Prod> prodList = prodDao.getProdList(lprodGu);

	      /***Then***/
	      assertEquals(6, prodList.size());

	   }

}
