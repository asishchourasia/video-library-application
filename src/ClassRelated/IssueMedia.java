package ClassRelated;

import java.io.Serializable;

public class IssueMedia implements Serializable
{
   private int customerid,mediaid,transid,hiringcharge;
   private String dateofissue,status,dateofreceive;

public IssueMedia(int customerid, int mediaid, String dateofissue,String dateofreceive,int transid,int hiringcharge,String status) {
	super();
	this.customerid = customerid;
	this.mediaid = mediaid;
	this.dateofissue = dateofissue;
	this.transid = transid;
	this.status=status;
	this.hiringcharge=hiringcharge;
	this.dateofreceive=dateofreceive;
}


public String getDateofreceive() {
	return dateofreceive;
}


public void setDateofreceive(String dateofreceive) {
	this.dateofreceive = dateofreceive;
}


public int getHiringcharge() {
	return hiringcharge;
}

public void setHiringcharge(int hiringcharge) {
	this.hiringcharge = hiringcharge;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}


public int getTransid() {
	return transid;
}

public int getCustomerid() {
	return customerid;
}
public int getMediaid() {
	return mediaid;
}
public String getDateofissue() {
	return dateofissue;
}

public void setTransid(int transid) {
	this.transid = transid;
}

public void setCustomerid(int customerid) {
	this.customerid = customerid;
}
public void setMediaid(int mediaid) {
	this.mediaid = mediaid;
}
public void setDateofissue(String dateofissue) {
	this.dateofissue = dateofissue;
}

}
