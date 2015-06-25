package FrameRelated;



import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ClassRelated.Media;
import ClassRelated.FileReadWrite;

public class DisplayAllMedia extends JFrame 
{

	  private JTable table;
	  private ArrayList<Media> list;
	  private String[] heading={"MEDIA ID","TITLE","ACTOR","ACTRESS","DIRECTOR","PRICE","RATINGS","COPIES","AVAILABLE_COPIES"};
	  private String[][] data;
	  private JScrollPane pane;
	  public DisplayAllMedia()
	  {
		list =new ArrayList<Media>();
		try
		{
			list=FileReadWrite.readingFromMediaDB();
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
			Media media=list.get(index);
			data[row][col]=""+media.getMediaid();
			data[row][++col]=media.getTitle();
			data[row][++col]=media.getActor();
			data[row][++col]=media.getActress();
			data[row][++col]=media.getDirector();
		    data[row][++col]=media.getPrice();
			data[row][++col]=media.getRatings();
			data[row][++col]=""+media.getCopies();
			data[row][++col]=""+media.getAvailablecopies();
			
			col=0;
			++row;
			
			
			
}
		
		table= new JTable(data,heading);
		pane=new JScrollPane(table);
		add(pane);
		
		    setSize(500,200);
			setTitle("VIEW ALL MEDIA");
			setVisible(true);
		
		
	  }
	
}
