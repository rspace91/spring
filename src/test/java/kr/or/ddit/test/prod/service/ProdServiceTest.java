package kr.or.ddit.test.prod.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.prod.model.Prod;
import kr.or.ddit.prod.service.IProdService;

public class ProdServiceTest  extends RootTestConfig {

	
	@Resource(name="prodService")
	private IProdService IprodService;
	
	
	@Test
	public void  getProdTest() {
		/***Given***/
		String prodId ="P101";

		/***When***/
		List<Prod> prodList = IprodService.getProdList(prodId);
		/***Then***/
		assertEquals(6, prodList.size());
	}

}
