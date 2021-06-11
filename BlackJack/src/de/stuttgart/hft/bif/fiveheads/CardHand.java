package de.stuttgart.hft.bif.fiveheads;

import java.util.ArrayList;

public class CardHand {
	
	private ArrayList<Card> myCards;
	
	
	CardHand(Participant p){
		myCards = new ArrayList<Card>();
		p.pickCard();
		p.pickCard();
	}
	
	public void adCard(Card c) {
		myCards.add(c);
	}
	
	public void clearHand() {
		myCards.clear();
	}

	@Override
	public String toString() {
		return "CardHand [myCards=" + myCards + "]";
	}
	
	
}
