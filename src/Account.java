import java.util.ArrayList;
import java.util.Objects;
public class Account {
    String accountName;
	String accountPass;
	double balance;

    ArrayList<String> History = new ArrayList<String>();


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
        History.add(" + "+balance);
		return balance;
	}

    public ArrayList<String> Transactions_History(){
        return History; 
	}

}
