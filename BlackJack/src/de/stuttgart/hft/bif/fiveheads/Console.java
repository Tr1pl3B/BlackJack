package de.stuttgart.hft.bif.fiveheads;

import java.util.Scanner;

public class Console {
	private int Stackeingabe;
	private int inputafterfirstcard;
	private boolean condition = true;
	
	
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
	public void checkafterfirstcard(Player pl){
		
		Scanner scn = new Scanner(System.in);
		
		while (condition==true) { 
		System.out.println("What's your next move" + "\n" + "press [1] to hit and get another card" + "\n" + "press [2] to stand and you will not get another card" + "\n" );	
		
				while(true) {
					String input = scn.nextLine();
				try{
					inputafterfirstcard = Integer.parseInt(input);
					if (inputafterfirstcard>2 || inputafterfirstcard<=0) {
						System.out.println("Please insert only 1 or 2 and press enter" + "\n");
					}
					if (inputafterfirstcard==1 || inputafterfirstcard==2) {
						break;
					}
					
					}
					catch (NumberFormatException e) {
						
						System.out.println("Please insert only 1 or 2 and press enter" + "\n");
					
						}
							}
								if (inputafterfirstcard==1) {
								 pl.pickCard();
								 System.out.println("Would you like to get another card ?" + "\n");
								 System.out.println("Your current hand is" + pl.getMyHand() + "\n");
								}else if (inputafterfirstcard==2) {
									condition=false;
									System.out.println("Your current hand is" + pl.getMyHand() + "\n");
								}
		}
		
		
		}
	
	
	public int getStackeingabe() {
		return Stackeingabe;
	}
}
