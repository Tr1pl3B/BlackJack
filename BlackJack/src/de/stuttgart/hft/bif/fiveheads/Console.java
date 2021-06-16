package de.stuttgart.hft.bif.fiveheads;

import java.util.Scanner;

public class Console {
	private int Stackeingabe;
	private boolean condition = false;
	
	public void programstart()  {
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("Whats your stack in this round?");
			String strStackeingabe = scn.nextLine();
			try{
				Stackeingabe = Integer.parseInt(strStackeingabe);
				break;
			}
			catch (NumberFormatException e) {
				System.out.println("Please insert a number!");
			
			}					
		}

		
	}
}
