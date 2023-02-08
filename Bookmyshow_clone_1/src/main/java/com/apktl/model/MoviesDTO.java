package com.apktl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "movies_table")
public class MoviesDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mId;
	
	@Column(name = "movie_image",nullable = false,unique = true,length = 100)
	private String mImage;
	
	@Column(name = "movie_dtls",length = 200)
	private String mDetails;
	
	
	@Column(name = "movie_name",nullable = false,length = 200)
	private String mName;
	
	@Column(name = "movie_language",nullable = false,length = 200)
	private String language;
	
	private String timeOne;
	
	private String timeTwo;
	
	private String timeThree;
	
	private String timeFour;
	
	private String timeFive;
	
	private String timeSix;
	
	public MoviesDTO() {

	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmImage() {
		return mImage;
	}

	public void setmImage(String mImage) {
		this.mImage = mImage;
	}

	public String getmDetails() {
		return mDetails;
	}

	public void setmDetails(String mDetails) {
		this.mDetails = mDetails;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTimeOne() {
		return timeOne;
	}

	public void setTimeOne(String timeOne) {
		this.timeOne = timeOne;
	}

	public String getTimeTwo() {
		return timeTwo;
	}

	public void setTimeTwo(String timeTwo) {
		this.timeTwo = timeTwo;
	}

	public String getTimeThree() {
		return timeThree;
	}

	public void setTimeThree(String timeThree) {
		this.timeThree = timeThree;
	}

	public String getTimeFour() {
		return timeFour;
	}

	public void setTimeFour(String timeFour) {
		this.timeFour = timeFour;
	}

	public String getTimeFive() {
		return timeFive;
	}

	public void setTimeFive(String timeFive) {
		this.timeFive = timeFive;
	}

	public String getTimeSix() {
		return timeSix;
	}

	public void setTimeSix(String timeSix) {
		this.timeSix = timeSix;
	}

	@Override
	public String toString() {
		return "MoviesDTO [mId=" + mId + ", mImage=" + mImage + ", mDetails=" + mDetails + ", mName=" + mName
				+ ", language=" + language + ", timeOne=" + timeOne + ", timeTwo=" + timeTwo + ", timeThree="
				+ timeThree + ", timeFour=" + timeFour + ", timeFive=" + timeFive + ", timeSix=" + timeSix + "]";
	}

	

	
}
