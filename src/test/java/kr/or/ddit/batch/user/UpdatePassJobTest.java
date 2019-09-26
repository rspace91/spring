package kr.or.ddit.batch.user;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/context-datasource.xml",
														  "classpath:kr/or/ddit/config/spring/context-batch.xml"})
public class UpdatePassJobTest {

	
	@Autowired
	private JobLauncherTestUtils jobLaucherTestUtils;
	
	@Test
	public void updatePassJobTest() throws Exception {
		/***Given***/
		

		/***When***/
		JobExecution jobExecution = jobLaucherTestUtils.launchJob();
		/***Then***/
		assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}

}
