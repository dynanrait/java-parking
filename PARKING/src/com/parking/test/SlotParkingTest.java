package com.parking.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.parking.controller.SlotParking;
import com.parking.model.Mobil;
import com.parking.model.ParkingSlot;

public class SlotParkingTest {
	
	SlotParking slotParking;
	
	@Before
	public void init(){
		slotParking = new SlotParking();
	}
	
	@Test
	public void test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", "available");
		ParkingSlot slot = new ParkingSlot();
		slot.setSlotCar(map);
		assertEquals(false, slotParking.checkSlotCar(1, slot));
	}

	@Test
	public void test1() {
		Map<String, Object> map = new HashMap<String, Object>();
		Mobil mobil = new Mobil();
		mobil.setNoRegistration("2");
		mobil.setWarna("Red");
		ParkingSlot slot = new ParkingSlot();
		map.put("1", mobil);
		slot.setSlotCar(map);
		assertEquals(true, slotParking.checkSlotCar(1, slot));
	}
}
