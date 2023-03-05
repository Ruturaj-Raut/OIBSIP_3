import java.util.Scanner;

class Account {
	
	String userName;
	String password;
	float balance = 100000f;
	int transactions = 0;
	String transactionHistory = "";
	
	
	public void signup() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter Your Username:- ");
		this.userName = sc.nextLine();
		System.out.println("Enter Your Password:- ");
		this.password = sc.nextLine();
		System.out.println("Registration completed!!");
	}
	
	public boolean signin() {
		boolean isSignin = false;
		Scanner sc = new Scanner(System.in);
		while ( !isSignin ) {
			System.out.print("\nEnter Your Username:- ");
			String Username = sc.nextLine();
			if ( Username.equals(userName) ) {
				while ( !isSignin ) {
					System.out.print("\nEnter Your Password:- ");
					String Password = sc.next();
					if ( Password.equals(password) ) {
						System.out.print("\nLogin successful!!");
						isSignin = true;
					}
					else {
						System.out.println("\nIncorrect Password!!");
					}
				}
			}
			else {
				System.out.println("\nUsername not found!!");
			}
		}
		return isSignin;
	}
	public void checkBalance(){
        System.out.println("your balance is:"+balance);
    }
	public void withdraw() {
		
		System.out.print("\nEnter amount to withdraw:- ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		if ( balance >= amount ) {
				transactions++;
				balance -= amount;
				System.out.println("\nWithdraw Successfully!!");
				String str = amount + " Rs debited\n";
				transactionHistory = transactionHistory.concat(str);
				
			}
		else {
				System.out.println("\nInsufficient Balance!!");
			}
			
	}
	
	public void deposit() {
		
		System.out.print("\nEnter amount to deposit:- ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		if ( amount <= 100000f ) {
				transactions++;
				balance += amount;
				System.out.println("\nSuccessfully Deposited!!");
				String str = amount + " Rs credited\n";
				transactionHistory = transactionHistory.concat(str);
			}
		else {
				System.out.println("\nSorry  limit for deposit is Rs 100000.0");
			}
	}
	
	public void transfer() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter Receipent's Name:- ");
		String receipent = sc.nextLine();
		System.out.println("Enter amount to transfer:- ");
		float amount = sc.nextFloat();
		if ( balance >= amount ) {
			if ( amount <= 50000f ) {
					transactions++;
					balance -= amount;
					System.out.println(amount+"transfered successfully!!");
					String str = amount + " Rs transfered to " + receipent + "\n";
					transactionHistory = transactionHistory.concat(str);
			 }
			else {
					System.out.println("\nSorry limit for transfer is Rs 50000.0!!");
				}
			}
			else {
				System.out.println("\nInsufficient balance to transfer!!");
			}
	}
	
	public void transactionHistory() {
	    System.out.println("Transaction history are as follows\n");
		if ( transactions == 0 ) {
			System.out.println("Empty");
		}
		else {
			System.out.println(transactionHistory+"\n");
		}
	}
}


public class AtmInterface {
	
	public static void main(String[] args) {
		
		System.out.println("\n      WELCOME TO ATM SYSTEM");
		System.out.println("1.Sign In");
		System.out.println("2.EXit");
		System.out.print("Enter Your Choice :- ");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		if ( choice == 1 ) {
			Account user = new Account();
			user.signup();
			while(true) {
				System.out.println("\n1.Sign In");
				System.out.println("2.Exit");
				System.out.print("Enter Your Choice - ");
				int ch=sc.nextInt();
				if ( ch == 1 ) {
					if (user.signin()) {
						System.out.println("\n\n        WELCOME  " + user.userName );
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("\n1.Balance \n2.Transactions History \n3.Withdraw \n4.Deposit \n5.Transfer \n6.Quit");
							System.out.print("\nEnter Your Choice:- ");
							int transactionChoice=sc.nextInt();
							switch(transactionChoice) {
								case 1:
                                user.checkBalance();
                                break;
                                case 2:
								user.transactionHistory();
								break;
								case 3:
								user.withdraw();
								break;
								case 4:
								user.deposit();
								break;
								case 5:
								user.transfer();
								break;
								case 6:
								isFinished=true;
								System.out.println("Thank you for using ATM service!!");
								System.exit(0);
								break;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}		
	}
}	