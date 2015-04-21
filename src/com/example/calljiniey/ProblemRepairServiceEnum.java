package com.example.calljiniey;

public enum ProblemRepairServiceEnum {
	
	AC_NOT_WORKING(RepairServiceEnum.AC,1,"Ac Not Working"),

	AC_INSTALLATION(RepairServiceEnum.AC,2,"Ac AC installation"),

	AC_REMOVAL(RepairServiceEnum.AC,3,"AC Removal");

	
	RepairServiceEnum device;
	
	int problemId;
	
	String description;
	
	ProblemRepairServiceEnum(RepairServiceEnum d,int i,String desc)
	{
		problemId=i;
		device=d;
		description=desc;
	
	}

	public RepairServiceEnum getDevice() {
		return device;
	}

	public int getProblemId() {
		return problemId;
	}

	public String getDescription() {
		return description;
	}
	
	

}
