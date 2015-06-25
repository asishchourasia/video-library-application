package EnumRelated;

import javax.swing.JOptionPane;



public class MsgBox {
	
	 public static void signal(enumMsgBox type){
			if(type==enumMsgBox.LOGINSUCCESSFULL)
			  {
				
				JOptionPane.showMessageDialog(null, "Login Successfull!!", null,1);
			  }
			  if(type==enumMsgBox.INVALIDLOGIN)
			  {
				  JOptionPane.showMessageDialog(null,"Invalid Login Details!!", null, 0);
		      }
			  if(type==enumMsgBox.ENTERREQUIREDFIELDS)
			  {
				  JOptionPane.showMessageDialog(null,"Please Enter All Required Fields!!", null, 2);
		      }
			  if(type==enumMsgBox.REGISTERSUCCESSFULL)
			  {
				JOptionPane.showMessageDialog(null,"Registered Successfully", null, 1);
			  }
			  if(type==enumMsgBox.DELETED)
			  {
				  JOptionPane.showMessageDialog(null,  "Deleted", null, 1);
		      }
			  if(type==enumMsgBox.INCORRECTID)
			  {
				  JOptionPane.showMessageDialog(null,  "Incorrect ID", null, 0);
		      }
			  if(type==enumMsgBox.DATASAVEDSUCCESSFULLY)
			  {
				  JOptionPane.showMessageDialog(null,  "Data Saved Successfully!!", null, 1);
		      }
			  if(type==enumMsgBox.INCORRECTMEDIAID)
			  {
				  JOptionPane.showMessageDialog(null,  "Incorrect Media ID!!", null, 0);
		      }
			  if(type==enumMsgBox.ISSUED)
			  {
				JOptionPane.showMessageDialog(null, "Issued", null, 1);
			  }
			  if(type==enumMsgBox.RECIEVED)
			  {
				  JOptionPane.showMessageDialog(null,  "Recieved", null, 1);
		      }
			  if(type==enumMsgBox.CANTWRITETODATA)
			  {
				  JOptionPane.showMessageDialog(null,  "Can't Write To Database", null, 0);
		      }
			  if(type==enumMsgBox.NOCUSTOMERAVAILABLE)
			  {
				  JOptionPane.showMessageDialog(null,  "No Customer Available", null, 2);
		      }
			  if(type==enumMsgBox.ERROR)
			  {
				  JOptionPane.showMessageDialog(null,  "Error", null, 0);
		      }
			  if(type==enumMsgBox.PLEASEENTERID)
			  {
				  JOptionPane.showMessageDialog(null,  "Please Enter ID..", null, 2);
		      }
		}


}
