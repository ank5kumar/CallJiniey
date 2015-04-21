package com.example.calljiniey;

public class Device {
	
	private int id;
	private String deviceName;
	private String url ;
	public Device(int id, String deviceName, String url) {
		super();
		this.id = id;
		this.deviceName = deviceName;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
