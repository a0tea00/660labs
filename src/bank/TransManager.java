package bank;


import org.springframework.beans.factory.annotation.*;


public class TransManager {
	
	private Deposit tranDeposit;
	private Withdrawal tranWithdrawal;
	private Transfer tranTransfer;
	
	
	public TransManager(){
		
	}
	@Required
	public void setTranDeposit(Deposit tranDeposit) {
		this.tranDeposit = tranDeposit;
	}
	@Required
	public void setTranWithdrawal(Withdrawal tranWithdrawal) {
		this.tranWithdrawal = tranWithdrawal;
	}
	@Required
	public void setTranTransfer(Transfer tranTransfer) {
		this.tranTransfer = tranTransfer;
	}

	public void deposit( Account account, double amount) throws TransactionException{
		try{
			tranDeposit.start(account);
			tranDeposit.complete(amount);
			
		}
		catch(TransactionException e){
			throw e;
		}
	}
	
	public void withdrawal( Account account, double amount) throws TransactionException{	
		try{
			tranWithdrawal.start(account);
			tranWithdrawal.complete(amount);
			
		}
		catch(TransactionException e){
			throw e;
		}
	}
	
	public void transfer( Account accountFrom, Account accountTo, double amount) throws TransactionException{
		try{
			tranTransfer.start(accountFrom, accountTo);
			tranTransfer.complete(amount);
			
		}
		catch(TransactionException e){
			throw e;
		}
	}

	
}
