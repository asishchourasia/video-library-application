package ClassRelated;

import java.util.ArrayList;

import EnumRelated.MsgBox;
import EnumRelated.enumMsgBox;

public class SetAdminPassword 

{
	
	 private ArrayList<Admin>list;
	 
	 
	
	
	 
	 
	
	public SetAdminPassword() throws Exception
	{
		
		//MsgBox.signal(enumMsgBox.CANTWRITETODATA);//enum used

		list=new ArrayList<Admin>();
		 list.add(getAdmin());
		 FileReadWrite.writingToAdminDB(list);	
		

	}
	public Admin getAdmin()
	{
		String adminid="1";
		String adminpassword="asish";
		
		
		Admin admin=new Admin(adminid,adminpassword);
		
		
		return admin ;
	}
	
	
	
}
