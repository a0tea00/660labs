package bank;


public class Transaction {
	private Account account;
	private double iniAmount;
	private double finalAmount;
	private String type;
	private boolean completed;
	
	
	
	public Transaction(Account account){
		this.account = account;
		this.iniAmount = 0.0;
		if (this.account != null){
			this.iniAmount = account.getAmount();
			
		}
	}
	
	public void complete(){
		
		this.account.setAmount(this.finalAmount); 
		this.completed = true;
	}
	
	public String toString(){
		return "#" + this.account.getPin() + ": " + this.type +" $" + (this.finalAmount - this.iniAmount);
		
	}
	
	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double getIniAmount() {
		return iniAmount;
	}

	public void setIniAmount(double iniAmount) {
		this.iniAmount = iniAmount;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
