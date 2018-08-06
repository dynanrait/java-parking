package com.parking.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.parking.controller.Utils;

public class UtilTesting {

	Utils util;
	@Before
	public void init(){
		util = new Utils();
	}
	
//	@Test
//	public void test() {
//		assertEquals("Please Input numeric", util.getInput("sdasdsadsad"));
//	}
//	
	@Test
	public void test1() {
		assertEquals(1, util.getInput("1"));
	}

}
