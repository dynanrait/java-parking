package com.parking.controller;

import java.util.Scanner;

public class Utils {
	
	public Scanner getInputStream(){
		Scanner scanner = new Scanner(System.in);
		
		if(scanner.hasNext()){
			return scanner;
		}else {
			scanner.close();
			return scanner;
		}
	}
	
	public int getInput(String input){
		String in = "012345678910";
		System.out.println("Input your choice :");
		int choice = 0;
		if(in.contains(input)){
			choice = Integer.parseInt(input);
			return choice;
		} else {
			System.out.println("Please Input numeric");
			Scanner scan = this.getInputStream();
			input = scan.next();
			this.getInput(input);
		}
		
		return choice;
	}
	
}
