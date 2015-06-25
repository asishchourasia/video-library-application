package ClassRelated;

import java.io.Serializable;

public class ReceiveMedia implements Serializable
{
	 private int customerid,mediaid,fine;
	   private String dateofreceive;
	public ReceiveMedia(int customerid, int mediaid, String dateofreceive,int fine) {
		super();
		this.customerid = customerid;
		this.mediaid = mediaid;
		this.dateofreceive = dateofreceive;
		this.fine=fine;
		
	}
	
	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public int getCustomerid() {
		return customerid;
	}
	public int getMediaid() {
		return mediaid;
	}
	public String getDateofreceive() {
		return dateofreceive;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public void setMediaid(int mediaid) {
		this.mediaid = mediaid;
	}
	public void setDateofreceive(String dateofreceive) {
		this.dateofreceive = dateofreceive;
	}
	
}
