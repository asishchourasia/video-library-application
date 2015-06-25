package ClassRelated;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import EnumRelated.MsgBox;
import EnumRelated.enumMsgBox;

public class DeleteMediaDetails extends JFrame implements ActionListener {

	private JLabel l1;
	private JButton delete;
	private ArrayList<Media> list;
    Media reg;
	
	
	
	
	public DeleteMediaDetails(int id)
	{
		super("Delete Media Details");
		
		
		
		Font f1=new Font("ALGERIAN",Font.PLAIN,18);
		l1=new JLabel("Media Details");
		l1.setFont(f1);
	     l1.setForeground(Color.blue);
		Container c=getContentPane();
		c.setLayout(new GridLayout(10,2));
		
		
		list =new ArrayList<Media>();
		
		int f=0;
		try
		{
			
			list=FileReadWrite.readingFromMediaDB();
			for(Media r : list){
				if(r.getMediaid()==id)
				{
					reg=r;
					f=1;
					break;
				}
				
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(f==1)
		{
		
		c.add(l1);      c.add(new JLabel(""));
		c.add(new JLabel("Media Title :"));		c.add(new JLabel(reg.getTitle()));
		c.add(new JLabel("Media ID :"));		c.add(new JLabel(""+reg.getMediaid()));
		c.add(new JLabel("Actor :"));	c.add(new JLabel(reg.getActor()));
		c.add(new JLabel("Actress :"));	c.add(new JLabel(reg.getActress()));
		c.add(new JLabel("Director :"));		c.add(new JLabel(reg.getDirector()));
		c.add(new JLabel("Price:"));		c.add(new JLabel(reg.getPrice()));
		c.add(new JLabel("Ratings :"));c.add(new JLabel(reg.getRatings()));
		c.add(new JLabel("Copies :"));		c.add(new JLabel(""+reg.getCopies()));
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
		setLocation(350,300);
		setVisible(true);	
		
	}
	

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==delete)
		{
		list.remove(list.indexOf(reg));
			try
			{
				
			
				FileReadWrite.writingToMediaDB(list);
				MsgBox.signal(enumMsgBox.DELETED);//enum used
				setVisible(false);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
}
