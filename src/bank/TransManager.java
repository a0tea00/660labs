package bank;

import java.util.ArrayList;;


public class TransManager {
	private ArrayList<Transaction> transPool;

	
	public TransManager(){
		
	}

	
	
	public Transaction startTransaction(Transaction t){
		transPool.add(t); 
		return t;
	}
	
	public void deposit(Transaction t, double amount ){
		final String type = "DEPOSIT";		
		
		t.setType(type);
		t.setFinalAmount((t.getIniAmount() + amount));
		t.complete();
		System.out.println(t);
	}

	public void withdrawal(Transaction t, double amount){
		final String type = "WITHDRAW";
		t.setType(type);
		t.setFinalAmount((t.getIniAmount() - amount));
		t.complete();	
		System.out.println(t);
	}
	
	//for Part B
	public void transfer(Transaction t1, Transaction t2, double amount){
		final String type1 = "TRAN SEND";
		final String type2 = "TRAN RECEIVED";
		
		t1.setType(type1);
		t2.setType(type2);

		
		t1.setFinalAmount((t1.getIniAmount() - amount));
		t2.setFinalAmount((t2.getIniAmount() + amount));
		
		t1.complete();
		t2.complete();
		
		System.out.println(t1);
		System.out.println(t2);
		
	}
}
