package assignment2;

interface BankingOperations
{
	 void deposit(double amount);
	 void withdraw (double amount) throws Exception;
	 void checkBalance();
}

interface CustomerDetails
{
	void displayCustomerDetails();
}

class BankAccount implements BankingOperations, CustomerDetails
{
	private int accountNumber;
	private String customerName;
	private double balance;
	BankAccount(int accountNumber, String customerName, double balance)
	{
		this.accountNumber= accountNumber;
		this.customerName= customerName;
		this.balance=balance;
	}
	
	public void deposit(double amount)
	{
		if(amount<0)
		{
			System.out.println("Invalid deposit amount");
		}
		else
		{
			balance+=amount;
			System.out.println("Deposited: "+amount);
			
		}
	}
	public void withdraw(double amount) throws Exception
	{
		if(amount> balance)
		{
			throw new Exception("Insufficent Balance");
			
		}
		else {
			balance-=amount;
			System.out.println("Withdraw: "+amount);
		}
		
	}
	
	public void checkBalance()
	{
		System.out.println("Current Blance: "+balance);
	}
	
	public void displayCustomerDetails()
	{
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Customer Name: "+ customerName);
	}
	
}
public class bankdemo {
	
	public static void main(String args[])
	{
		BankAccount account=new BankAccount(101, "Anamika Patel", 5000);
		BankAccount c1= new BankAccount(102, "Ayushikumari", 4000);
		
		account.displayCustomerDetails();
		account.checkBalance();
		account.deposit(2000);
		
		c1.displayCustomerDetails();
		c1.checkBalance();
		c1.deposit(2000);
		
		try {
			account.withdraw(8000);
		}catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		
		try {
			account.withdraw(3000);
		}catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		
		account.checkBalance();
		
	}

}
