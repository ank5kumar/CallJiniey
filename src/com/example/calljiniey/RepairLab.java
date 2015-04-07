package com.example.calljiniey;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class RepairLab {

	private ArrayList<ReapirService> mCrimes;	
	private static RepairLab sCrimeLab;
	private Context mAppContext;
	private RepairLab(Context appContext ) {
		mAppContext = appContext;
		
		mCrimes = new ArrayList<ReapirService>();
		
		
		for (int i = 0; i < 100; i++) {
			ReapirService c = new ReapirService();
			c.setTitle("Crime #" + i);
			c.setSolved(i % 2 == 0); // Every other one
			mCrimes.add(c);
		}
	}
	public static RepairLab get(Context c) {
		if (sCrimeLab == null) {
			
			sCrimeLab = new RepairLab(c.getApplicationContext());
		}
		return sCrimeLab;
	}

	public ArrayList<ReapirService> getCrimes() {
		return mCrimes;
	}
	public ReapirService getCrime(UUID id) {
		for (ReapirService c : mCrimes) {
			if (c.getId().equals(id))
				return c;
		}
		return null;
	}
	
	
	
	
	
}