import java.util.Scanner;
import account.BankAccount;

class Bank{
	public static void main(String args[]){
		
		Scanner read = new Scanner(System.in);
		BankAccount ba = new BankAccount("0124689106438","eswarsuryateja","12345678",1000,0.2);
		
		while(true){
			System.out.println("1. Deposit\n2. Withdrawn\n3. Credit Interest\n0. Exit\n4. Options\nEnter your choice");
			switch(read.nextInt()){
				case 1:
					ba.depositAmount();
					break;
				case 2:
					ba.withdrawAmount();
					break;
				case 3:
					ba.creditInterest();
					break;
				case 4:
					ba.options();
					break;
				case 0:
					return;
			}
		}
	}
}