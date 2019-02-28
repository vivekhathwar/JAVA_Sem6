import java.util.*;
class Book implements Comparable<Book>{
	String title;
	String author;
	String publisher;
	Float price;
	Book(String n,String a,String p,Float pr){
		title=n;author=a;publisher=p;price=pr;
	}
	
	public int compareTo(Book b){
		return price.compareTo(b.price);
	}
	
	public String toString(){
		return(title+","+author+" by "+publisher+"\nCost:"+price);
	}
}


public class DataBase {
	static LinkedList<Book> lib=new LinkedList<Book>();
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		System.out.println("1:Add new book,2:Print sorted list,3:exit");
		while(true){
			System.out.println("Enter the choice");
			int ch=s.nextInt();
			if(ch==3) break;
			switch(ch){
			case 1:System.out.println("Enter the book details");
					String t=s.next();
					String a=s.next();
					String p=s.next();
					Float pr=s.nextFloat();
					Book b=new Book(t,a,p,pr);
					lib.add(b);break;
			case 2:LinkedList<Book> asc=new LinkedList<Book>(lib);
					Collections.sort(asc);
					for(Book bo:asc){
						System.out.println(bo);
					}
					for(Book b2:lib){
						System.out.println(b2);
					}
					break;
			}
		}
		s.close();
	}
}
