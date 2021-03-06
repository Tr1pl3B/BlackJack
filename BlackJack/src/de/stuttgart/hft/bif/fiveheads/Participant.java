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
	
	public int getCardvalue(Participant p, Rules r) {
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
				this.cardvalue += 11;
				break;
				
			default:
				this.cardvalue += Integer.parseInt(card.getValue());
				break;
		
			}   
		}
			for(Card card:p.getMyHand().getMyCards()) {
				if(this.cardvalue>21 && card.getValue().equals("Ace")) {
					this.cardvalue -= 10;
				}
			}
		return this.cardvalue;
			
	}
	
	public void setCardvalue(int value) {
		this.cardvalue = value;
	}
	
	public CardHand getMyHand() {
		return myHand;
	}
	public void clearMyHand() {
		myHand.clearHand();
	}
}