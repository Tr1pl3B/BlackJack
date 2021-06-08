package de.stuttgart.hft.bif.fiveheads;

public class Card {
	
	private String value;
	private String symbol;
	
	Card(String value, String symbol) {
		this.value = value;
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", symbol=" + symbol + "]";
	}
	
	
	
}