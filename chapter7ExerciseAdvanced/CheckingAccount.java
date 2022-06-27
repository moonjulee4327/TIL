package chapter7ExerciseAdvanced;

public class CheckingAccount extends BankAccount{
	//필드
	private SavingsAccount protectedBy;
	
	//생성자
	public CheckingAccount(int balance) {
		super(balance);
	}
	public CheckingAccount(int balance, SavingsAccount protectedBy) {
		super(balance);
		this.protectedBy=protectedBy;
	}
	
	//메소드
	@Override
	public boolean withdraw(int amount) {
		if(balance-amount>=0) {
			deposit(amount);
			return true;
		}else {
			
			return false;
		}
	}
	
}
