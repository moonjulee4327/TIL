package chapter7Exercise;

public class Bank {
	//필드
	private Customer[] customers;
	private int numberOfCustomer;
	
	//생성자
	public Bank() {
		Customer[] customers = new Customer[10];
		this.customers=customers;
	}
	
	//메소드
	public void addCustomer(Customer customer) {
		for(int i=0; i<10; i++) {
		this.customers[i] = customer;
		}
		this.numberOfCustomer = numberOfCustomer++;
	}
	public int getNumberOfCustomers() {
		return numberOfCustomer;
	}
	
	public Customer[] getCustomers(int index) {
		return customers[index];	
	}
	public Customer getCustomer(int customer) {
		return customer;	
	}
	
}
