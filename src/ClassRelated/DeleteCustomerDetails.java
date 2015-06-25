package ClassRelated;

import java.io.FileNotFoundException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import EnumRelated.MsgBox;
import EnumRelated.enumMsgBox;

public class DeleteCustomerDetails extends JFrame implements ActionListener{
	
	private JLabel l1;
	private JButton delete;
	private ArrayList<Customer> list;
	Customer reg;
	
	
	
	
	public DeleteCustomerDetails(int id)
	{
		super("DeleteCustomerDetails");
		
		
		
		Font f1=new Font("TIMES NEW ROMAN",Font.PLAIN,18);
		l1=new JLabel("Customer Details");
		l1.setFont(f1);
	     l1.setForeground(Color.blue);
		Container c=getContentPane();
		c.setLayout(new GridLayout(11,2));
		
		
		list =new ArrayList<Customer>();
		
		int f=0;
		try
		{
			
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
		}
		
		if(f==1)
		{
		
		c.add(l1);      c.add(new JLabel(""));
		
		c.add(new JLabel(" Customer ID :"));		
		c.add(new JLabel(""+reg.getUserid()));
		c.add(new JLabel("Customer Name :"));		
		c.add(new JLabel(reg.getName()));
		
		
		c.add(new JLabel("Customer Password :"));	
		c.add(new JLabel(reg.getPassword()));
		c.add(new JLabel("Customer Phone no:"));

		c.add(new JLabel(reg.getPhone()));
		c.add(new JLabel("Customer gender :"));		
		c.add(new JLabel(reg.getGender()));
		c.add(new JLabel("Customer DOB :"));		
		c.add(new JLabel(reg.getDobirth()));
		c.add(new JLabel("Customer City :"));		
		c.add(new JLabel(reg.getCity()));
		c.add(new JLabel("Customer DATE of Reg :"));
		c.add(new JLabel(reg.getDoreg()));
		c.add(new JLabel("Customer Address :"));	

		c.add(new JLabel(reg.getAddress()));
		
		delete=new JButton("Delete");
		delete.addActionListener(this);
		
		c.add(delete);
		
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
	

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==delete)
		{
		list.remove(list.indexOf(reg));
			try
			{
				
			
				FileReadWrite.writingToCustomerDB(list);
				MsgBox.signal(enumMsgBox.DELETED);//enum used
				setVisible(false);
			}catch(Exception e)
			{
			}
		}
		
	}
	
}
