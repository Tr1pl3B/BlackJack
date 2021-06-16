package de.stuttgart.hft.bif.fiveheads;

public class Player extends Participant {
	private int credit;
	private int stack;
	private int insurance;
	
	Player pl1 = new Player();
	Player pl2 = new Player();
	CardHand p1 = new CardHand(pl1);
	CardHand p2 = new CardHand(pl2);
	public void doubleIt() {
		stack = stack *2;
		this.pickCard();
		
	}
	
	public void split() {
		
		Card c1 = myHand.getCard(0);
		Card c2 = myHand.getCard(1);
		
		if (c1.getValue()==c2.getValue()) {
			p1.clearHand();
			p2.clearHand();
			p1.adCard(c1);
			p2.adCard(c2);
			pl1.setStack(stack); // weiss nicht ob nötig, sieht unnötig aus
			pl1.setCredit(credit-stack);
			pl2.setStack(stack); //unsicher welchen Stack er nimmt
			pl2.setCredit(credit-stack);
			}else {
				System.out.println("No split possible, only with two similar cards");
			}
		
		
	}
	
	public void adCredit(int win) {
		credit += win;
	}
	
	
	private void setCredit(int credit) {
		this.credit += credit;
	}
	
	public int getCredit() {
		return credit;
	}
	
	private void setStack(int stack) {
		this.stack += stack;
	}
	
	public int getStack() {
		return stack;
	}
	
	private void setInsurance(int insurance) {
		this.insurance += insurance;
	}
	
	public int getInsurance() {
		return insurance;
	}

	@Override
	public void goOut() {
		// TODO Auto-generated method stub
		
	}
	
	
}
