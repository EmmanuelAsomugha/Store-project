package store;
import java.util.ArrayList;

public class Order
{
	private static long nextOrderNumber = 0;
	private long orderNumber;
	private Customer customer;
	private ArrayList<Computer> computers = new ArrayList<>();;
	
	public Order(Customer customer)
	{
		this.customer = customer;
		orderNumber = nextOrderNumber++;
	}
	
	public void addComputer(Computer computer)
	{
		computers.add(computer);
	}
	
	@Override
 	public String toString()
 	{
 	
 		StringBuilder sb = new StringBuilder();
        	sb.append("Order ").append(this.orderNumber).append(" for ");
        	sb.append(this.customer.getName()).append(" (").append(this.customer.getEmail()).append(")\n");
        	for (Computer computer : computers) {
            		sb.append(computer).append("\n");
        	}
        	return sb.toString();
 	}
 	
 	@Override
 	public boolean equals(Object o)
	{	
		if (o == this) 
		{
            		return true;
        	}
        	if (!(o instanceof Order)) 
        	{
            		return false;
        	}
        	Order c = (Order) o;
        	return this.customer.equals(c.customer) && this.computers.equals(c.computers) && this.orderNumber == c.orderNumber;
	}
}
