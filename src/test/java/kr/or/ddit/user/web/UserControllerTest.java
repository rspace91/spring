package kr.or.ddit.user.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.WebTestConfig;

public class UserControllerTest extends WebTestConfig{
	private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);
	/**
	 * Method : userListTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 사용자 전체 리스트 조회 테스트
	 * @throws Exception 
	 */
	@Test
	public void userListTest() throws Exception {
		/***Given***/
		

		/***When***/
		mockMvc.perform(get("/user/userList"))
			.andExpect(model().attributeExists("userList"))
			.andExpect(view().name("user/userList"));
		/***Then***/
	}
	
	@Test
	public void userListOnlyHalfTest() throws Exception {
		/***Given***/
		

		/***When***/
		mockMvc.perform(get("/user/userListOnlyHalf"))
			.andExpect(model().attributeExists("userListOnlyHalf"))
			.andExpect(view().name("user/userListOnlyHalf"));
		/***Then***/
	}
	
	@Test
	public void userPagingListTest() throws Exception{
		/***Given***/
		

		/***When***/
		mockMvc.perform(get("/user/userPagingList"))
			.andExpect(model().attributeExists("userList"))
			.andExpect(view().name("user/userPagingList"));
		/***Then***/
	}
	
//	@Test
//	public void userPagingList_NoParaTest() throws Exception{
//		/***Given***/
//		
//
//		/***When***/
//		mockMvc.perform(get("/user/userPagingList"))
//			.andExpect(model().attributeExists("userPagingList"))
//			.andExpect(view().name("user/userPagingList"));
//		/***Then***/
//	}
	
	
	
	@Test
	public void pageTest() {
		Page page = new Page();
		logger.debug("page : {}", page);
	}
	

}
