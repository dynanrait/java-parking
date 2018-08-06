package com.parking.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.parking.model.Mobil;
import com.parking.model.ParkingSlot;

public class SlotParking {
	
	public static final String AVAILABLE = "available";
	public static final String EMPTY = "";
	
	public void createSlotParking(ParkingSlot parking){
		Map<String, Object> map = new HashMap<String, Object>();
		Utils utils = new Utils();
		Scanner scan = utils.getInputStream();
		int totalSlot = scan.nextInt();
		this.setAvailableSlot(parking, map, totalSlot);
		
	}
	
	public void setAvailableSlot(ParkingSlot parking, Map<String, Object> map, int totalSlot){
		parking.setTotalSlot(totalSlot);
		for(int i =1;i<=parking.getTotalSlot();i++){
			map.put(String.valueOf(i), AVAILABLE);
			parking.setSlotCar(map);
		}
		System.out.println("You created a parking lot with " + parking.getTotalSlot() + " slots");
	}
	
	public void getSlotParking(ParkingSlot slot){
		Mobil mobil = new Mobil();
		Utils utils = new Utils();

		this.showAvailableParking(slot);
		
		System.out.println("Please Input your data of car " );	
			
		System.out.print("insert your no registration car :");
		Scanner scan = utils.getInputStream();
		mobil.setNoRegistration(scan.next());
		System.out.print("insert your color car :");
		mobil.setWarna(scan.next());
		System.out.print("insert your parking slot : ");
		int slotSpace = scan.nextInt();
		this.setCarToSlot(slot, slotSpace, mobil);
		
	}
	
	public void setCarToSlot(ParkingSlot slot, int slotSpace, Mobil mobil){
		boolean available = this.checkSlotCar(slotSpace, slot);
		Map<String, Object> map = slot.getSlotCar();
		if (!available)
			System.out.println(mobil.getNoRegistration() +" "+ mobil.getWarna() + " at slot " + slotSpace);
		map.put(String.valueOf(slotSpace),  mobil);
		slot.setSlotCar(map);
	}
	
	public boolean checkSlotCar(int i, ParkingSlot slot){
		Map<String, Object> map = slot.getSlotCar();
		boolean slotParking = false;
		Object object = map.get(String.valueOf(i));
		if(object != null){
			if(!object.equals(AVAILABLE)){
				slotParking = true;
				System.out.println("This Slot is has been book by another car ");
			}
		} else {
				slotParking = true;
				System.out.println("This Slot is not available ");
		}
		
		return slotParking;
	}
	
	public void releaseParking(ParkingSlot slot){
		Map<String, Object> map = slot.getSlotCar();
		Utils utils = new Utils();
		System.out.print("Select Parking Number that want to release :");
		Scanner scan  = utils.getInputStream();
		String choice = scan.next();
		this.setAvailableParking(slot, map, choice);
	}
	
	public void setAvailableParking(ParkingSlot slot, Map<String, Object> map, String choice){
		Object object = map.get(String.valueOf(choice)); 
		if(object == null){
			System.out.println("Parking slot have not been made ");
		} else if(map.get(String.valueOf(choice)).equals(AVAILABLE)){
			System.out.println("Parking slot " + choice + " still available");
		} else {
			map.put(choice, AVAILABLE);
			System.out.println("Parking slot " + choice + " has been available");
		}
		
	}
	
	public void showAvailableParking(ParkingSlot slot){
		int totalSlot= slot.getTotalSlot();
		
		System.out.println("you have " + totalSlot + " slots parking");
		this.checkStatus(slot);
		
	}
	
	public void checkStatus(ParkingSlot  slot){
		Map<String, Object> map = slot.getSlotCar();
		int totalSlot= slot.getTotalSlot();
		boolean full = true;
		for(int i =1; i<= totalSlot;i++){
			if(map.get(String.valueOf(i)).equals(AVAILABLE)){
				full =false;
				System.out.println("Slot Number " + i + " " +  map.get(String.valueOf(i)));
			} else {
				Mobil mobil = (Mobil)map.get(String.valueOf(i));
				System.out.println("Parking slot with number " + i + " was filled by car with number registration " + mobil.getNoRegistration() + " color of car " + mobil.getWarna());
			}
		}
		
		if(full){
			System.out.println("Your Parking Slot has full");
		}
		
	}

	public void searchBy(ParkingSlot slot, String search){
		Utils util = new Utils();
		int totalSlot = slot.getTotalSlot(); 
		Scanner scan = util.getInputStream();
		String input = scan.next();
		Map<String, Object> map = slot.getSlotCar();
		boolean foundByNumberRegistration = false;
		boolean foundByColor = false;
		for(int i = 1;i<=totalSlot;i++){
			if(!map.get(String.valueOf(i)).equals(AVAILABLE)){
				Mobil mobil = (Mobil) map.get(String.valueOf(i));
				if(search.equals("searchByNumberRegistration")){
					if(mobil.getNoRegistration().equalsIgnoreCase(input)){
						foundByNumberRegistration = true;
						System.out.println("No Registration " + input + " at slot " + i);
					}
					
				} else if(search.equals("searchbyColor")){
					if(mobil.getWarna().equalsIgnoreCase(input)){
						foundByColor = true;
						System.out.println("Color with " + input + " with number registration "+ mobil.getNoRegistration() + " at slot " + i);
					}
				}
			}
		}
		
		if(search.equals("searchByNumberRegistration")){
			if(!foundByNumberRegistration){
				System.out.println("No Registration " + input + " Not Found");
			}
		} else if(search.equals("searchbyColor")){
			if(!foundByColor){
				System.out.println("color with " + input + " Not Found");
			}
		}
	}
	
}
