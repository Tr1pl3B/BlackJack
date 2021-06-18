package de.stuttgart.hft.bif.fiveheads;

public class Rules {

	double multiplier = 1;
	
	public Participant winner(Player p, Dealer d) {
		
		if(burned(d) == true && burned(p) == false) {
			return p;
		} else if(tripleSeven(p) == true) {
			multiplier = 1.5;
			return p; 
		} else if(burned(p) == true && burned(d) == false) {
			return d;
		} else if(burned(d) == false && burned(p) == false && blackJack(p) == true && blackJack(d) == false) {
			multiplier = 1.5;
			return p;
		} else if(burned(d) == false && burned(p) == false && blackJack(p) == false && blackJack(d) == true) {
			return d;
		} else if(burned(d) == false && burned(p) == false && p.getCardvalue() < d.getCardvalue()) {
			return d;
		} else if(burned(d) == false && burned(p) == false && p.getCardvalue() > d.getCardvalue()) {
			return p;
		} else {
			return null;
		}
		
	}
	
	public boolean burned(Participant p) {
		if(p.getCardvalue() > 21) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean blackJack(Participant p) {
		
		if(p.getMyHand().getLength() == 2) {
			String[] value = new String[2];
			int i = 0;
			for(Card card :p.getMyHand().getMyCards() ) {
				value[i] = card.getValue();
				i++;
			}
			
			switch (value[0]){
			
			case "10":
				if(value[1] == "Ace") {
					return true;
				} else {
					return false;
				}
				
			case "Jack":
				if(value[1] == "Ace") {
					return true;
				} else {
					return false;
				}
				
			case "Queen":
				if(value[1] == "Ace") {
					return true;
				} else {
					return false;
				}
				
			case "King":
				if(value[1] == "Ace") {
					return true;
				} else {
					return false;
				}
				
			case "Ace":
				if(value[1] == "10") {
					return true;
				} else if(value[1] == "Jack") {
					return true;
				} else if(value[1] == "Queen") {
					return true;
				} else if(value[1] == "King") {
					return true;
				} else {
					return false;
				}
			} 
			
			
		} else {
			return false;
		}
		
		return false;
	}
		
	
	public boolean tripleSeven(Player p) {
		
		if(p.getMyHand().getLength() == 3 ) {
			String[] value = new String[3];
			int i = 0;
			boolean sevens = true;
			for(Card card :p.getMyHand().getMyCards() ) {
				value[i] = card.getValue();
				if(value[i] != "7") {
					sevens = false;
				}
				i++;
			}
			if(sevens == true) {
				p.adCredit(p.getStack() + Math.toIntExact(Math.round(p.getStack() * 1.5)));
			}
			return sevens;
		}
		
		return false;
		
	}
	
	public boolean tripleSeven(Dealer p) {
		
		if(p.getMyHand().getLength() == 3 ) {
			String[] value = new String[3];
			int i = 0;
			boolean sevens = true;
			for(Card card :p.getMyHand().getMyCards() ) {
				value[i] = card.getValue();
				if(value[i] != "7") {
					sevens = false;
				}
				i++;
			}
			return sevens;
		}
		
		return false;
		
	}
}
