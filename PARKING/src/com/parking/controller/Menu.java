package com.parking.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.parking.model.ParkingSlot;

public class Menu {
	
	ParkingSlot parking;
	public static final String EMPTY = "";
	public static final String SEARCH_BY_REGISTRATION = "searchByNumberRegistration"; 
	public static final String SEARCH_BY_COLOR = "searchbyColor"; 

	public ParkingSlot getParking() {
		return parking;
	}

	public void setParking(ParkingSlot parking) {
		this.parking = parking;
	}

	public void getMenu(){
		System.out.println("=========Selamat Datang di Lot-Parking===========");
		System.out.println("1. Input Manual");
		System.out.println("2. Input By File");
		System.out.println("=========Choose one Of menu===========");
	}
	
	public void getSubmenu(){
		System.out.println("Please choose one to do");
		System.out.println("1. Register car number to parking slot");
		System.out.println("2. Leave Parking");
		System.out.println("3. Status");
		System.out.println("4. Create Parking Slot");
		System.out.println("5. Search");
		Utils utils = new Utils();
		Scanner scanner =  utils.getInputStream();
		String input = scanner.next();
		int pilihan = utils.getInput(input); 
		this.goToSubMenu(pilihan);
	}
	
	public void getSubmenuUpload(){
		System.out.println("Please choose one to do");
		System.out.println("1. Register car number to parking slot by File");
		System.out.println("2. Leave Parking by File");
		System.out.println("3. Status");
		System.out.println("4. Create Parking Slot by File");
		System.out.println("5. Search");
		Utils utils = new Utils();
		Scanner scanner =  utils.getInputStream();
		String input = scanner.next();
		int pilihan = utils.getInput(input); 
		this.goToSubMenuUpload(pilihan);
	}
	
	
	public void getSearchBy(){
		System.out.println("Please choose one to do");
		System.out.println("1. Search By Number Registration ");
		System.out.println("2. Search By color ");
		SlotParking slot = new SlotParking();
		Utils util = new Utils();
		Scanner scan = util.getInputStream();
		int menu = scan.nextInt();
		if(menu == 1){
			System.out.println("Please Input registration number of car");
			slot.searchBy(parking, SEARCH_BY_REGISTRATION);
			this.getSubmenu();
		} else if(menu == 2){
			System.out.println("Please Input color of car");
			slot.searchBy(parking, SEARCH_BY_COLOR);
			this.getSubmenu();
		} else {
			System.out.println("Please Choose 1 or 2");
			this.getSearchBy();
		}
	}
	
	public void callMenu(){
		this.getMenu();
		this.chooseSubMenu();
	}
	
	public void chooseSubMenu(){
		Utils utils = new Utils();
		Scanner scanner =  utils.getInputStream();
		String input = scanner.next();
		int choice = utils.getInput(input);
		if(choice == 1){
			this.getSubmenu();
		} else if(choice == 2) {
			this.getSubmenuUpload();
		} else {
			System.out.println("Please choose 1 or 2");
			this.chooseSubMenu();
		}
	}
	
	public void goToSubMenu(int input){
		
		SlotParking slot = new SlotParking();
		if(input != 4){
			if(this.validateParking(parking) == null){
				System.out.println("You Have 0 Parking lot, Please create : ");
				this.getSubmenu();
			} else {
				if(input == 1){
					slot.getSlotParking(parking);
					this.getSubmenu();
				} else if(input == 2){
					slot.releaseParking(parking);
					this.getSubmenu();
				} else if(input ==3 ){
					slot.checkStatus(parking);
				} else if(input == 5){
					this.getSearchBy();
				}
			}
		} else if(input == 4){
			parking = new ParkingSlot();
			System.out.println("Please Create your slot Parking");
			slot.createSlotParking(parking);
			this.getSubmenu();
		}
				
	}
	
	public void goToSubMenuUpload(int input){
		SlotParkingFile slotParkingFile = new SlotParkingFile();
		if(input != 4){
			if(validateParking(parking) == null){
				System.out.println("You Have 0 Parking lot, Please create : ");
				this.getSubmenuUpload();
			} else {
				if(input == 1){
					slotParkingFile.setSlotParking(parking);
					this.getSubmenuUpload();
				} else if(input == 2){
					slotParkingFile.leaveByFile(parking);
					this.getSubmenuUpload();
				} else if(input ==3 ){
					slotParkingFile.checkStatus(parking);
					this.getSubmenuUpload();
				} else if(input == 5){
					this.getSearchBy();
				}
			}
		} else if(input == 4){
			parking = new ParkingSlot();
			slotParkingFile.createSlotParking(parking);
			this.getSubmenuUpload();
		}
	}
	
	public ParkingSlot validateParking(ParkingSlot parking){
		if(parking == null){
			return null;
		} else {
			return parking;
		}
	}
	
}