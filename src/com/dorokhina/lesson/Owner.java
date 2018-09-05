package com.dorokhina.lesson;

import java.io.Serializable;

public class Owner implements Serializable{
	public Owner(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Owner [name=" + name + "]";
	}
	
}
