package de.stuttgart.hft.bif.fiveheads;

public class Player extends Participant {
	private int credit;
	private int stack;
	private int insurance;
	
	public void doubleIt() {
		stack = stack *2;
		this.pickCard();
		
	}
	
	public void boolean split() {
	
		
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
