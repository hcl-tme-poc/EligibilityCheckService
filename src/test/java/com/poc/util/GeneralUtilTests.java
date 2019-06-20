package com.poc.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class GeneralUtilTests {
	@InjectMocks
	private GeneralUtil util = new GeneralUtil();
	
	@Test
	public void getDateDiff() {
		
		util.getDateDiff("2000-01-01");
		
	}
	
	@Test
	public void getDateDiffException() {
		
		util.getDateDiff("100");
		
	}
}
