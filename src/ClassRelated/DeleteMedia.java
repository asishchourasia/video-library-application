package ClassRelated;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import EnumRelated.MsgBox;
import EnumRelated.enumMsgBox;

public class DeleteMedia extends JFrame implements ActionListener
{
	 private JButton ok,clr;
	 private JLabel lblmsg,lblmediaid;
	 private JTextField txtmediaid;
	 
	
	
	public DeleteMedia()
	{
		super("Delete Media");
		
		
		ok=new JButton("Ok");
		ok.addActionListener(this);
		clr=new JButton("Clear");
		clr.addActionListener(this);
		
		
		
		Font f1=new Font("TIMES NEW ROMAN",Font.PLAIN,18);
		lblmsg=new JLabel("Delete Media");
		lblmsg.setFont(f1);
		lblmsg.setForeground(Color.blue);
		lblmediaid =new JLabel("Enter ID");
		lblmediaid.setFont(f1);
		lblmediaid.setForeground(Color.BLACK);
		
		
		txtmediaid=new JTextField(20);
		
		
		
		
		setLayout(new GridLayout(3,2));
		
		add(lblmsg);
		add(new JLabel(""));
		add(lblmediaid);
		add(txtmediaid);
		
		add(ok);
		add(clr);
	
		setVisible(true);
		setSize(400,130);
		setLocation(200,300);
		setResizable(false);
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	  if(ae.getSource()==ok)
	  {
		  
				if(txtmediaid.getText().equals(""))
				{
					MsgBox.signal(enumMsgBox.PLEASEENTERID);
					}
				else
				{

					int id=Integer.parseInt(txtmediaid.getText().trim());
					new DeleteMediaDetails(id);
				}
				setVisible(true);
				}
		  
	  else if(ae.getSource()==clr)
	  {
		  txtmediaid.setText("");
		  txtmediaid.setText("");
		  
	  }
	 
	}
}
