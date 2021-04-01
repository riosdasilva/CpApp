package com.jp.cpProject.model;

import javax.persistence.Entity;

@Entity
public class Station extends AbstractEntity {
	private String name;
	private int stationNumber;

	public Station(String name, int stationNumber) {
		this.name = name;
		this.stationNumber = stationNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStationNumber() {
		return stationNumber;
	}

	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}

}
