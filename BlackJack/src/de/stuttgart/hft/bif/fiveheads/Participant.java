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
		this.cardvalue = 0;
		for(Card card : this.myHand.getMyCards()) {
			switch (card.getValue()) {
			
			case "Jack":
				this.cardvalue += 10;
				
			case "Queen":
				this.cardvalue += 10;
				
			case "King":
				this.cardvalue += 10;
				
			case "Ace":
				this.cardvalue += 2;
				
			default:
				this.cardvalue += Integer.parseInt(card.getValue());
			}
		}
		return this.cardvalue;
			
	}
	
	public CardHand getMyHand() {
		return myHand;
	}
	
}