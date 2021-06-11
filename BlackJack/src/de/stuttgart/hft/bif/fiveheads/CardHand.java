package de.stuttgart.hft.bif.fiveheads;

import java.util.ArrayList;

public class CardHand {
	
	private ArrayList<Card> myCards;
	
	
	CardHand(Participant p){
		myCards = new ArrayList<Card>();
	}
	
	public void adCard(Card c) {
		myCards.add(c);
	}
	
	public void clearHand() {
		myCards.clear();
	}

	public ArrayList<Card> getMyCards() {
		return myCards;
	}

	@Override
	public String toString() {
		return "CardHand [myCards=" + myCards + "]";
	}
	
	
}
