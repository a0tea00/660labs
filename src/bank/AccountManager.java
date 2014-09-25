package bank;

import java.util.HashMap;

public class AccountManager {
	private HashMap<String,Account> accountPool = new HashMap<String, Account> ();
	
	public AccountManager(){
		
	}
	
	public Account creatAccount(Account account){
		
		this.accountPool.put(account.getPin(), account);
		
		return account;
	}
	
	public Account getAccount (String pin){
		
		return this.accountPool.get(pin);
	}
	public boolean isAccount(String pin){
		return this.accountPool.containsKey(pin);
		
	}

	public HashMap<String, Account> getAccountPool() {
		return accountPool;
	}

	public void setAccountPool(HashMap<String, Account> accountPool) {
		this.accountPool = accountPool;
	}
	
	
}
