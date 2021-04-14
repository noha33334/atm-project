import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;



 class Account {
	String accountName;
	String accountPass;
	double balance;
	public Account(String name,String password,double balance){
		this.accountName=Objects.requireNonNull(name);
		this.accountPass=Objects.requireNonNull(password);
		this.balance=balance;
	}
	public boolean isMatching(String name, String encryptedPassword) {
        return Objects.equals(this.accountName, name) 
                    && Objects.equals(this.accountPass, encryptedPassword);
    }
	public double Deposit(){
		return this.balance;
	}
	public double withdrawl(double amount){
		this.balance=this.balance-amount;
		return balance;
	}


}

class AccountManager{
	public List<Account> accounts=getAccounts();

    public void creatAccount(String name,String password,double balance){
		
        new Account(name,password,balance);

	}


	public List<Account> getAccounts(){
		return Arrays.asList(new Account("a0","a0",9999),
				new Account("a1","a1",8888),
				new Account("a2","a2",77777));
	}
	public Account selectAccount(String accountName,String accountPassword){
		System.out.print(accounts);
		for (Account account:accounts){
			if(account.isMatching(accountName, accountPassword)){
				System.out.print("Matched, Welcome "+accountName+"Your balance is "+account.balance);
				return account;
			}
		}
		System.out.print("Not Matched");
		return null;
	}


    public void transfer(int from , int to , double balance){
        Account x = accounts.get(from);
         x.balance =x.balance -  balance;
         Account a = accounts.get(to);
         a.balance =a.balance +  balance;

	}

}


class ATM{
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
				System.out.print(customer.Deposit());
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









