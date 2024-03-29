public abstract class Product
{
	protected double cost;
	protected String name;
	
	
	public Product(String name, double cost)
	{
		this.name = name;
		this.cost = cost;
		if(cost < 0)
		{
		throw new RuntimeException("Invalid cost");
		}
	}
	public abstract double price();
	
	@Override
	public String toString()
	{
		return this.name + "($" + this.cost + ")\t\t$" + String.format("%.2f",price());
	}

}
