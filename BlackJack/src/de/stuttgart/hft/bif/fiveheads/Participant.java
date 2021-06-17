package de.stuttgart.hft.bif.fiveheads;

import java.util.Random;

public abstract class Participant {

	private int cardvalue;
	protected CardHand myHand;
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
	
	public abstract void goOut();
	
	public int getCardvalue() {
		this.cardvalue = 0;
		for(Card card : this.myHand.getMyCards()) {
			switch (card.getValue()) {
			
			case "Jack":
				this.cardvalue += 10;
				break;
				
			case "Queen":
				this.cardvalue += 10;
				break;
				
			case "King":
				this.cardvalue += 10;
				break;
				
			case "Ace":
				this.cardvalue += 1;
				break;
				
			default:
				this.cardvalue += Integer.parseInt(card.getValue());
				break;
			}
		}
		return this.cardvalue;
			
	}
	
	public CardHand getMyHand() {
		return myHand;
	}
	
}