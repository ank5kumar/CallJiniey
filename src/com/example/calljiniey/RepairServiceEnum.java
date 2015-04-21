package com.example.calljiniey;

public enum RepairServiceEnum {

	AC(1,"Air Conditioner"),
	TV(2,"Television"),
	Fridge(3,"Fridge"),
	WashingMachine(4,"Washing Machine"),
	Chimney(5,"Kitchen Chimeny"),
	Desktop(6,"Personal Computer"),
	Laptop(7,"Laptops");

	int id;
	String name;
	RepairServiceEnum(int i,String n) {
		id = i;
		name =n;
	}
	int showId() {
		return id;
	} 

	String GetDeviceName( )
	{
		return name;

	}

}
