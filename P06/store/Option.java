package store;

public class Option
{
 	protected String name;
 	protected long cost;
 	
 	public Option(String name, long cost)
 	{
 		this.name = name;
 		this.cost = cost;
 		
 		if(cost < 0)
 		{
 		 	throw new IllegalArgumentException("Invalid cost: Cost shold be greter than 0");
 		}
 	}
 	
 	public Option(String name)
 	{
 		this.name = name;
 		this.cost = 0;
 		
 	}
 	
 	public long cost()
 	{
 		return cost;
 	}
 	
 	@Override
 	public String toString()
 	{
 		return name + "($" + cost + ")\n";
 	}
 	
 	@Override
 	public boolean equals(Object o)
	{	
		if (o == this)
		{
            		return true;
        	}
        	if (!(o instanceof Option)) 
        	{
            		return false;
        	}
        	Option c = (Option) o;
        	return this.name.equals(c.name) && this.cost == c.cost;	
	}
}
