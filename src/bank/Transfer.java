package bank;

public class Transfer extends Transaction {
	
	private Account accountTo;

	public Transfer() {

	}
	
	public void start(Account accountFrom, Account accountTo) throws TransactionException {
		// TODO Auto-generated method stub
		super.start(accountFrom);	
		
		if (accountTo == null){
			 throw new TransactionException("Invalid receiving account");
			
		}else{
		
			this.accountTo = accountTo;	
		}

	}
	public void complete(double amount) throws TransactionException {
		// TODO Auto-generated method stub
		if(this.account.getAmount() >= amount){
			
			this.account.setAmount(this.account.getAmount() - amount);
			this.accountTo.setAmount(this.accountTo.getAmount() + amount);
		}
		else{
		    throw new TransactionException("Insufficient fund.");
		}
		super.complete();
	}

}
