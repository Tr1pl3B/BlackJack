package de.stuttgart.hft.bif.fiveheads;

public class CardHand {
	
	private Card[] myCards;
	
	CardHand(Participant p){
		myCards = new Card[21];
		p.pickCard();
		p.pickCard();
	}
}
