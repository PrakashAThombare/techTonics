package model;

import java.util.Date;

public class Techtalkpojo {
	public int techId;
  public Date presentationdate;
  public String description;
  public String title;
  public String presentor;
public Techtalkpojo() {
	super();
}

public int getTechId() {
	return techId;
}

public void setTechId(int techId) {
	this.techId = techId;
}

public Techtalkpojo(int techId, Date presentationdate, String description, String title, String presentor) {
	super();
	this.techId = techId;
	this.presentationdate = presentationdate;
	this.description = description;
	this.title = title;
	this.presentor = presentor;
}

public Date getPresentationdate() {
	return presentationdate;
}
public void setPresentationdate(Date presentationdate) {
	this.presentationdate = presentationdate;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getPresentor() {
	return presentor;
}
public void setPresentor(String presentor) {
	this.presentor = presentor;
}
@Override
public String toString() {
	return "Techtalkpojo [presentationdate=" + presentationdate + ", description=" + description + ", title=" + title
			+ ", presentor=" + presentor + "]";
}
  
}
