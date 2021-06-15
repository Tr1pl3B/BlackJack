package de.stuttgart.hft.bif.fiveheads;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		
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
		writer.close();
		//
	}
}
