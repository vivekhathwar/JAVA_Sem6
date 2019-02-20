package pack1;
import java.util.ArrayList;

public class customer {
String id,name;
ArrayList<Item> items=new ArrayList<Item>();
int asso;

public customer(String id,String name,int ass, ArrayList<Item> items){
	this.id=id;
	this.name=name;
	this.items=items;
	asso=ass;
}
public int numberOfItems(){
	return(items.size());
}

public void display(){
	System.out.println("The customer "+name+" of id "+id+" has bought "+numberOfItems()+" items");
}

public int assosciation(){
	return(asso);
}

public String toString(){
	return(name);
}

}

