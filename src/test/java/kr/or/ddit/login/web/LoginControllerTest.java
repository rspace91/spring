package kr.or.ddit.login.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.config.test.WebTestConfig;
import kr.or.ddit.user.model.User;

public class LoginControllerTest extends WebTestConfig {
	private static final Logger logger = LoggerFactory.getLogger(LoginControllerTest.class);
	/**
	 * Method : loginViewTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 로그인 화면 요청 테스트
	 * @throws Exception 
	 */
	@Test
	public void loginViewTest() throws Exception {
		/***Given***/
		

		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/login")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals("login/login", mav.getViewName());
		
	}
	/**
	 * Method : loginProcessTest
	 * 작성자 : PC-12
	 * 변경이력 :
	 * Method 설명 : 로그인 요청 처리
	 * @throws Exception 
	 */
	@Test
	public void loginProcessTest() throws Exception {
		MockHttpSession session = new MockHttpSession();
		mockMvc.perform(post("/login")
				.param("userId", "sally")
				.param("pass", "sally1234")
				.session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("main"));
//		.andExpect(request().sessionAttribute("S_USERVO", matcher));
		
		User user = (User)session.getAttribute("S_USERVO");
		logger.debug("user : {}", user);
		
		assertNotNull(user);
	}


}
