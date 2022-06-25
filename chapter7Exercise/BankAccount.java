package chapter7Exercise;

public class BankAccount {
	//필드
	private int balance;
	
	//생성자
	public BankAccount(int balance){
		this.balance = balance;	
	}
	
	//메소드
	public int getBalance() {
		return balance;
	}
	public void deposit(int amount) {
		this.balance = balance + amount; 
	}
	public boolean withdraw(int amount) {
		if(balance-amount>=0) {
			
			this.balance -= amount;
			return true;
			
		}else {
			
			return false;
		}
	}
	
	public boolean transfer(int amount, BankAccount otherAccount) {
		if(withdraw(amount)) {
			System.out.println("송금완료");
			return true;
		}else {
			return false;
		}
	}
	
}
