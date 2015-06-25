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
public class ViewIssueMediaDetails extends JFrame{
	 private JTable table;
	  private ArrayList<IssueMedia> issuelist;
	private String [] heading={"CUSTOMER ID","MEDIA ID","DATE OF ISSUE","FINE LESS RECEIVE DATE","TRANS ID","HIRING CHARGE","STATUS"};
	private String data [][];
	private JScrollPane pane;
	public ViewIssueMediaDetails(){
		
		issuelist =new ArrayList<IssueMedia>();
		try
		{
			issuelist=FileReadWrite.readingFromIssueDB();
		}
		catch(Exception exp)
		{
			System.out.println("No Records");
		}
		
		
		data = new String[issuelist.size()][7];
		//get object from list
		int index=0,row=0,col=0;
		for(index=0;index<issuelist.size();index++)
		{
			IssueMedia issuemedia=issuelist.get(index);
			data[row][col]=""+issuemedia.getCustomerid();
		    data[row][++col]=""+issuemedia.getMediaid();
			data[row][++col]=issuemedia.getDateofissue();
			data[row][++col]=issuemedia.getDateofreceive();
			data[row][++col]=""+issuemedia.getTransid();
			data[row][++col]=""+issuemedia.getHiringcharge();
			data[row][++col]=""+issuemedia.getStatus();
				col=0;
			     ++row;
			
			
			
}
		
		table= new JTable(data,heading);
		pane=new JScrollPane(table);
		add(pane);
		
		    setSize(500,200);
			setTitle("VIEW ISSUE DETAILS");
			setVisible(true);
		
		


	}
}