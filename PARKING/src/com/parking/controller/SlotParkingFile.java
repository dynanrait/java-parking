package com.parking.controller;

import java.io.File;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.parking.model.Mobil;
import com.parking.model.ParkingSlot;

public class SlotParkingFile extends SlotParking {
	
	public static final String AVAILABLE = "available";
	public static final String EMPTY = "";
	public static final String PATH = "D:\\test\\java-parking\\file.txt";
	public static final String PATH_CRETAE_SPACE = "D:\\Parking-test\\java-parking\\file2.txt";
	public static final String PATH_LEAVE_SPACE = "D:\\Parking-test\\java-parking\\file3.txt";
	
	public void setSlotParking(ParkingSlot parking){
		System.out.println("Process Register your slot Parking for your car");
		SlotParking parkingSlot = new SlotParking();
		File file = new File(PATH);
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNext()){
				Mobil mobil = new Mobil();
				String word = scan.nextLine();
				String[] words = this.readContentFromFile(word);
				if(words[0].equals("H")){
					continue;
				}
				mobil.setNoRegistration(words[1]);
				mobil.setWarna(words[2]);
				int slot = Integer.parseInt(words[3]);
				parkingSlot.setCarToSlot(parking, slot, mobil);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createSlotParking(ParkingSlot slot){
		System.out.println("Process Create your slot Parking");
		File file = new File(PATH_CRETAE_SPACE);
		Map<String , Object> map = new HashMap<String, Object>();
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNext()){
				String word = scan.nextLine();
				String[] words = this.readContentFromFile(word);
				if(words[0].equals("H")){
					continue;
				}
				slot.setTotalSlot(Integer.parseInt(words[1]));			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.setAvailableSlot(slot, map, slot.getTotalSlot());
		
	}
	
	public String[] readContentFromFile(String data){
		String temp = data.replaceAll("\\W", " ");
		String[] words = temp.split("\\s+");
		
		return words;
	}
	
	public void leaveByFile(ParkingSlot slot){
		File file = new File(PATH_LEAVE_SPACE);
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("Process Release your slot Parking");
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNext()){
				String word = scan.nextLine();
				String[] words = this.readContentFromFile(word);
				if(words[0].equals("H")){
					continue;
				}
				String choice = words[1];
				map = slot.getSlotCar();
				super.setAvailableParking(slot, map, choice);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
