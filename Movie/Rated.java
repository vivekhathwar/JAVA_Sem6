package Movie;
import java.util.*;
class Movie implements Comparable<Movie>{
	private String name;
	private int rating;
	private int year;
	
	Movie(String n,int r,int y){
		name=n;year=y;
		rating=r;
	}
	
	int getYear() {
		return(year);
	}
	
	int getRating() {
		return(rating);
	}
	
	String getName() {
		return(name);
	}
	
	public int compareTo(Movie m) {
		return(year-m.getYear());
	}
	public String toString() {
		return(name+" with rating "+rating+" released in "+year);
	}
}
class RatingComparator implements Comparator<Movie>{
	public int compare(Movie m1,Movie m2) {
		Integer mm1=m1.getRating();
		Integer mm2=m2.getRating();
		return(mm1.compareTo(mm2));
	}
}

class NameComparator implements Comparator<Movie>{
	public int compare(Movie m1,Movie m2) {
		return(m1.getName().compareTo(m2.getName()));
	}
}
public class Rated {
	ArrayList<Movie> ml=new ArrayList<Movie>();
	void display() {
		for(Movie m:ml) {
			System.out.println(m);
		}
	}	
	void addMovie(String name,int rating,int year){
		Movie m=new Movie(name,rating,year);
		ml.add(m);
	}
	
	public static void main(String args[]) {
		Rated r=new Rated();
		Scanner s=new Scanner(System.in);
		System.out.println("1:Add movie, sort by name,3:sort by year,4:sort by rating");
		while(true) {
			System.out.println("Enter the option");
			int ch=s.nextInt();
			if(ch==5) break;
			switch(ch) {
			case 1:r.addMovie(s.next(), s.nextInt(), s.nextInt());
					break;
			case 2:NameComparator n=new NameComparator();
					Collections.sort(r.ml, n);
					r.display();
					break;
			case 3:Collections.sort(r.ml);
					r.display();
					break;
			case 4:RatingComparator rt=new RatingComparator();
					Collections.sort(r.ml, rt);
					r.display();
					break;
			}
		}
		s.close();
	}
}
