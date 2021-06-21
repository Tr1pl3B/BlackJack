
package de.stuttgart.hft.bif.fiveheads;

public class Player extends Participant {
	
	private int credit, stack, insurance;


	
	public void doubleIt() {
		this.subCredit(stack);
		stack = stack *2;
		this.pickCard();
	}

	public void adCredit(int win) {
		credit += win;
	}
	
	public void subCredit(int stack) {
		this.credit -= stack;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public void setStack(int stack) { //habs public gemacht dami ich es setzten kann in der Main
		this.stack = stack;
	}
	
	public int getStack() {
		return stack;
	}
	
	public void setInsurance(int insurance) {
		this.insurance += insurance;
	}
	
	public int getInsurance() {
		return insurance;
	}

	@Override
	public void goOut() {
	}
}