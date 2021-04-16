import java.util.Scanner;

class App{
	static Scanner scanner=new Scanner(System.in);
	static String accountHolderName = null;
	static String accountPass=null;
	static int option;
	static AccountManager m=new AccountManager();
	
	public static void main(String[] args){
		System.out.println("Welcome to my ATM");
		
		System.out.println("Enter account name");
		accountHolderName=new String(scanner.nextLine());
			
		System.out.println("Enter account password");
		accountPass=new String(scanner.nextLine());
		Account customer=m.selectAccount(accountHolderName,accountPass);
		System.out.print(customer.accountName);
		do{
			System.out.println("Welcome "+ customer.accountName);
			System.out.println("Options for you are :");
			System.out.println("1.Transactions History\n"
					+ "2.Withdraw\n"
					+ "3.Deposit\n"
					+ "4.Transfer\n"
					+ "5.Quit\n"
                    + "6.Add a new account\n");	
			switch(option){
			case 1:
				System.out.print(customer.Transactions_History());
				break;
			case 2:
				System.out.println("Enter the amount to withdrraw");
				double amount=scanner.nextInt();
				double left=customer.withdrawl(amount);
				System.out.println("Done "+left);
				break;
			case 3:
                System.out.print(customer.Deposit());
				
				break;
				
			case 4:
                System.out.println("Enter sender account number");
                int sender=scanner.nextInt();
                System.out.println("Enter reciver account password");
                int reciver=scanner.nextInt();
                System.out.println("Enter account balance");
                double actbalance_= scanner.nextInt();
                m.transfer(sender, reciver, actbalance_);
				break;
			case 5:
				break;
            case 6:
                System.out.println("Enter account name");
                String accountName_x=new String(scanner.nextLine());
                
                System.out.println("Enter account password");
                String accountPassword_=new String(scanner.nextLine());

                System.out.println("Enter account balance");
                double accountbalance_= scanner.nextInt();
                m.creatAccount(accountName_x, accountPassword_, accountbalance_);
            
				break;
			}
			option=scanner.nextInt();
		}while(option!=5);
		
		}
	}