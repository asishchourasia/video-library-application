package ClassRelated;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewMemberDetails extends JFrame 
{
	private JLabel l1;
	//private JButton delete;
	private ArrayList<Customer> list;
	Customer reg;
	
	
	
	
	public ViewMemberDetails(int id)
	{
		super("CustomerDetails");
		
		
		
		Font f1=new Font("TIMES NEW ROMAN",Font.PLAIN,18);
		l1=new JLabel("Customer Details");
		l1.setFont(f1);
	     l1.setForeground(Color.blue);
		Container c=getContentPane();
		c.setLayout(new GridLayout(10,2));
		
		
		list =new ArrayList<Customer>();
		
		int f=0;
		try
		{
			/*FileInputStream fin=new FileInputStream("NwCustomerDB");
			ObjectInputStream oin=new ObjectInputStream(fin);
			list=(ArrayList<NwCustomer>)oin.readObject();*/
			
			list=FileReadWrite.readingFromCustomerDB();
			for(Customer r : list)
			{
				if(r.getUserid()==id)
				{
					reg=r;
					f=1;
					break;
				}
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(f==1)
		{
		
		c.add(l1);      c.add(new JLabel(""));
		c.add(new JLabel("Customer Name :"));		c.add(new JLabel(reg.getName()));
		c.add(new JLabel(" Customer ID :"));		c.add(new JLabel(""+reg.getUserid()));
		c.add(new JLabel("Customer Password :"));	c.add(new JLabel(reg.getPassword()));
		c.add(new JLabel("Customer Address :"));	c.add(new JLabel(reg.getAddress()));
		c.add(new JLabel("Customer gender :"));		c.add(new JLabel(reg.getGender()));
		c.add(new JLabel("Customer DOB :"));		c.add(new JLabel(reg.getDobirth()));
		c.add(new JLabel("Customer DATE of Reg :"));c.add(new JLabel(reg.getDoreg()));
		c.add(new JLabel("Customer City :"));		c.add(new JLabel(reg.getCity()));
		//delete=new JButton("Delete");
		//delete.addActionListener(this);
		
		//c.add(delete);
		
		}
		else
		{
			add(new JLabel("Record not found...."));
		}
		setSize(550,400);
		setResizable(false);
		setLocation(400,400);
		setVisible(true);	

}
}
