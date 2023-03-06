package main;

import bankManagement.Transaction;
import bankManagement.Account;
import bankManagement.Bank;
import bankManagement.Customer;

public class Main {

	public static void main(String[] args) {
		Transaction t = new Transaction();
		Transaction t1=new Transaction(101,"deposit",200);
		System.out.println(t1.getType());
		System.out.println(t1.getId());
		System.out.println(t1.getAmount());
		System.out.println(t1.getDateAndHour());
		System.out.println("========================\n");

		Account a = new Account();
		Transaction[] tr= {t,t1};
		Account a1=new Account("savings",2001,19345,tr);
		
		  System.out.println(a1.getNumber());
		  System.out.println(a1.getType());
		  System.out.println(a1.getBalance());
		  for(int i=0;i<a1.getTransactionList().length;i++)
		  System.out.println(a1.getTransactionList()[i]);
		  System.out.println("========================\n");
		  
		  
		  Customer c=new Customer();
		  Account [] ac= {a,a1};
		  Customer c1=new Customer("ana",3567,"0876542879",ac);
		  System.out.println(c1.getName());
		  System.out.println(c1.getId());
		  System.out.println(c1.getPhone());
		  for(int i=0;i<c1.getAccountList().length;i++)
			  System.out.println(c1.getAccountList()[i]);
		  System.out.println("========================\n");
		  
		  Bank b=new Bank();
		  Customer[] cu= {c,c1};
	      Bank b1=new Bank(cu,ac,tr);
		  for(int i=0;i<b1.getAccountList().length ;i++)
		  System.out.println(b1.getAccountList()[i]);
		  for(int i=0;i<b1.getCustomerList().length ;i++)
		  System.out.println(b1.getCustomerList()[i]);
		  for(int i=0;i<b1.getTransactionList().length;i++)
		 System.out.println(b1.getTransactionList()[i]);
		  
		 System.out.println("**************************");
		  
		  System.out.println(c1.getAccount(2001));
		  c1.deleteAccount(200);
		  c1.addAccount(a);
		  System.out.println("*****************\n");
		  for(int i=0;i<c1.getAccountList().length;i++)
			  System.out.println(c1.getAccountList()[i]);
		  
			/* a.saveData(); */
		  
			/*
			 * c1.saveData(); t1.saveData();
			 */
		 
		  
		  for(int i=0;i<b1.getAccountList().length ;i++)
			  System.out.println(b1.getAccountList()[i]+"\n\n");
			

			
			  for(int i=0;i<b1.getTransactionList().length;i++)
			  System.out.println(b1.getTransactionList()[i]+"\n\n");
			  
			  System.out.println("____________________________");
			  
			  System.out.println(c1);
			  
			  b.saveData();
			  
			 
			 
			 
		  
		  
		 
		 
	}

}
