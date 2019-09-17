package kr.or.ddit.lprod.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.config.test.WebTestConfig;

public class LprodControllerTest extends WebTestConfig {
	private static final Logger logger = LoggerFactory.getLogger(LprodControllerTest.class);

	
	/**
	 * Method : lprodListTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @throws Exception
	 * Method 설명 : lprod  전체 리스트 조회
	 */
	@Test
	public void lprodListTest() throws Exception {
		/***Given***/
		

		/***When***/
		mockMvc.perform(get("/lprod/lprodList"))
			.andExpect(model().attributeExists("lprodList"))
			.andExpect(view().name("lprod/lprodList"));
		/***Then***/
	}

}
