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
		return title.compareTo(b.title);
	}
	public String toString(){
		return(title+","+author+" by "+publisher+"\nCost:"+price);
	}
}

class PriceComparator implements Comparator<Book>{
	public int compare(Book b1,Book b2){
		float flag=(b1.price-b2.price);
		int f=(int)(flag);
		return(f);
	}
}

public class Data {
	static LinkedList<Book> lib=new LinkedList<Book>();
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		System.out.println("1:Add new book,2:Print price sorted list,3:Name sorted list,4:exit");
		while(true){
			System.out.println("Enter the choice");
			int ch=s.nextInt();
			if(ch==4) break;
			PriceComparator pc=new PriceComparator();
			switch(ch){
			case 1:System.out.println("Enter the book details");
					String t=s.next();
					String a=s.next();
					String p=s.next();
					Float pr=s.nextFloat();
					Book b=new Book(t,a,p,pr);
					lib.add(b);break;
			case 2:LinkedList<Book> asc=new LinkedList<Book>(lib);
					Collections.sort(asc,pc);
					for(Book bo:asc){
						System.out.println(bo);
					}
					break;
			case 3:LinkedList<Book> as=new LinkedList<Book>(lib);
					Collections.sort(as);
					for(Book bb:as)
						System.out.println(bb);
			}
		}
		s.close();
	}
}
