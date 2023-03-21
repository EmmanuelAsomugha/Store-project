package store;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;


public class Customer
{
	private String name;
	private String email;
	
	public Customer(String name, String email)
	{
		this.name = name;
		this.email = email;
		int verf1=0;
		int verf2=0;
		String []parts;
		for(int i=0;i<email.length();i++)
		{
			if(email.charAt(i) == '@')
			{
				parts = email.split("@");
				verf1++;
				String part2=parts[1];
				for(int j=0;j<part2.length();j++)
				{
					if(part2.charAt(j) == '.')
					{
						verf2++;
					}
				}
			}
			
			
			
		}
		if(verf1 != 1 || verf2 != 1)
		{
			throw new IllegalArgumentException("Invalid Email");
		}
	}

	public Customer(BufferedReader br) throws IOException {
		name = br.readLine();
		email = br.readLine();

	}

	public void save(BufferedWriter bw) throws IOException {
		bw.write(name + '\n');
		bw.write(email + '\n');

	}

	public String getName()
	{
		return name;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	
	@Override
	public String toString()
	{
		return name + " (" + email + ")\n";
	}
	
	
	public boolean equals(Object o)
	{	
		if(o == this)
		{
			return true;
		}
		
		if (!(o instanceof Customer)) 
		{
            		return false;
        	}
        	
        	Customer c = (Customer) o;
        	
        	return this.email.equals(c.email) && this.name.equals(c.name);
		
	}
}
