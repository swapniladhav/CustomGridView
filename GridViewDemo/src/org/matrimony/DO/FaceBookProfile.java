package org.matrimony.DO;

public class FaceBookProfile {

	private int iconID;
	private String fullName;
	private String Cast;
	private String ageBand;
	private String religion;
	public int getIconID() {
		return iconID;
	}
	public void setIconID(int iconID) {
		this.iconID = iconID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCast() {
		return Cast;
	}
	public void setCast(String cast) {
		Cast = cast;
	}
	public String getAgeBand() {
		return ageBand;
	}
	public void setAgeBand(String ageBand) {
		this.ageBand = ageBand;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public FaceBookProfile(int iconID, String fullName, String cast,
			String ageBand, String religion) {
		super();
		this.iconID = iconID;
		this.fullName = fullName;
		Cast = cast;
		this.ageBand = ageBand;
		this.religion = religion;
	}
 
	
	

}
