package bank;

public class Withdrawal extends Transaction {

	public Withdrawal(){
		// TODO Auto-generated constructor stub
	}
	
	public void complete(double amount) throws TransactionException {
		// TODO Auto-generated method stub
		if(this.account.getAmount() >= amount){
			
			this.account.setAmount(this.account.getAmount() - amount);
		}
		else{
		    throw new TransactionException("Insufficient fund.");
		}
		super.complete();
	}

}
