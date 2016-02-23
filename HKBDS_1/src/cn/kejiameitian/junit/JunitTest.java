package cn.kejiameitian.junit;

import java.util.Date;

import org.junit.Test;

public class JunitTest {
	@Test
	public void urltest(){
	}
	
	@Test
	public void DateTest(){
		String date = new Date().toString();
		System.out.println("Ê±¼äÎª"+date);
	}
	
}
