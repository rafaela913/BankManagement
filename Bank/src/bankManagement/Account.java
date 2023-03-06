package bankManagement; 
import java.io.FileWriter;
import java.io.IOException;

public class Account {
   private String type;
   private int number;
   private float balance;
   private Transaction[] transactionList;
   
   public Account()
   {
	   this.type="unknown";
	   this.number=200;
	   this.balance=0;
	   this.transactionList=new Transaction[1];
	   transactionList[0]=new Transaction();
	   
   }

public Account(String type, int number, float balance, Transaction[] transactionList) {
	this.type = type;
	this.number = number;
	this.balance = balance;
	this.transactionList = new Transaction[transactionList.length];
	for(int i=0;i<transactionList.length;i++)
		this.transactionList[i]=transactionList[i];
}

@Override
public Object clone() {
	Account copy=new Account();
	copy.type=type;
	copy.number = number;
	copy.balance = balance;
	copy.transactionList = new Transaction[transactionList.length];
	for(int i=0;i<transactionList.length;i++)
		copy.transactionList[i]=transactionList[i];
	return copy;
	
}

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Type: ").append(type)
        .append("\nNumber: ").append(number)
        .append("\nBalance: ").append(balance)
        .append("\nList of transactions:\n");
    for (Transaction t : transactionList) {
        sb.append(t.toString()).append("\n");
    }
    return sb.toString();
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public int getNumber() {
	return number;
}

public void setNumber(int number) {
	this.number = number;
}

public float getBalance() {
	return balance;
}

public void setBalance(float balance) {
	this.balance = balance;
}

public Transaction[] getTransactionList() {
	return transactionList;
}

public void setTransactionList(Transaction[] transactionList) {
	this.transactionList = new Transaction[transactionList.length];
	for(int i=0;i<transactionList.length;i++)
		this.transactionList[i]=transactionList[i];
}
public void addTransaction(Transaction transaction) {
	Transaction [] copy=new Transaction[this.transactionList.length];
	for(int i=0;i<this.transactionList.length;i++)
		copy[i]=this.transactionList[i];
	this.transactionList=new Transaction[copy.length+1];
	for(int i=0;i<copy.length;i++)
		this.transactionList[i]=copy[i];
	this.transactionList[copy.length]=transaction;
	
	
}
public void addMoney(float amount)
{
	this.balance=this.balance+amount;
}
public void removeMoney(float amount)
{
	this.balance=this.balance-amount;
}

public void saveData()
{  
try {
    FileWriter myWriter = new FileWriter("YourAccountData.txt");
    myWriter.write("Type: "+this.type+"\nNumber: "+this.number+"\nBalance: "+this.balance
    		+"\nTransaction: ");
    for(int i=0;i<this.transactionList.length;i++)
    	myWriter.write((i+1)+" \n"+this.transactionList[i]);
    myWriter.close();
    System.out.println("Successfully wrote to the file.");
  } catch (IOException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
  }
	
}


   
   
}
