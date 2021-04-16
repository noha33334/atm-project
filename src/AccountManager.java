
import java.util.Arrays;
import java.util.List;
public class AccountManager {
    Account cAccount ; 
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
         cAccount.History.add(" - "+balance);
	}

}
