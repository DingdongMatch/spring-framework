package com.match.bean;

public class ITestBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ITestBean{" +
				"name='" + name + '\'' +
				'}';
	}
}
