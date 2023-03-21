package store;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Computer
{
	private String name;
	private String model;
	private ArrayList<Option> options = new ArrayList<>();;
	
	public Computer(String name, String model)
	{
		this.name =name;
		this.model = model;
	}

	public Computer(BufferedReader br) throws IOException {
		name = br.readLine();
		model = br.readLine();
		int numOptions = Integer.parseInt(br.readLine());
		options = new ArrayList<>();
		while (numOptions-- > 0) {
			options.add(new Option(br));
		}
	}

	public void save(BufferedWriter bw) throws IOException {
		bw.write(name + "\n");
		bw.write(model + "\n");
		bw.write(options.size() + "\n");
		for (Option option : options) {
			option.save(bw);
		}
	}

	public String getName()
	{
		return name;
	}
	public void addOption(Option option)
	{
		options.add(option);
	}
	
	public long cost()
	{
		long sum =0;
		for(int i=0;i<options.size();i++)
		{
			sum +=options.get(i).cost();
		}
		return sum;
	} 
	
	@Override
 	public String toString()
 	{
 		System.out.println(name + " (" + model + ")\n");
		for(int i=0;i<options.size();i++)
		{
			System.out.println("\t" + options.get(i).toString());
		}
		return "";
 	}
 	
 	@Override
 	public boolean equals(Object o)
	{	
		if (this == o) 
		{
            		return true;
        	}
        	if (o == null || getClass() != o.getClass()) 
        	{
            		return false;
        	}
        	Computer c = (Computer) o;
        	return name.equals(c.name) && model.equals(c.model) && options.equals(c.options);
	}

}
