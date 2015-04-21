package com.example.calljiniey;

/*
 * Class from problem description of each device
 * 
 */
public class ProblemDevice {
	
	int problemId;
	int deviceId;
	String desc;
	public int getProblemId() {
		return problemId;
	}
	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public ProblemDevice(int problemId, int deviceId, String desc) {
		super();
		this.problemId = problemId;
		this.deviceId = deviceId;
		this.desc = desc;
	}
	



}
