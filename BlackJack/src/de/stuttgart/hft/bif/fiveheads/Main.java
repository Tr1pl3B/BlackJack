package de.stuttgart.hft.bif.fiveheads;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Player pl = new Player();
		Dealer dl = new Dealer();
		Console console = new Console();
		console.programstart();
		pl.setStack(console.getStackeingabe());
		pl.pickCard();
		dl.pickCard();
		pl.pickCard();
		System.out.println("Your current hand is" + pl.getMyHand());
		System.out.println("Dealers current card is" + dl.getMyHand());
		console.checkafterfirstcard(pl);
		dl.pickCard();
		System.out.println("your cardvalue is " + pl.getCardvalue());
		/*Scanner scan = new Scanner(System.in);
		ArrayList<Bankaccount> accounts = new ArrayList<Bankaccount>();
		Bankaccount a = new Bankaccount("tripleb");
		a.addCredit(150);
		Bankaccount b = new Bankaccount("levi");
		accounts.add(a);
		accounts.add(b);
		b.addCredit(150);
		
		
		
		FileWriter writer = new FileWriter("C:/Users/buchh/Desktop/userdata.csv");
		
		for(Bankaccount account : accounts) {
			String collect = account.getUsername() + "," + account.getCredit()+'\n';
			writer.write(collect);
		}
		writer.close();*/
		
		
	}
}
