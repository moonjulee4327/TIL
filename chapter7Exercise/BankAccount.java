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
		//입금 메소드
	}
	public boolean withdraw(int amount) {
		//출금 메소드
	}
	public boolean transfer(int amount, BankAccount otherAccount) {
		//현재 계좌에서 amount 만큼 다른 계좌로 송금 메소드
	}
	
}
