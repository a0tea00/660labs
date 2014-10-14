package bank;

public class TransactionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static private String description = "An Error occurred during transaction.";

	public TransactionException(){
		
	}
	public TransactionException(String message){
		super(description+"\n"+message);
	}
	

}
