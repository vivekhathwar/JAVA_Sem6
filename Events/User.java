package Events;
import java.util.*;

class Event implements Comparable<Event>{
	String name;
	String type;
	int month;
	
	Event(String n,String t,int m){
		name=n;type=t;month=m;
	}
	
	int getMonth() {
		return(month);
	}
	
	public String toString() {
		return("The event "+name+" of month "+month+" is a "+type+" event");
	}
	
	public int compareTo(Event a) {
		return name.compareTo(a.name);
	}
}

class EventHandler{
	ArrayList<Event> ev=new ArrayList<Event>();
	void newEvent(String name,String type,int m) {
		Event e=new Event(name,type,m);
		ev.add(e);
	}
	
	void addByMonth(int m) {
		Scanner s=new Scanner(System.in);
		while(true) {
			System.out.println("Enter the name and type of event or X to terminate");
			String n=s.next();
			if(!n.equals("X")) {
				String t=s.next();
				Event e=new Event(n,t,m);
				ev.add(e);
			}
			else break;
		}
	}
	
	void deleteByMonth(int m) {
		ArrayList<Event> rl=new ArrayList<Event>();
		for(Event e:ev) {
			if(e.getMonth()<m) {
				rl.add(e);
			}
		}
		ev.removeAll(rl);
	}
	
	void displayByMonth(int m) {
		for(Event e:ev) {
			if(e.getMonth()==m)
			System.out.println(e);
		}
	}
	
	void display() {
		for(Event e:ev) {
			System.out.println(e);
		}
	}
	
	void sortByName() {
		Collections.sort(ev);
		display();
	}
	
	void sortByMonth() {
		MonthComparator m=new MonthComparator();
		Collections.sort(ev, m);
		display();
	}
}

class MonthComparator implements Comparator<Event>{
	public int compare(Event e1,Event e2) {
		return(e1.getMonth()-e2.getMonth());
	}
}

public class User {
	public static void main(String args[]) {
		EventHandler E=new EventHandler();
		Scanner s=new Scanner(System.in);
		System.out.println("1:New event,2:Enter by month,3:delete by month,4:sort by month,5:sort by name,6:display by month,7:display,8:exit");
		while(true) {
			System.out.println("Enter the choice");
			int ch=s.nextInt();
			if(ch==8) break;
			switch(ch) {
			case 1:System.out.println("Enter the name,type and month of the event");
					String name=s.next();
					String type=s.next();
					int m=s.nextInt();
					E.newEvent(name, type, m);
					break;
			case 2:System.out.println("Enter the month");
					E.addByMonth(s.nextInt());
					break;
			case 3:System.out.println("Enter the month");
					E.deleteByMonth(s.nextInt());
					break;
			case 4:E.sortByMonth();
					break;
			case 5:E.sortByName();
					break;
			case 6:System.out.println("Enter the month");
					E.displayByMonth(s.nextInt());
					break;
			case 7:E.display();
					break;
			default:System.out.println("Wrong entry of choice");
			}
		}
		s.close();
	}
}
