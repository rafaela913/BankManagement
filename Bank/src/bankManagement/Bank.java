package bankManagement;

import java.io.FileWriter;
import java.io.IOException;

public class Bank {
	private Customer [] customerList;
	private Account [] accountList;
	private Transaction [] transactionList;
	
	public Bank()
	{
		this.customerList=new Customer[1];
		customerList[0]=new Customer();
		this.accountList=new Account[1];
		accountList[0]=new Account();
		this.transactionList=new Transaction[1];
		transactionList[0]=new Transaction();
	}

	public Bank(Customer[] customerList, Account[] accountList, Transaction[] transactionList) {
		this.customerList=new Customer[customerList.length];
		for(int i=0;i<customerList.length;i++)
			this.customerList[i]=customerList[i];
		this.accountList=new Account[accountList.length];
		for(int i=0;i<accountList.length;i++)
			this.accountList[i]=accountList[i];
		this.transactionList=new Transaction[transactionList.length];
		for(int i=0;i<transactionList.length;i++)
			this.transactionList[i]=transactionList[i];
	}

	@Override
	public Object clone()  {
		Bank copy=new Bank();
		copy.customerList=new Customer[customerList.length];
		for(int i=0;i<customerList.length;i++)
			copy.customerList[i]=customerList[i];
		copy.accountList=new Account[accountList.length];
		for(int i=0;i<accountList.length;i++)
			copy.accountList[i]=accountList[i];
		copy.transactionList=new Transaction[transactionList.length];
		for(int i=0;i<transactionList.length;i++)
			copy.transactionList[i]=transactionList[i];
		return copy;
		
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("\nList of customers: ");
	    for (Customer c : this.customerList) {
	        sb.append(c.toString());
	    }
	    sb.append("\nList of accounts: ");
	    for (Account a : this.accountList) {
	        sb.append(a.toString());
	    }
	    sb.append("\nList of transactions: ");
	    for (Transaction t : this.transactionList) {
	        sb.append(t.toString());
	    }
	    return sb.toString();
	}
	public Customer[] getCustomerList() {
		return customerList;
	}

	public void setCustomerList(Customer[] customerList) {
		this.customerList=new Customer[customerList.length];
		for(int i=0;i<customerList.length;i++)
			this.customerList[i]=customerList[i];
	}

	public Account[] getAccountList() {
		return accountList;
	}

	public void setAccountList(Account[] accountList) {
		this.accountList=new Account[accountList.length];
		for(int i=0;i<accountList.length;i++)
			this.accountList[i]=accountList[i];
	}

	public Transaction[] getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(Transaction[] transactionList) {
		this.transactionList=new Transaction[transactionList.length];
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
		this.transactionList[copy.length]=transaction;}
	
	
	public void deleteTransaction(int id)
	{ 
		Transaction [] copy=new Transaction[this.transactionList.length];
		for(int i=0;i<this.transactionList.length;i++)
		{ if(this.transactionList[i].getId()!=id)
			copy[i]=this.transactionList[i];}
		this.transactionList=new Transaction[copy.length];
		for(int i=0;i<copy.length;i++)
			this.transactionList[i]=copy[i];}
	
	
	public void addAccount(Account account)	
	{
		Account [] copy=new Account[this.accountList.length];
		for(int i=0;i<this.accountList.length;i++)
			copy[i]=this.accountList[i];
		this.accountList=new Account[copy.length+1];
		for(int i=0;i<copy.length;i++)
			this.accountList[i]=copy[i];
		this.accountList[copy.length]=account;
		
	}
	
	public void deleteAccount(int number)
	{ 
		Account [] copy=new Account[this.accountList.length];
		for(int i=0;i<this.accountList.length;i++)
		{ if(this.accountList[i].getNumber()!=number)
			copy[i]=this.accountList[i];}
		this.accountList=new Account[copy.length];
		for(int i=0;i<copy.length;i++)
			this.accountList[i]=copy[i];}
	
	
	public void addCustomer(Customer customer)	
	{
		Customer [] copy=new Customer[this.customerList.length];
		for(int i=0;i<this.customerList.length;i++)
			copy[i]=this.customerList[i];
		this.customerList=new Customer[copy.length+1];
		for(int i=0;i<copy.length;i++)
			this.customerList[i]=copy[i];
		this.customerList[copy.length]=customer;
		
	}
	
	public void deleteCustomer(int id)
	{ 
		Customer [] copy=new Customer[this.customerList.length];
		for(int i=0;i<this.customerList.length;i++)
		{ if(this.customerList[i].getId()!=id)
			copy[i]=this.customerList[i];}
		this.customerList=new Customer[copy.length];
		for(int i=0;i<copy.length;i++)
			this.customerList[i]=copy[i];}
	
	public void saveData()
	{  
	try {
	    FileWriter myWriter = new FileWriter("BankData.txt");
	    myWriter.write("Customers: \n");
	    for(int i=0;i<this.customerList.length;i++)
	    	myWriter.write("\n\n"+this.customerList[i]);
	    myWriter.write("Accounts: \n");
	    for(int i=0;i<this.accountList.length;i++)
	    	myWriter.write("\n\n"+this.accountList[i]);
	    myWriter.write("Transactions: \n");
	    for(int i=0;i<this.transactionList.length;i++)
	    	myWriter.write("\n\n"+this.transactionList[i]);
	    myWriter.close();
	    System.out.println("Successfully wrote to the file.");
	  } catch (IOException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	  }
		
	}
	
	
	
	
	

}
