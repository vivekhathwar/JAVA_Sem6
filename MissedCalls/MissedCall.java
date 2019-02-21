package p1;
import java.util.*;

class Call {
	String number;
	String name;
	Calendar c;
	
	Call(String n,String no,Calendar ca){
		name=n;
		number=no;
		c=ca;
	}
	
	public String toString(){
		return("The miss call is by "+name+" at "+c.getTime()+" through "+number);
	}
}

class CallHandler{
	LinkedList<Call> mc=new LinkedList<Call>();
	HashMap<String,String> con= new HashMap<String,String>();
	Scanner s=new Scanner(System.in);
	void newContact(String name,String num){
		if(con.containsKey(num))
			System.out.println("The contact exist "+con.get(num));
		else{
			con.put(num, name);
			System.out.println("Contact added");
		}
	}
	
	void newMissCall(String num){
		Calendar c= Calendar.getInstance();
		if(mc.size()==5){
			mc.removeFirst();
		}
		if(con.containsKey(num)){
			String name=con.get(num);
			Call ca=new Call(name,num,c);
			mc.add(ca);
		}
		else{
			String name="Private Caller";
			Call ca=new Call(name,num,c);
			mc.add(ca);
		}
	}

	void displayCalls(){
		ArrayList<Call> rl=new ArrayList<Call>();
		if(mc.size()==0){
			System.out.println("No missed calls");
		}
		else{
		for(Call c:mc){
			System.out.println(c);
			System.out.println("1:Continue or 2: Delete the call");
			int ch=s.nextInt();
			if(ch==2){
				rl.add(c);
			}
		}
		mc.removeAll(rl);
		}
	}
	
	void deleteNumber(String number){
		ArrayList<Call> rl=new ArrayList<Call>();
		for(Call c:mc)
			if(c.number.equals(number)) rl.add(c);
		mc.removeAll(rl);
	}
}

public class MissedCall {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallHandler ch=new CallHandler();
		int cas;
		Scanner s=new Scanner(System.in);
		System.out.println("1:Add contact,2:New Missed Call,3:Display all calls,4:Delete miss call by a number,5:exit");
		while(true){
			System.out.println("Enter the choice");
			cas=s.nextInt();
			if(cas==5) break;
			switch(cas){
			case 1: System.out.println("Enter name and number");
					String nam=s.next();
					String num=s.next();
					ch.newContact(nam, num);
					break;
			case 2: System.out.println("Enter the number");
					num=s.next();
					ch.newMissCall(num);
					break;
			case 3: ch.displayCalls();
					break;
			case 4: System.out.println("Enter the number to be deleted");
					num=s.next();
					ch.deleteNumber(num);
					break;
			}
		}
		s.close();
	}
}
