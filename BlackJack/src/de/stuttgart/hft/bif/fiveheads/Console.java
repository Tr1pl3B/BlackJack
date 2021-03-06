package de.stuttgart.hft.bif.fiveheads;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {
	private int inputStack, inputAfterFirstCard, inputDoubleRequest, inputAfterEndOfTheRound, inputCreateUser, inputCheckInsurance, inputInsurance;
	private boolean condition = true;
	private String inputUser;
	private Bankaccount user;
	private String path = "C:/Users/buchh/Desktop/userdata.csv"; //zum Beispiel so: C:/Users/buchh/Desktop/userdata.csv
	
	public ArrayList<Bankaccount> programmStart(ArrayList<Bankaccount> accounts, Player pl) {
		
		System.out.println("Welcome to BlackJack \n"+ "");
		
		try (BufferedReader fileReader = new BufferedReader(new FileReader(path))){
			String lineInput;
			String[] column = null;
			Bankaccount account = null;
			while((lineInput = fileReader.readLine()) != null) {
				if((lineInput.isEmpty()) == false) {
					column = lineInput.split(",");
					String username = column[0];
					String credit = column[1];
					account = new Bankaccount(username, credit);
					accounts.add(account);
					if(column.length != 2) {
						System.err.println("There is a faulty line in userdata.csv: It's in this line " + lineInput);
						continue;
					}
				} 
			} 
		} catch (FileNotFoundException e) {
			System.out.println("There are no existing useres \n");
		} catch (IOException i) {
			i.printStackTrace();
		}
		if(accounts.isEmpty() == true) {
			System.out.println("Please creat your first user.");
			Scanner scn = new Scanner(System.in);
			inputUser = scn.nextLine();
			accounts.add(new Bankaccount(inputUser));
			for(Bankaccount account : accounts) {
				if(account.getUsername() == inputUser) {
					user = account;
					pl.setCredit(user.getIntCredit());
				}
			}
			System.out.println("Welcome " + user.getUsername() + " you will start with a Credit of " + user.getCredit() + "\n");
		} else {
			System.out.println("Press [1] to login with an existing user \n"
					+ "Press [2] to creat a new user");
			Scanner scn = new Scanner(System.in);
			while(true) {
	            String input = scn.nextLine();
	            try{
	            	inputCreateUser = Integer.parseInt(input);
	                if (inputCreateUser>2 || inputCreateUser<=0) {
	                    System.out.println("Please insert only 1 or 2 and press enter" + "\n");
	                }
	                if (inputCreateUser==1 || inputCreateUser==2) {
	                    break;
	                }

	            }
	            catch (NumberFormatException e) {

	                System.out.println("Please insert only 1 or 2 and press enter" + "\n");

	            }
	        }
			boolean check = false;
			if(inputCreateUser == 2) {
				System.out.println("Please insert your username.");
				inputUser = scn.nextLine();
				accounts.add(new Bankaccount(inputUser));
				for(Bankaccount account : accounts) {
					if(account.getUsername() == inputUser) {
						user = account;
						pl.setCredit(user.getIntCredit());
						check = true;
					}
				}
				System.out.println("Welcome " + user.getUsername() + " you will start with a Credit of " + user.getCredit() + "\n");
			}
			
			while(check == false) {
				System.out.println("Please enter your username.");
				inputUser = scn.nextLine();
				for(Bankaccount account : accounts) {
					if(account.getUsername().equals(inputUser)) {
						user = account;
						pl.setCredit(user.getIntCredit());
						check = true;
					}
				}
				if(check == false) {
					System.out.println("Please enter an existing username: \n"
							+ "\n"
							+ "Existing usernames:");
					for(Bankaccount account : accounts) {
						System.out.println(account.getUsername());
					}
					System.out.println("");
				}
			}
		}
		System.out.println("Welcome " + user.getUsername() + " your current credit balance is " + user.getCredit() + "\n");
		return accounts;
		
	}
	
	public void gameStart(Player pl)  {
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("Whats your stack in this round?");
			String strStackeingabe = scn.nextLine();
			try{
				inputStack = Integer.parseInt(strStackeingabe);
				if(inputStack >= 5) {
				pl.subCredit(inputStack);
				break;
				} else {
					System.out.println("Your stack must be grather 4");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Please insert a number!");
			 
				}					
			} 
		 
		}
	
	public void checkAfterFirstCard(Player pl, Rules r){
		
		Scanner scn = new Scanner(System.in);
		
		while (condition==true) {
			if (r.burned(pl)==true) {
				System.out.println("You are burned, your cardvalue is " + pl.getCardvalue(pl,r) + " so it is over 21" + "\n");
				break;
			} 	
				while(true) {
					if(r.blackJack(pl)==true) {
						System.out.println("Congrates you got a black jack" + "\n" + "Your cardhand is " + pl.getMyHand());
						inputAfterFirstCard = 3;
						break;
					}else if(r.tripleSeven(pl)==true) {
						System.out.println("Congrates you got a Triple Seven, with a carddeck of" + pl.getMyHand());
						pl.adCredit(pl.getStack() + pl.getStack() + Math.toIntExact(Math.round(pl.getStack() * 1.5)));
						inputAfterFirstCard = 0;
						break;
					}
					System.out.println("Your cardvalue is " + pl.getCardvalue(pl,r) + "\n");
					System.out.println("What's your next move? " + "\n" +"press [1] to hit and get another card" + "\n" + "press [2] to stand and you will not get another card" + "\n" );
					String input = scn.nextLine();
					try{
						inputAfterFirstCard = Integer.parseInt(input);
						if (inputAfterFirstCard>2 || inputAfterFirstCard<=0) {
							System.out.println("Please insert only 1 or 2 and press enter" + "\n");
						}
						if (inputAfterFirstCard==1 || inputAfterFirstCard==2) {
							break;
						}
					
						
					} catch (NumberFormatException e) {
						System.out.println("Please insert only 1 or 2 and press enter" + "\n");
					}
				}
					if (inputAfterFirstCard==1) {
						pl.pickCard();
						System.out.println("Your current hand is" + pl.getMyHand() + "\n");
					} else if (inputAfterFirstCard==2) {
						condition=false;
						System.out.println("Your current hand is " + pl.getMyHand() + "with a value of " + pl.getCardvalue(pl,r)+ "\n");
					} else if (inputAfterFirstCard==3) {
						System.out.println("Lets see what the dealer gets");
						break;
					}else if(inputAfterFirstCard==0) {
						break;
					}
		} 
		condition = true ;
	}
	 
	public void dealersTurn(Dealer dl, Rules r) {
		while(true) {
			dl.pickCard();
			System.out.println("Dealer picked another card, his cardhand is" + dl.getMyHand());
			if(dl.getCardvalue(dl,r)>=17) {
				if(dl.getCardvalue(dl,r)>21) {
					System.out.println("Dealer just burned himself with a cardhand of" + dl.getMyHand() + "\n" + "His value "  + dl.getCardvalue(dl,r) + " is over 21 " );
					break;
				}
				System.out.println("Dealers current cardhand is" + dl.getMyHand() + "and he decided to go out, with a value of " + dl.getCardvalue(dl,r));
				break;
			}	 
		}
	} 
	
	public void doubleRequest(Player pl, Rules r) {
		Scanner scn = new Scanner(System.in);
        System.out.println("You cardvalue is "+ pl.getCardvalue(pl,r));
        System.out.println("You wanna double?" + "\n" + "Enter [1] to double"+ "\n" + "Enter [2] not to double" );

        while(true) {
            String input = scn.nextLine();
            try{
                inputDoubleRequest = Integer.parseInt(input);
                if (inputDoubleRequest>2 || inputDoubleRequest<=0) {
                    System.out.println("Please insert only 1 or 2 and press enter" + "\n");
                }
                if (inputDoubleRequest==1 || inputDoubleRequest==2) {
                    break;
                }

            }
            catch (NumberFormatException e) {

                System.out.println("Please insert only 1 or 2 and press enter" + "\n");

            }
        }
        if(inputDoubleRequest==1) {
            pl.doubleIt();
            System.out.println("You doubled your stack."+" \n"+"Your stack right now is " + pl.getStack());
            System.out.println("After doubled it, your carddeck is" + pl.getMyHand());
        } 
    }
	
	public void refreshCredit(ArrayList<Bankaccount> accounts, Player pl) {
		for(Bankaccount account : accounts) {
			if(account.getUsername().equals(inputUser)) {
				account.setCredit(pl.getCredit());
			}
		}
	}
	
	public boolean endOfTheRound(Player pl, Dealer dl, Rules r) {
		
		Scanner scn = new Scanner(System.in);
		if (r.winner(pl, dl)==pl) {
			pl.adCredit(getInputStack()*2);
			System.out.println("You won with a cardvalue of " + pl.getCardvalue(pl,r) + " \n " + " Your current credit is " + pl.getCredit());
		} else if(pl.getCardvalue(pl,r)==dl.getCardvalue(pl,r)) {
			pl.adCredit(getInputStack());
			System.out.println("Dealer also has the cardvalue of " + dl.getCardvalue(pl,r) + "\n" + "Your Credits will be refunded" + "\n" + "Your current Credits : " + pl.getCredit());
		}else {			
			System.out.println("You lost your Stack, your new credit balance ist " + pl.getCredit());	
		}
		System.out.println("You wanna play another Round?" + "\n" + "Enter [1] to play another round \n" + "Enter [2] to stop playing");
		while(true) {
			String input = scn.nextLine();
			try{
				inputAfterEndOfTheRound = Integer.parseInt(input);
				if (inputAfterEndOfTheRound>2 || inputAfterEndOfTheRound<=0) {
					System.out.println("Please insert only 1 or 2 and press enter" + "\n");
				}
				if (inputAfterEndOfTheRound==1 || inputAfterEndOfTheRound==2) {
					break;
				}
				
			}
			catch (NumberFormatException e) {
					
				System.out.println("Please insert only 1 or 2 and press enter" + "\n");
				
			}  
		}
		if(inputAfterEndOfTheRound==1) {
				return true;			
		} else {
			return false;
		}
	}
	
	public boolean checkInsurance(Player pl, Dealer dl) {
		
		Scanner scn = new Scanner(System.in);
				System.out.println("The Dealer has an Ass as first card.\n" + "You want to set an insurance? \n" + "Press [1] to set an insurance \n" + "Press [2] to keep playing without an insurance");
					while(true) {
						String input = scn.nextLine();
						try{
							inputCheckInsurance = Integer.parseInt(input);
							if (inputCheckInsurance>2 || inputCheckInsurance<=0) {
								System.out.println("Please insert only 1 or 2 and press enter" + "\n");
							}
							if (inputCheckInsurance==1 || inputCheckInsurance==2) {
								break;
							}
							
						}
						catch (NumberFormatException e) {
								
							System.out.println("Please insert only 1 or 2 and press enter" + "\n");				
						}  
					}
					if(inputCheckInsurance==1) {
						System.out.println("How much should be the insurance ? ");
						while(true) {
							String input = scn.nextLine();
							try{
								inputInsurance = Integer.parseInt(input);
								if(inputInsurance<=0) {
									throw new NumberFormatException(); 
								}else {
								break;
								}
							}
							catch (NumberFormatException e) {
									
								System.out.println("Please insert valid a Number");
								
													}
							}
						pl.subCredit(inputInsurance);
						pl.setInsurance(inputInsurance);
						return true;
					}else {
						return false;
					}
					 	
	}
	
	public String getPath() {
		return path;
	}
	
	public int getInputStack() {
		return inputStack;
	}
}