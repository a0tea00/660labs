package bank;

public interface BasicTransaction {

	public void start(Account account) throws TransactionException;
	
	public void  complete() throws TransactionException;
	
}
