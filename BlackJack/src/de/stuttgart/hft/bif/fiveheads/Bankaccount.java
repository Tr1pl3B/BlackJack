package de.stuttgart.hft.bif.fiveheads;

public class Bankaccount {
	
	private String username;
	private int credit;

	public Bankaccount(String username) {
		this.username = username;
		credit = 10000;
	}
	
	public Bankaccount(String username, String credit) {
		this.username = username;
		this.credit = Integer.parseInt(credit);
	}
	
	public void addCredit(int win) {
		this.credit += win;
	} 
	
	public void subCredit(int insert) {
		this.credit -= insert;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public String getCredit() {
		return String.valueOf(credit);
	}
	
	public int getIntCredit() {
		return credit;
	}
	
	public String getUsername() {
		return this.username;
	}

	@Override
	public String toString() {
		return "Bankaccount [username=" + username + ", credit=" + credit + "]";
	}
}