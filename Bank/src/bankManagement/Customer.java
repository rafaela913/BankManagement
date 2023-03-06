package bankManagement;

import java.io.FileWriter;
import java.io.IOException;

public class Customer {
	private String name;
	private int id;
	private String phone;
	private Account[] accountList;
	
	public Customer()
	{
		this.name="unknown";
		this.id=0;
		this.phone="unknown";
		this.accountList=new Account[1];
		this.accountList[0]=new Account();
		
	}

	public Customer(String name, int id, String phone, Account[] accountList) {
		this.name = name;
		this.id = id;
		this.phone = phone;
		this.accountList=new Account[accountList.length];
		for(int i=0;i<accountList.length;i++)
		this.accountList[i] = accountList[i];
	}

	@Override
	protected Object clone() {
		Customer copy=new Customer();
		copy.name = name;
		copy.id = id;
		copy.phone = phone;
		copy.accountList=new Account[accountList.length];
		for(int i=0;i<accountList.length;i++)
		copy.accountList[i] = accountList[i];
		return copy;
		
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Name: ").append(name)
	        .append("\nId: ").append(id)
	        .append("\nPhone: ").append(phone)
	        .append("\nList of accounts:\n");
	    for (Account m : this.accountList) { 
	    	if(m!=null)
	        sb.append(m.toString()).append("\n");
	    }
	    return sb.toString();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Account[] getAccountList() {
		return accountList;
	}

	public void setAccountList(Account[] accountList) {
		this.accountList=new Account[accountList.length];
		for(int i=0;i<accountList.length;i++)
		this.accountList[i] = accountList[i];
	}
	public Account getAccount(int number)
	{
		for(int i=0;i<this.accountList.length;i++)
		{
			if(this.getAccountList()[i].getNumber()==number)
				return this.getAccountList()[i];
		}
		return null;
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
	
	public void saveData()
	{  
	try {
	    FileWriter myWriter = new FileWriter("CustomerData.txt");
	    myWriter.write("Name: "+this.name+"\nId: "+this.id+"\nPhone: "+this.phone
	    		+"\nAccounts: ");
	    for(int i=0;i<this.accountList.length;i++)
	    	myWriter.write(". \n"+this.accountList[i]);
	    myWriter.close();
	    System.out.println("Successfully wrote to the file.");
	  } catch (IOException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	  }
		
	}
				
		
		
	
	

}
