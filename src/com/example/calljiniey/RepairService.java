package com.example.calljiniey;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;


public class RepairService {
	
	private String deviceName;
	
	private ArrayList<ProblemRepairServiceEnum> potentialProblems = new ArrayList<ProblemRepairServiceEnum>();
	
	
	private UUID mId;
	private String mTitle;
	private Date mDate;
	private boolean mSolved;
	
	public RepairService() {
		// Generate unique identifier
		this.mId = UUID.randomUUID();
		this.mDate = new Date();
		this.mTitle = "fuccckkkk";
		
		}

	
	
	@Override
	public String toString() {
		return "Crime [mTitle=" + mTitle + "]";
	}



	public Date getDate() {
		return mDate;
	}


	public void setDate(Date date) {
		mDate = date;
	}


	public boolean isSolved() {
		return mSolved;
	}


	public void setSolved(boolean solved) {
		mSolved = solved;
	}


	public UUID getId() {
		return mId;
	}

	public void setId(UUID id) {
		mId = id;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}
	
	
}
