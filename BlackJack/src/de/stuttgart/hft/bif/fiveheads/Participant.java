package de.stuttgart.hft.bif.fiveheads;

import java.util.ArrayList;
import java.util.Random;

public class Participant {

	private int cardvalue;
	private CardHand myHand;
	private BlackJackCardDeck playDeck = new BlackJackCardDeck();
	
	Participant(){
		myHand = new CardHand(this);
	}
	
	public void pickCard() {
		Random number = new Random();
		int upperbound = 312;
		int random_number = number.nextInt(upperbound);
		myHand.adCard(playDeck.getCard(random_number));
	}
	
	public void goOut() {
		
	}
	
	public int getCardvalue() {
		
	}
	
	public CardHand getMyHand() {
		return myHand;
	}
	
}