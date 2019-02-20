package pack2;
import java.util.ArrayList;
import java.util.Scanner;
import pack1.*;

interface megastore{
	ArrayList<customer> cus=new ArrayList<customer>();
	void displayItems();
	void newCustomer();
}

class RITMart implements megastore{
	public void newCustomer(){
		System.out.println("Enter the customer details id,name and assosciated years");
		Scanner s=new Scanner(System.in);
		String id=s.next();
		String name=s.next();
		int y=s.nextInt();
		System.out.println("Enter the number of items and then items");
		ArrayList<Item> items= new ArrayList<Item>();
		int n=s.nextInt();
		int i=0;
		while(i<n)
		{
			System.out.println("Enter name and cost of item");
			String na=s.next();
			float co=s.nextFloat();
			Item a=new Item(na,co);
			items.add(a);
			i++;
		}
		customer cc= new customer(id,name,y,items);
		cus.add(cc);
		//s.close();
	}
	
	public void displayItems(){
		for(customer c: cus){
			if(c.numberOfItems()>5){
				c.display();
			}
		}
	}
	
	public void senior(){
		System.out.println("The customers with more than 5 years of assosiation are");
		for(customer c: cus){
			if(c.assosciation()>5){
				System.out.println(c);
			}
		}
	}
}

public class MAin {
public static void main(String args[]){
	RITMart r=new RITMart();
	System.out.println("1: new Customer,2: Senior customer,3: Bought more than 5,4: exit");
	int ch=0;
	Scanner s=new Scanner(System.in);
	while(true){
		System.out.println("Enter the choice");
		ch=s.nextInt();
		if(ch==4) break;
	switch(ch){
	case 1: r.newCustomer();break;
	case 2: r.senior();break;
	case 3: r.displayItems();break;
	}
	}
	s.close();
}
}

