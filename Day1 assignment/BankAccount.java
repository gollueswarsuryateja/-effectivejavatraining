package account;
import java.util.Scanner;

public class BankAccount{
	String acc_no,name,password;
	float balance, interest_rate;
	Scanner get = new Scanner(System.in);
	
		public BankAccount(){}
		public BankAccount(String accno, String acc_name, String pass, float amount, double rate){
			acc_no = accno;
			name = acc_name;
			password = pass;
			balance = amount;
			interest_rate = (float) rate;
		}
		
		public void creditInterest(){
			balance = balance + (balance * interest_rate / 1200);
		}
		
		public void depositAmount(){
			System.out.println("Enter Deposit Amount : ");
			float amount = get.nextFloat();
			if (amount > 0){
				balance = balance + amount;
				System.out.println(amount + "Deposited to the Account " + acc_no);
				System.out.println("Show balance (y/n)");
				if(get.next().charAt(0) == 'y'){ displayBalance(); }
			}
			else{
				System.out.println("Deposite Failed..!");
			}
		}
		
		public void withdrawAmount(){
			System.out.println("Enter Withdrawal Amount : ");
			float amount = get.nextFloat();
			System.out.println("Enter password : ");
			String pass = get.nextLine();
			if(amount > 0 && amount < balance){
				if(password.equals(pass)){
					balance = balance - amount;
					System.out.println(amount + "Debited from Account " + acc_no);
					System.out.println("Show balance (y/n)");
					if(get.next().charAt(0) == 'y'){ displayBalance(); }
				}
				else{
					System.out.println("Wrong Password Entered..!");
				}
			}
			else{
				System.out.println("Amount can not be distributed..!");
			}
		}
		
		public void options(){
			System.out.println("1.Account Number\n2. Interest Rate\n3.Account Holder Name\n4. Display Balance\n5.Change Password\n0. exit");
			switch(get.nextInt()){
				case 1:
					viewAccNumber();
					break;
				case 2:
					interestFunc();
					break;
				case 3:
					accountName();
					break;
				case 4:
					displayBalance();
					break;
				case 5:
					changePassword();
					break;
				case 0:
					return;
			}
		}
		
		public void viewAccNumber(){
			System.out.println("Account Number : " + acc_no);
		}
		
		public void interestFunc(){
			System.out.println("Interest Rate for the \naccount : " + acc_no + "\nInterest Rate : " + interest_rate);
			System.out.print("Do you want change Interest Rate (y/n) : ");
			if(get.next().charAt(0) == 'y'){
				System.out.print("Enter new Interest Rate : ");
				interest_rate = get.nextFloat();
			}
		}

		public void accountName(){
			System.out.println("Account Holder Name : " + name);
			System.out.print("Do you want change Account Holder Name (y/n) : ");
			if(get.next().charAt(0) == 'y'){
				System.out.print("Enter Name : ");
				name = get.nextLine();
			}
		}
		
		public void displayBalance(){
			System.out.println("Current Balance is : " + balance);
		}
		
		public void changePassword(){
			System.out.println("Do you want to change password (y/n)");
			String pass;
			if(get.next().charAt(0) == 'y'){
				System.out.print("Enter old Password : ");
				if(get.nextLine() == password){
					System.out.print("Enter new password : ");
					pass = get.nextLine();
					System.out.print("Retype password : ");
					if(pass == get.nextLine()){
						password = pass;
					}
				}
			}
		}
}