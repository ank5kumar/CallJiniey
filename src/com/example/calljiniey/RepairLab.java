package com.example.calljiniey;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import android.content.Context;

public class RepairLab {

	private ArrayList<RepairService> mRepairServices;	
	private static RepairLab sCrimeLab;
	private Context mAppContext;
	private RepairLab(Context appContext ){
		mAppContext = appContext;

		mRepairServices = new ArrayList<RepairService>();


		for (int i = 0; i < 100; i++) {
			RepairService c = new RepairService();
			c.setTitle("Crime #" + i);
			c.setSolved(i % 2 == 0); // Every other one
			mRepairServices.add(c);
		}
		Iterator it = RepairServiceList.repairServicesNameProblems.entrySet().iterator();

		while(it.hasNext())
		{
			for (RepairServiceEnum key : RepairServiceList.repairServicesNameProblems.keySet()) {
				

			}

		}
	}
	public static RepairLab get(Context c) {
		if (sCrimeLab == null) {

			sCrimeLab = new RepairLab(c.getApplicationContext());
		}
		return sCrimeLab;
	}

	public ArrayList<RepairService> getCrimes() {
		return mRepairServices;
	}
	public RepairService getCrime(UUID id) {
		for (RepairService c : mRepairServices) {
			if (c.getId().equals(id))
				return c;
		}
		return null;
	}





}