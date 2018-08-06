package com.parking.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.parking.controller.SlotParkingFile;

public class SlotParkingFileTest {

	SlotParkingFile slotParkingFile;
	
	@Before
	public void init(){
		slotParkingFile = new SlotParkingFile();
	}
	
	@Test
	public void test() {
		String words = "D 01AA              Red        1";
		String[] myStringArray = {"D","01AA","Red","1"};
		assertEquals(myStringArray, slotParkingFile.readContentFromFile(words));
	}
	
	@Test
	public void test1() {
		String words = "D,01AA,Red,1";
		String[] myStringArray = {"D","01AA","Red", "1"};
		assertEquals(myStringArray, slotParkingFile.readContentFromFile(words));
	}

}
