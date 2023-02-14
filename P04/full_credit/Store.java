import java.util.Scanner;
import java.util.ArrayList;


public class Store
{
	private static ArrayList<Product> products =  new ArrayList<Product>();
	private static ArrayList<Product> shoppingCart = new ArrayList<Product>();
	
	
	public static void main(String[] args)
	{
		Taxfree TF1 = new Taxfree("milk",2.85);
		Taxfree TF2 = new Taxfree("bread",1.99);
		Taxfree TF3 = new Taxfree("cheese",0.85);
		Taxfree TF4 = new Taxfree("eggs",6.95);
		Taxed T1 = new Taxed("icecream", 4.95);
		T1.setTaxRate(0.83);
		Taxed T2 = new Taxed("poptarts", 3.49);
		T2.setTaxRate(0.37);
		Taxed T3 = new Taxed("oreos", 5.99);
		T3.setTaxRate(0.45);
		products.add(TF1);
		products.add(TF2);
		products.add(TF3);
		products.add(TF4);
		products.add(T1);
		products.add(T2);
		products.add(T3);

		try
		{
			int i = 0;
			double total=0.0;
			Scanner in =new Scanner(System.in);
			
			while(i != -1)
			{
				System.out.println("========================\n");
				System.out.println("Welcome to the Store\n");
				System.out.println("========================\n");
				
				for(int k = 0; k<products.size(); k++)
				{
					System.out.println(k + ")" + products.get(k).toString() + "\n");
				}
				
				System.out.println("\n\nCurrent Order\n");
				System.out.println("------------------\n\n");

				for (int j = 0 ; j < shoppingCart.size(); j++)
				{
					System.out.println(shoppingCart.get(j).toString() + "\n");
					total += shoppingCart.get(j).price();
				}
				
				System.out.println("Total price: $" + String.format("%.2f",total) + "\n");
				int choice=0;
				System.out.println("Buy which product?"+ "\n");
				choice = in.nextInt();
				shoppingCart.add(products.get(choice));
			}

		}catch(Exception e)
		{

		}
	//return 0;
	}
}
