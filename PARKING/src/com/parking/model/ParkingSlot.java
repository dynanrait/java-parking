package com.parking.model;

import java.util.Map;

public class ParkingSlot {

	private String noSlot;
	private String status;
	private int totalSlot;
	private Map<String, Object> slotCar;
	
	public String getNoSlot() {
		return noSlot;
	}
	public void setNoSlot(String noSlot) {
		this.noSlot = noSlot;
	}
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getTotalSlot() {
		return totalSlot;
	}
	public void setTotalSlot(int totalSlot) {
		this.totalSlot = totalSlot;
	}
	public Map<String, Object> getSlotCar() {
		return slotCar;
	}
	public void setSlotCar(Map<String, Object> slotCar) {
		this.slotCar = slotCar;
	}
	
	
}
