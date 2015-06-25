package ClassRelated;

import java.io.Serializable;

public class Media implements Serializable {

	private String title;
	private String actor;
	private String actress;
	private String director;
	private String price;
	private int mediaid;
	private String ratings;
	private int copies;
	private int availablecopies;
	public Media(String title, String actor, String actress, String director,
			String price, int mediaid, String ratings, int copies) {
		super();
		this.title = title;
		this.actor = actor;
		this.actress = actress;
		this.director = director;
		this.price = price;
		this.mediaid = mediaid;
		this.ratings = ratings;
		this.copies = copies;
		availablecopies=copies;
	}
	public void setAvailablecopies(int availablecopies) {
		this.availablecopies = availablecopies;
	}
	public int getAvailablecopies() {
		return availablecopies;
	}
	public String getTitle() {
		return title;
	}
	public String getActor() {
		return actor;
	}
	public String getActress() {
		return actress;
	}
	public String getDirector() {
		return director;
	}
	public String getPrice() {
		return price;
	}
	public int getMediaid() {
		return mediaid;
	}
	public String getRatings() {
		return ratings;
	}
	public int getCopies() {
		return copies;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setMediaid(int mediaid) {
		this.mediaid = mediaid;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}	
}
