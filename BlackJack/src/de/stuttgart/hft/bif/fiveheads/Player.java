
package de.stuttgart.hft.bif.fiveheads;

public class Player extends Participant {
	
	private int credit, stack, stack2, insurance;

	CardHand ch1 = new CardHand(this);
	CardHand ch2 = new CardHand(this);
	public void doubleIt() {
		stack = stack *2;
		this.pickCard();
	}

	
	
	public void split() {
	//test
		Card c1 = myHand.getCard(0);
		Card c2 = myHand.getCard(1);
		
		if (c1.getValue()==c2.getValue()) {
			ch1.clearHand();
			ch2.clearHand();
			ch1.adCard(c1);
			ch2.adCard(c2);
			stack2 = stack;
			setCredit(credit-stack);
			}else {
				System.out.println("No split possible, only with two similar cards");
			}
				
	}
	
	public void adCredit(int win) {
		credit += win;
	}
	
	public void subCredit(int stack) {
		this.credit -= stack;
	}
	
	private void setCredit(int credit) {
		this.credit += credit;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public void setStack(int stack) { //habs public gemacht dami ich es setzten kann in der Main
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
