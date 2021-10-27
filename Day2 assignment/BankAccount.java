package bankstructure;
import java.util.Scanner;

	public class BankAccount 
	{
		
		 int accountNumber;
		 String name;
		 String password;
		 double balance;
		 double interestRate;
		
		Scanner scan=new Scanner(System.in);
		public int getAccountNumber() {
			return accountNumber;
		}


		public String getName()
		{
			return name;
		}

		public void setName(String name) 
		{
			this.name = name;
		}

		
		public double getBalance()
		{
			System.out.println(balance);
			return balance;
		}

		
		public double getInterestRate()
		{
			return interestRate;
		}

		public void setInterestRate(double interestRate)
		{
			this.interestRate = interestRate;
		}
		

		public String getPassword()
		{
			return password;
		}

		public void setPassword(String password)
		{
			
			this.password = salt(password);
		}

		

		private String salt(String password) 
		{
			
			String salted="";
			
			for(int i=0;i<password.length();i++) {
				int ch= (int) password.charAt(i)+2;
				salted+=Integer.toBinaryString(ch);
			}
			return salted;
		}

		public BankAccount(int accountNumber, String name, String password, double amount,double interestRate) 
		{
			
			balance=amount; 	
			this.name=name;
			setPassword(password);
			this.interestRate=interestRate;
			this.accountNumber=accountNumber;
			
		}
		
		public void show()
		{
			System.out.println("account number\t"+accountNumber);
			System.out.println("name         \t"+name);
			System.out.println("password     \t"+password);
			System.out.println("balance      \t"+balance);
			System.out.println("interest rate\t"+interestRate);
			System.out.println();
			
		}

		public void deposit() 
		{
			
			System.out.println("Enter the amount to deposit :");
			long Amount=scan.nextLong();
			balance=balance+Amount;
			System.out.println("Successfully deposited now your balance is" +(balance)+" rupees");
			
			}
		

		public void withdraw()
		{
			String psw;
			
			System.out.println("Enter the password :");
			psw=scan.next();
			System.out.println(password);
			if(password.equals(psw))
			{
				System.out.println("Enter the amount to be withdraw :");
				long Amount=scan.nextLong();
				if(Amount<=0)
				{
					System.out.println("Should not withdraw amount.Please withdraw some other Amount!!!");
				}
				else if(Amount>balance)
				{
					System.out.println("Less Balance..Please withdraw some other Amount!!!");
				}
				else 
				{
					System.out.println("Successfully withdraw!! Available balance is " +(balance-Amount)+" rupees");
				}
				
			}
			else
			{
				System.out.println("Invalid Password!!!!");
			}
			
			
		}
		
		public void creditInterest() 
		{
			balance+=(balance*interestRate/1200);
                        System.out.println("Credited Interest is :"+Balance);
		}
		


	
}
