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
		String words = "aku adalah bradpitt";
		String[] myStringArray = {"aku","adalah","bradpitt"};
		assertEquals(myStringArray, slotParkingFile.readContentFromFile(words));
	}
	
	@Test
	public void test1() {
		String words = "aku,adalah,bradpitt";
		String[] myStringArray = {"aku","adalah","bradpitt"};
		assertEquals(myStringArray, slotParkingFile.readContentFromFile(words));
	}

}
