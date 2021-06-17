package de.stuttgart.hft.bif.fiveheads;

import java.util.Scanner;

public class Console {
	private int stackEingabe, inputAfterFirstCard, inputAfterEndOfTheRound;
	private boolean condition = true;
	
	public void programStart(Player pl)  {
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("Whats your stack in this round?");
			String strStackeingabe = scn.nextLine();
			try{
				stackEingabe = Integer.parseInt(strStackeingabe);
				pl.subCredit(stackEingabe);
				break;
			}
			catch (NumberFormatException e) {
				System.out.println("Please insert a number!");
			
				}					
			}
		}
	public void checkAfterFirstCard(Player pl, Rules r){
		
		Scanner scn = new Scanner(System.in);
		
		while (condition==true) {
			if (r.burned(pl)==true) {
				System.out.println("You are burned, your cardvalue is " + pl.getCardvalue() + " so it is over 21" + "\n");
				break;
			} 	
				while(true) {
					System.out.println("Your cardvalue is " + pl.getCardvalue() + "\n");
					System.out.println("What's your next move? " + "\n" +"press [1] to hit and get another card" + "\n" + "press [2] to stand and you will not get another card" + "\n" );
					String input = scn.nextLine();
					try{
						inputAfterFirstCard = Integer.parseInt(input);
						if (inputAfterFirstCard>2 || inputAfterFirstCard<=0) {
							System.out.println("Please insert only 1 or 2 and press enter" + "\n");
						}
						if (inputAfterFirstCard==1 || inputAfterFirstCard==2) {
							break;
						}
					
					} catch (NumberFormatException e) {
						System.out.println("Please insert only 1 or 2 and press enter" + "\n");
					}
				}
					if (inputAfterFirstCard==1) {
						pl.pickCard();
						System.out.println("Your current hand is" + pl.getMyHand() + "\n");
					} else if (inputAfterFirstCard==2) {
						condition=false;
						System.out.println("Your current hand is " + pl.getMyHand() + "with a value of " + pl.getCardvalue()+ "\n");
					}
		}	
	}
	
	public void dealersTurn(Dealer dl, Rules r) {
		while(true) {
			dl.pickCard();
			System.out.println("Dealer picked another card, his cardhand is" + dl.getMyHand());
			if(dl.getCardvalue()>=17) {
				if(dl.getCardvalue()>21) {
					System.out.println("Dealer just burned himself with a cardhand of" + dl.getMyHand() + "\n" + "His value "  + dl.getCardvalue() + " is over 21 " );
					break;
				}
				System.out.println("Dealers current cardhand is" + dl.getMyHand() + "and he decided to go out, with a value of " + dl.getCardvalue());
				break;
			}	
		}
	}
	
	public boolean endOfTheRound(Player pl, Dealer dl, Rules r) {
		Scanner scn = new Scanner(System.in);
		if (r.winner(pl, dl)==pl) {
			System.out.println("You won with a cardvalue of " + pl.getCardvalue() + " /n " + ". Your current credit is " + pl.getCredit());
		} else {
			System.out.println("You lost your Stack, your new credit balance ist " + pl.getCredit());	
		}
		System.out.println("You wanna play another Round?"+"\n" + "Enter [1] to play another round \n" + "Enter [2] to stop playing");
		while(true) {
			String input = scn.nextLine();
			try{
				inputAfterEndOfTheRound = Integer.parseInt(input);
				if (inputAfterEndOfTheRound>2 || inputAfterEndOfTheRound<=0) {
					System.out.println("Please insert only 1 or 2 and press enter" + "\n");
				}
				if (inputAfterEndOfTheRound==1 || inputAfterEndOfTheRound==2) {
					break;
				}
				
			}
			catch (NumberFormatException e) {
					
				System.out.println("Please insert only 1 or 2 and press enter" + "\n");
				
			}
		}
		if(inputAfterEndOfTheRound==1) {
				return true;			
		} else {
			return false;
		}
	}
	
	public int getStackEingabe() {
		return stackEingabe;
	}
}
