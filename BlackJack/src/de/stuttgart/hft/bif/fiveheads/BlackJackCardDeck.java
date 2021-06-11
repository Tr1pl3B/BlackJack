package de.stuttgart.hft.bif.fiveheads;

import java.util.Arrays;

public class BlackJackCardDeck {

	private Card[] deck;
	private String[] value = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	private String[] symbol = {"heart","clubs", "diamonds", "spades"};
	
	BlackJackCardDeck() {
		deck = new Card[312];
		int k = 0;
		for(int l = 0; l < 6; l++) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 13; j++) {
					deck[k] = new Card(value[j], symbol[i]);
					k++;
				}
			}
		}
	}
	
	public Card getCard(int poss) {
		return deck[poss];
	}

	@Override
	public String toString() {
		return "CardDeck deck= [" + Arrays.toString(deck);
	}
	
	
}
