import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Details extends JFrame implements ActionListener,ItemListener{
	static JLabel ti=new JLabel("Title:");
	static JTextField title=new JTextField(10);
	static JLabel au=new JLabel("Author");
	static JTextField author=new JTextField(10);
	static JLabel ra=new JLabel("Price range:");
	static JCheckBox high;
	static JCheckBox equal;
	static JCheckBox low;
	static JButton insert;
	static JTextArea det;
	static String cost="";
	static JFrame f;
	static String cats[]={"coms","nets","progsec","language"};
	static JComboBox com=new JComboBox(cats);
	Details(){
	}
		
	public static void main(String args[]){
		Details d=new Details();
		f=new JFrame("Books");
		f.setLayout(new FlowLayout());
		JPanel cont=new JPanel();
		cont.setLayout(new FlowLayout());
		high = new JCheckBox(">500");
        equal = new JCheckBox("=500");
        low = new JCheckBox("<500");
        insert=new JButton("insert");
        det =new JTextArea(10,10);
        f.add(ti);
        f.add(title);
        f.add(au);
        f.add(author);
        f.add(ra);
        high.addItemListener(d);
        cont.add(high);
        equal.addItemListener(d);
        cont.add(equal);
        low.addItemListener(d);
        cont.add(low);
        f.add(cont);
        f.add(com);
        f.add(det);
        f.add(insert);
		f.setSize(300,500);
		f.show();
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		insert.addActionListener(d);
	}
	
	public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
        if (s.equals("insert")) { 
            // set the text of the label to the text of the field 
            det.setText(author.getText()+" "+title.getText()+" and cost is "+cost+" "+com.getSelectedItem());
        } 
    }
	public void itemStateChanged(ItemEvent e) 
    { 
        // if the state of checkbox1 is changed 
        if (e.getSource() == high) { 
            if (e.getStateChange() == 1) 
                cost=cost+"\nCost >500 is selected";
            else
            	cost=cost+"\nCost >500 not selected";
        } 
  
        // if the state of checkbox2 is changed 
        if(e.getSource()== low){ 
            if (e.getStateChange() == 1) 
                cost=cost+"\nCost < 500 is selected";
            else
            	cost=cost+"\n Cost <500 is not selected";
        }
        if(e.getSource()== equal ){
        	if(e.getStateChange()==1)
        		cost=cost+"\nCost = 500 is selected";
        	else
        		cost=cost+"\nCost =500 is not selected";
        }
    
    } 
}
