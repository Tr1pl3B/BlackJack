package de.stuttgart.hft.bif.fiveheads;

public class Card {
	
	private String value;
	private String symbol;
	
	Card(String value, String symbol) {
		this.value = value;
		this.symbol = symbol;
	}

	public String getValue() {
		return value;
	}

	public String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		return value + " of " + symbol;
	}
}
