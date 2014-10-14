package bank;

public class Deposit extends Transaction {

	public Deposit() {
		// TODO Auto-generated constructor stub
	}
	public void complete(double amount) throws TransactionException {
		// TODO Auto-generated method stub
			
		this.account.setAmount(this.account.getAmount() + amount);

		super.complete();
	}

}
