package bank;

public class Account {
	private String pin =null;
	private double amount;
	
	public Account(String pin){
		this.pin = pin;
		this.amount = 0.0;
	}
	
	public String toString(){
		
		return ("***************************"+
				"Account: "+ this.pin+" current balance: $" + this.amount+
				"***************************");
		
	}
	
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
