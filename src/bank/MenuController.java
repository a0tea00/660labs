package bank;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class MenuController {
	static final int WELCOME_MENU = 0;
	static final int BANKING_MENU = 1;
	static final int DEPOSIT_MENU = 11;
	static final int WITHDRAW_MENU = 12;
	static final int TRANSFER_MENU = 13;
	static final int ACCOUNT_MENU = 2;
	static final int CREATEACCOUNT_MENU = 21;
	
	private AccountManager am;
	private TransManager tm;
	
	private int currentId;
	private boolean alive;
	private Scanner sc;
	
	private String currentAccount = null;
	
	
	public MenuController(AccountManager am,TransManager tm){
		this.sc = new Scanner(System.in);
		this.alive = true;
		this.currentId = WELCOME_MENU;
		this.getMenu(WELCOME_MENU);
		
	}
	
	@Autowired
	public void setAm(AccountManager am) {
		this.am = am;
	}
	@Autowired
	public void setTm(TransManager tm) {
		this.tm = tm;
	}

	public void getMenu(int menuIndex){
		if (this.isAlive()){
							
			switch (menuIndex){
			case WELCOME_MENU:
				getMenu(welcome());
				break;
			
			
			case BANKING_MENU:
				getMenu(banking());
				break;
			
			case DEPOSIT_MENU:
				getMenu(deposit());
				break;
			case WITHDRAW_MENU:
				getMenu(withdraw());
				break;
			case TRANSFER_MENU:
				getMenu(transfer());
				break;
				
			case ACCOUNT_MENU:
				getMenu(account());
				break;
			
			case CREATEACCOUNT_MENU:
				getMenu(createAccount());
				break;
			default:
				getMenu(this.currentId);
				break;
				
			}
			
			this.currentId = menuIndex;
		}
	}
	
	public int welcome(){
		this.currentId = WELCOME_MENU;
		this.currentAccount = null;
		System.out.println("Welcome to the Bank");
		System.out.println("\t"+ BANKING_MENU +". Banking");
		System.out.println("\t"+ ACCOUNT_MENU +". Account");
		
		return this.sc.nextInt();
	}
	
	public int banking( ){
		this.currentId = BANKING_MENU;
		System.out.println("enter pin:");
		this.currentAccount = sc.next();
		
		if (am.isAccount(this.currentAccount)){
			System.out.println(am.getAccount(this.currentAccount));
			
			System.out.println("\t"+ DEPOSIT_MENU +". Deposit");
			System.out.println("\t"+ WITHDRAW_MENU +". Withdrawal");
			System.out.println("\t"+ TRANSFER_MENU +". Transfer");
			System.out.println("\t"+ WELCOME_MENU +". Back");
		
			System.out.print("Please choose from menu:");
			
			return this.sc.nextInt();
		}
		this.currentAccount = null;
		System.out.print("Invalid pin!");
		
		return BANKING_MENU;
		
	}
	
	public int deposit(){
		this.currentId = DEPOSIT_MENU;
		
		System.out.println("Amount to deposit: $");
		double amount = sc.nextDouble();
		try{
		tm.deposit(am.getAccount(this.currentAccount), amount);
		}catch(TransactionException e){
			
			handleTranException(e);
		}
		return BANKING_MENU;
		
	}
	public int withdraw(){
		this.currentId = WITHDRAW_MENU;
		
		System.out.println("Amount to withdraw: $");
		double amount = sc.nextDouble();
		try{
		tm.withdrawal(am.getAccount(this.currentAccount), amount);
		}catch(TransactionException e){
			
			handleTranException(e);
		}
		
		return BANKING_MENU;
		
	}
	public int transfer(){
		this.currentId = TRANSFER_MENU;
		
		System.out.println("Enter fund receiving account pin:");
		String accountTo = sc.next();
		System.out.println("Amount to transfer: $");
		double amount = sc.nextDouble();
		try{
		tm.withdrawal(am.getAccount(accountTo), amount);
		}catch(TransactionException e){
			
			handleTranException(e);
		}
		
		return BANKING_MENU;
	
	}
		
	public int account( ){
		this.currentId = ACCOUNT_MENU;
		
		System.out.println("\t"+ CREATEACCOUNT_MENU +". Banking");
		System.out.println("\t"+ WELCOME_MENU +". Back");
		System.out.print("Please choose from menu:");
		
		return this.sc.nextInt();
		
		
	}
	public int createAccount(){
		this.currentId = CREATEACCOUNT_MENU;
		//not open
		System.out.println("Service not available at this time.");
		return ACCOUNT_MENU;
	}
	
	private void handleTranException(TransactionException e){
		System.out.println("Operation failed - "+e.getMessage());
		this.getMenu(this.currentId);
	}
	
	public boolean isAlive(){
		return alive;
		
	}
}
