package FrameRelated;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.*;

import ClassRelated.FileReadWrite;
import ClassRelated.Media;
import ClassRelated.Customer;
import EnumRelated.MsgBox;
import EnumRelated.enumMsgBox;
public class DisplayAllCustomer extends JFrame{
	 private JTable table;
	  private ArrayList<Customer> list;
	private String [] heading={"USER_ID","NAME","PASSWORD","PHONE","GENDER","DATE OF BIRTH(dd/mm/yy)","CITY","DATE OF REGISTRATION","ADDRESS"};
	private String data [][];
	private JScrollPane pane;
	public DisplayAllCustomer(){
		
		list =new ArrayList<Customer>();
		try
		{
			list=FileReadWrite.readingFromCustomerDB();
		}
		catch(Exception exp)
		{
			System.out.println("No Records");
		}
		
		
		data = new String[list.size()][9];
		//get object from list
		int index=0,row=0,col=0;
		for(index=0;index<list.size();index++)
		{
			Customer customer=list.get(index);
			data[row][col]=""+customer.getUserid();
			data[row][++col]=customer.getName();
		    
			data[row][++col]=customer.getPassword();
			data[row][++col]=customer.getPhone();
			data[row][++col]=customer.getGender();
			data[row][++col]=customer.getDobirth();
			data[row][++col]=customer.getCity();
			data[row][++col]=customer.getDoreg();
			data[row][++col]=customer.getAddress();
			col=0;
			++row;
			
			
			
}
		
		table= new JTable(data,heading);
		pane=new JScrollPane(table);
		add(pane);
		
		    setSize(500,200);
			setTitle("VIEW ALL CUSTOMER");
			setVisible(true);
		
		


	}
}