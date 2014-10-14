package bank;


public class Transaction implements BasicTransaction {
	protected Account account;
	
	
	
	public Transaction(){

	}
	
	@Override
	public void start(Account account) throws TransactionException {
		// TODO Auto-generated method stub
		this.account = account;	

	}

	@Override
	public void complete() throws TransactionException {
		// TODO Auto-generated method stub
		this.account = null;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
