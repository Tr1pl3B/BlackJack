package de.stuttgart.hft.bif.fiveheads;

import java.io.*;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Player pl = new Player();
		Dealer dl = new Dealer();
		Rules r = new Rules ();
		Console console = new Console();
		ArrayList<Bankaccount> accounts = new ArrayList<Bankaccount>();
		
		accounts = console.programmStart(accounts, pl);
		
		while (true) {
			console.gameStart(pl);
			pl.setStack(console.getStackEingabe());
			pl.pickCard();
			dl.pickCard();
			pl.pickCard();
			
			if(r.blackJack(pl) == false) {
				System.out.println("Your current hand is" + pl.getMyHand());
				System.out.println("Dealers current card is" + dl.getMyHand());
			}
			console.checkAfterFirstCard(pl, r);
			if(r.tripleSeven(pl)==false) {
				if(r.burned(pl)==false) 
				{
		 			console.dealersTurn(dl, r);
						
				}else {
					System.out.println("sorry you just lost, your cardvalue (" + pl.getCardvalue() + "),  is over 21");
					pl.setStack(0);
				}
			}
			if(r.blackJack(pl)==true && r.blackJack(dl)==true) {
				System.out.println("Sorry the Dealer also has Blackjack, your stack will be refunded to you");
				break;
			}
			
			if(r.blackJack(pl)==true && r.blackJack(dl)==false )
			{
				pl.adCredit(pl.getStack() + pl.getStack() + Math.toIntExact(Math.round(pl.getStack() * 1.5)));
			}
			
			if(console.endOfTheRound(pl, dl, r) == true)
					{
						pl.setCardvalue(0);
						pl.clearMyHand();
						dl.setCardvalue(0);
						dl.clearMyHand();
					}else {
						break;
					}
		}
		console.refreshCredit(accounts, pl);
		saveUserdata(accounts);
		System.exit(0);
		
	}
		
	public static void saveUserdata(ArrayList<Bankaccount> accounts) throws IOException{

		try (FileWriter writer = new FileWriter("C:/Users/buchh/Desktop/userdata.csv")) {
			for(Bankaccount account : accounts) {
			String collect = account.getUsername() + "," + account.getCredit()+'\n';
			writer.write(collect);
		}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}
		
	}	
	
	
	
}
