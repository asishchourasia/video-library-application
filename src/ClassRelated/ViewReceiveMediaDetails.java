package ClassRelated;


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
public class ViewReceiveMediaDetails extends JFrame{
	 private JTable table;
	  private ArrayList<ReceiveMedia> receivelist;
	private String [] heading={"CUSTOMER ID","MEDIA ID","DATE OF RECEIVE","FINE TO BE PAID"};
	private String data [][];
	private JScrollPane pane;
	public ViewReceiveMediaDetails(){
		
		receivelist =new ArrayList<ReceiveMedia>();
		try
		{
			receivelist=FileReadWrite.readingFromReceiveDB();
		}
		catch(Exception exp)
		{
			System.out.println("No Records");
		}
		
		
		data = new String[receivelist.size()][4];
		//get object from list
		int index=0,row=0,col=0;
		for(index=0;index<receivelist.size();index++)
		{
			ReceiveMedia receivemedia=receivelist.get(index);
			data[row][col]=""+receivemedia.getCustomerid();
		    data[row][++col]=""+receivemedia.getMediaid();
			data[row][++col]=receivemedia.getDateofreceive();
			data[row][++col]=""+receivemedia.getFine();
			
				col=0;
			     ++row;
			
			
			
}
		
		table= new JTable(data,heading);
		pane=new JScrollPane(table);
		add(pane);
		
		    setSize(500,200);
			setTitle("VIEW RECEIVE DETAILS");
			setVisible(true);
		
		


	}
}