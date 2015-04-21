package com.example.calljiniey;

import java.util.ArrayList;
import java.util.HashMap;

public class RepairServiceList {

	public static HashMap<RepairServiceEnum,ArrayList<String>> repairServicesNameProblems= new HashMap<RepairServiceEnum, ArrayList<String>>();

	public static void  LoadServices()
	{
		repairServicesNameProblems.put(RepairServiceEnum.AC,GetPossibleProblems(RepairServiceEnum.AC));
		repairServicesNameProblems.put(RepairServiceEnum.TV,GetPossibleProblems(RepairServiceEnum.AC));
		repairServicesNameProblems.put(RepairServiceEnum.Desktop,GetPossibleProblems(RepairServiceEnum.AC));
		repairServicesNameProblems.put(RepairServiceEnum.Fridge,GetPossibleProblems(RepairServiceEnum.AC));


	}

	static ArrayList<String> GetPossibleProblems(RepairServiceEnum device)
	{
		ArrayList<String> possibleProblems = new ArrayList<String>();

		if(RepairServiceEnum.AC==device)
		{
			possibleProblems.add("AC Installation");

			possibleProblems.add("AC Not Working");

			possibleProblems.add("AC Removal");

		}
		if(RepairServiceEnum.TV==device)
		{
			possibleProblems.add("TV Installation");

			possibleProblems.add("TV Not Working");

			possibleProblems.add("Picture Tube Not Workin");

		}
		if(RepairServiceEnum.Desktop==device)
		{
			possibleProblems.add("Heat Sink Not Working");

			possibleProblems.add("Display Not Working");

			possibleProblems.add("Picture Tube Not Workin");

		}

		return possibleProblems;


	}


}
