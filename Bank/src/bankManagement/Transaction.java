package bankManagement;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
	private int id;
	private String type;
	private float amount;
	private String dateAndHour;
	
	
	public Transaction()
	{
		this.id=100;
		this.type="unknown";
		this.amount=0;
		LocalDateTime lt=LocalDateTime.now();
		DateTimeFormatter tf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		this.dateAndHour=lt.format(tf);
		
	}
	public Transaction(int id, String type, float amount) {
		
		this.id = id;
		this.type = type;
		this.amount = amount;
		LocalDateTime lt=LocalDateTime.now();
		DateTimeFormatter tf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		this.dateAndHour=lt.format(tf);
	
		
	}
	@Override
	public Object clone()  {
		Transaction copy=new Transaction();
		copy.id=id;
		copy.type=type;
		copy.amount=amount;
		copy.dateAndHour=dateAndHour;
		return copy;
		
	}
	@Override
	public String toString() {
		return "Id: "+id+"\nType: "+type+"\nAmount: "+amount+"\nDate and Hour: "+dateAndHour;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDateAndHour() {
		return dateAndHour;
	}
	
	public void saveData()
	{  
	try {
	    FileWriter myWriter = new FileWriter("YourTransaction.txt");
	    myWriter.write("Id: "+this.id+"\nType: "+this.type+"\nAmount: "+this.amount+"\nDate and Hour: "
	    		+this.dateAndHour);
	    myWriter.close();
	    System.out.println("Successfully wrote to the file.");
	  } catch (IOException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	  }
		
	}
	
	
	

}
